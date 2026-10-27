[README_Backend.md](https://github.com/user-attachments/files/34046908/README_Backend.md)
# SOSI – Back End

API REST do **SOSI** (Sistema Operacional de Serviços de Indaiatuba), um portal para registro e acompanhamento de ocorrências urbanas pelos cidadãos de Indaiatuba, com um painel para a prefeitura responder e atualizar o andamento de cada caso.

> Este repositório contém apenas o **back end**. A interface fica no repositório do front end: [ProjetoIntegrador-Frontend](https://github.com/FelipeTbraun/ProjetoIntegrador-Frontend).

## Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 17 | Linguagem |
| Spring Boot | 4.0.6 | Framework |
| Spring Web MVC | — | API REST |
| Spring Data MongoDB | — | Acesso ao banco de dados |
| MongoDB | — | Banco de dados NoSQL |
| Lombok | — | Redução de código repetitivo |
| Spring Boot DevTools | — | Reinício automático em desenvolvimento |
| Maven (wrapper incluído) | — | Build e dependências |

## Pré-requisitos

- [JDK 17](https://adoptium.net/) ou superior
- [MongoDB](https://www.mongodb.com/try/download/community) em execução na porta `27017`
- Não é necessário instalar o Maven: o projeto inclui o wrapper (`mvnw`)

## Configuração

As configurações ficam em `src/main/resources/application.properties`:

| Propriedade | Valor padrão |
|---|---|
| `spring.data.mongodb.host` | `localhost` |
| `spring.data.mongodb.port` | `27017` |
| `spring.data.mongodb.database` | `pi_db` |
| `server.port` | `8080` |

O banco e as coleções (`cidadaos`, `formularios`, `novidades`) são criados automaticamente no primeiro uso.

## Como executar

```bash
# 1. Clone o repositório
git clone https://github.com/FelipeTbraun/ProjetoIntegrador.git
cd ProjetoIntegrador

# 2. Garanta que o MongoDB está rodando em localhost:27017

# 3. Inicie a aplicação
./mvnw spring-boot:run        # Linux / macOS
mvnw.cmd spring-boot:run      # Windows
```

A API ficará disponível em `http://localhost:8080`.

Para gerar o `.jar`:

```bash
./mvnw clean package
java -jar target/PI-0.0.1-SNAPSHOT.jar
```

## Modelo de dados

**Cidadão** (`cidadaos`): `id`, `nome`, `email`, `senha`, `celular`, `cpf`

**Formulário** (`formularios`): `id`, `categoria`, `motivo`, `endereco`, `dataOcorrido`, `descricao`, `anexo`, `status`, `resposta`, `cidadao`

**Novidade** (`novidades`): `id`, `titulo`, `categoria`, `resumo`, `imagemUrl`, `dataPublicacao`

Valores aceitos nos campos de enumeração:

| Campo | Valores |
|---|---|
| `categoria` | `SEGURANCA`, `TRANSITO`, `AMBIENTAL`, `ELETRICA`, `PATRIMONIO`, `OUTRO` |
| `motivo` | `ELOGIO`, `RECLAMACAO`, `SUGESTAO` |
| `status` | `EM_ANALISE`, `EM_ANDAMENTO`, `CONCLUIDO` |

## Endpoints

### Autenticação

| Método | Rota | Descrição |
|---|---|---|
| POST | `/auth/adminlogin` | Login da prefeitura (`login` e `senha`) |
| POST | `/cidadao/login` | Login do cidadão (`login` com o e-mail, e `senha`) |

### Cidadão

| Método | Rota | Descrição |
|---|---|---|
| POST | `/cidadao/cadastro` | Cadastra um cidadão (bloqueia e-mail e CPF duplicados) |
| GET | `/cidadao` | Lista os cidadãos |
| GET | `/cidadao/{id}` | Busca um cidadão |
| PUT | `/cidadao/{id}` | Atualiza um cidadão |
| DELETE | `/cidadao/{id}` | Remove um cidadão |

### Formulários (ocorrências)

| Método | Rota | Descrição |
|---|---|---|
| POST | `/form` | Cria uma ocorrência |
| GET | `/form/cidadao/{cidadaoId}` | Lista as ocorrências de um cidadão |
| GET | `/form/admin` | Lista todas as ocorrências (uso da prefeitura) |
| GET | `/form/admin/{id}` | Busca uma ocorrência (uso da prefeitura) |
| PUT | `/form/status/{id}` | Atualiza status e resposta (uso da prefeitura) |
| DELETE | `/form/excluir/{id}` | Exclui uma ocorrência |

### Novidades

| Método | Rota | Descrição |
|---|---|---|
| GET | `/novidade` | Lista as novidades (usada na Home) |
| POST | `/novidade` | Publica uma novidade (uso da prefeitura) |
| DELETE | `/novidade/{id}` | Exclui uma novidade (uso da prefeitura) |

### Prefeitura

| Método | Rota | Descrição |
|---|---|---|
| POST | `/prefeitura` | Salva um registro de prefeitura |

### Exemplo de requisição

```bash
curl -X PUT http://localhost:8080/form/status/ID_DA_OCORRENCIA \
  -H "Content-Type: application/json" \
  -d '{"status": "EM_ANDAMENTO", "resposta": "Equipe enviada ao local."}'
```

## Estrutura do projeto

```
src/main/java/com/example/PI/
├── controller/     # Rotas da API (Auth, Cidadao, Formulario, Novidade, Prefeitura)
├── service/        # Regras de negócio
├── repository/     # Acesso ao MongoDB (Spring Data)
├── model/          # Entidades e enums
├── dto/            # Login e StatusUpdate
└── PiApplication.java
```

## Segurança: limitações conhecidas

Este projeto é acadêmico e **não está pronto para uso em produção**. Antes de qualquer publicação real:

- As senhas dos cidadãos são armazenadas e comparadas em **texto puro** (o ideal é usar hash, como BCrypt).
- As credenciais da prefeitura estão **fixas no código** (`AuthController`).
- Não há autenticação por token (JWT ou sessão): as rotas marcadas como "uso da prefeitura" e a listagem de cidadãos podem ser acessadas por qualquer cliente.
- O CORS está liberado para qualquer origem (`@CrossOrigin("*")`).
- Não há validação de dados de entrada (CPF, e-mail, tamanho de senha).
- O campo `anexo` guarda apenas texto; o upload de arquivos ainda não foi implementado.

## Melhorias planejadas

- [ ] Hash de senha e autenticação com Spring Security e JWT
- [ ] Controle de acesso por perfil (cidadão e prefeitura)
- [ ] Validação de entrada com Bean Validation
- [ ] Upload de imagens das ocorrências
- [ ] Tratamento centralizado de erros (`@ControllerAdvice`)
- [ ] Testes automatizados dos serviços e controllers
- [ ] Configuração por variáveis de ambiente e deploy

## Equipe

- Felipe Tavares Braun
- Felipe Yanagui Geraldo
- Igor Alves Lemes
- Eduardo Yoshida Reis
- Maiara Macedo

Projeto integrador desenvolvido como trabalho acadêmico.
