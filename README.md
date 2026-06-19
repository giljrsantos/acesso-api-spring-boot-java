# Acesso-API 🔐

Uma API REST construída com Spring Boot para gerenciar controle de acesso em condomínios, implementando conceitos modernos de arquitetura de software.

---

## 📋 Visão Geral

A **Acesso-API** é uma aplicação backend robusta desenvolvida em **Java 17** com **Spring Boot 3.5.15**, projetada para gerenciar usuários, moradores, visitantes e registros de acesso em ambientes residenciais. O projeto implementa a arquitetura **Hexagonal (Ports and Adapters)**, garantindo uma separação clara de responsabilidades e facilidade na manutenção e teste do código.

### Características Principais

- ✅ Arquitetura Hexagonal (Clean Architecture)
- ✅ API RESTful
- ✅ Banco de dados em memória (H2)
- ✅ Gestão de Usuários com controle de administradores
- ✅ Suporte a Moradores e Visitantes
- ✅ Registro de Visitas
- ✅ Utilização de DTOs para transferência de dados
- ✅ Mapeamento de entidades com ModelMapper
- ✅ Injeção de dependências com Spring
- ✅ Testes unitários integrados

---

## 🚀 Tecnologias Utilizadas

### Backend

| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Java** | 17 | Linguagem de programação principal |
| **Spring Boot** | 3.5.15 | Framework para aplicações Java |
| **Spring Data JPA** | - | Persistência de dados com ORM |
| **H2 Database** | - | Banco de dados em memória |
| **Lombok** | - | Redução de código boilerplate |
| **ModelMapper** | 3.1.1 | Mapeamento de objetos |
| **Maven** | - | Gerenciador de dependências e build |

### Dependências Principais

```xml
<!-- Spring Boot Starters -->
spring-boot-starter-data-jpa
spring-boot-starter-web
spring-boot-starter-test

<!-- Banco de Dados -->
h2

<!-- Ferramentas -->
lombok
modelmapper
```

---

## 📁 Estrutura do Projeto

```
acesso-api/
├── src/
│   ├── main/
│   │   ├── java/io/dev/acesso_api/
│   │   │   ├── Setup.java                           # Classe principal (entry point)
│   │   │   │
│   │   │   ├── adapter/                             # Camada de Adaptadores
│   │   │   │   ├── controller/
│   │   │   │   │   ├── MoradorController.java       # Endpoints REST para Morador
│   │   │   │   │   └── UsuarioController.java       # Endpoints REST para Usuario
│   │   │   │   │
│   │   │   │   ├── convertes/
│   │   │   │   │   ├── MoradorConverter.java        # Conversão Morador DTO ↔ Domain
│   │   │   │   │   └── UsuarioConverter.java        # Conversão Usuario DTO ↔ Domain
│   │   │   │   │
│   │   │   │   ├── dtos/
│   │   │   │   │   ├── MoradorDto.java              # Data Transfer Object para Morador
│   │   │   │   │   └── UsuarioDto.java              # Data Transfer Object para Usuario
│   │   │   │   │
│   │   │   │   ├── entities/
│   │   │   │   │   ├── MoradorEntity.java           # Mapeamento JPA para Morador
│   │   │   │   │   ├── PessoaEntity.java            # Mapeamento JPA para Pessoa
│   │   │   │   │   └── UsuarioEntity.java           # Mapeamento JPA para Usuario
│   │   │   │   │
│   │   │   │   └── repositories/
│   │   │   │       ├── MoradorRepository.java       # Interface Spring Data JPA para Morador
│   │   │   │       ├── MoradorRepositoryAdapter.java # Implementação do adaptador Morador
│   │   │   │       ├── PessoaRepository.java        # Interface Spring Data JPA para Pessoa
│   │   │   │       ├── PessoaRepositoryAdapter.java # Implementação do adaptador Pessoa
│   │   │   │       ├── UsuarioRepository.java       # Interface Spring Data JPA para Usuario
│   │   │   │       └── UsuarioRepositoryAdapter.java # Implementação do adaptador Usuario
│   │   │   │
│   │   │   ├── core/                                # Camada de Domínio (Lógica de Negócio)
│   │   │   │   ├── domain/
│   │   │   │   │   ├── Morador.java                 # Entidade de domínio - Morador
│   │   │   │   │   ├── Pessoa.java                  # Entidade de domínio - Base para usuários
│   │   │   │   │   ├── Usuario.java                 # Entidade de domínio - Usuario
│   │   │   │   │   ├── Visitante.java               # Entidade de domínio - Visitante
│   │   │   │   │   └── Visita.java                  # Entidade de domínio - Registro de visita
│   │   │   │   │
│   │   │   │   ├── ports/
│   │   │   │   │   ├── MoradorRepositoryPort.java   # Interface - Contrato do repositório Morador
│   │   │   │   │   ├── MoradorServicePort.java      # Interface - Contrato do serviço Morador
│   │   │   │   │   ├── UsuarioRepositoryPort.java   # Interface - Contrato do repositório Usuario
│   │   │   │   │   └── UsuarioServicePort.java      # Interface - Contrato do serviço Usuario
│   │   │   │   │
│   │   │   │   └── services/
│   │   │   │       ├── MoradorService.java          # Implementação da lógica de negócio - Morador
│   │   │   │       └── UsuarioService.java          # Implementação da lógica de negócio - Usuario
│   │   │   │
│   │   │   └── infra/
│   │   │       └── BensConfig.java                  # Configurações gerais e Beans do projeto
│   │   │
│   │   └── resources/
│   │       ├── application.properties               # Configurações da aplicação
│   │       ├── static/                              # Arquivos estáticos (CSS, JS, etc.)
│   │       └── templates/                           # Templates HTML (se necessário)
│   │
│   └── test/
│       └── java/io/dev/acesso_api/
│           └── AcessoApiApplicationTests.java       # Testes unitários da aplicação
│
├── pom.xml                                          # Configuração Maven com dependências
├── mvnw & mvnw.cmd                                  # Maven Wrapper (Linux/Mac & Windows)
├── target/                                          # Diretório de build (gerado automaticamente)
└── README.md                                        # Este arquivo

```

### Explicação da Arquitetura

#### **Arquitetura Hexagonal (Ports and Adapters)**

O projeto segue rigorosamente a arquitetura hexagonal para garantir independência de frameworks e facilitar testes. A separação clara entre camadas permite manter a lógica de negócio totalmente desacoplada de tecnologias externas:

**1. Core (Núcleo de Domínio)**
- **`domain/`**: Contém as entidades de domínio puras (Pessoa, Usuario, Morador, Visitante, Visita)
  - Lógica de negócio independente de qualquer framework
  - Sem dependências de Spring, JPA ou banco de dados
  
- **`ports/`**: Define contratos (interfaces) para comunicação com o mundo externo
  - `*RepositoryPort`: Contratos para acesso a dados
  - `*ServicePort`: Contratos para serviços de domínio
  - Abstração que permite trocar implementações sem afetar o domínio

- **`services/`**: Implementação da lógica de negócio
  - Implementam as interfaces de `ports/`
  - Orquestram operações do domínio
  - Validam regras de negócio (ex: verificar duplicatas por CPF)

**2. Adapter (Camada de Adaptadores)**
- **`controller/`**: Adaptadores de entrada (API REST)
  - Controllers Spring que expõem endpoints HTTP
  - Recebem requisições e as convertem para domínio
  - Retornam respostas para o cliente

- **`dtos/`**: Data Transfer Objects
  - Estruturas de transferência de dados entre cliente e servidor
  - Apenas para Usuario e Morador (outras entidades sem exposição por API)
  - Desacoplam a estrutura interna do domínio da API pública

- **`convertes/`**: Conversores de dados
  - Convertem entre DTOs ↔ Domínio
  - Mapeiam dados entre camadas
  - Lógica de transformação de dados

- **`entities/`**: Adaptadores de persistência (ORM)
  - Mapeamento JPA das entidades
  - Anotações do Hibernate/JPA
  - Refletem a estrutura do banco de dados

- **`repositories/`**: Adaptadores de acesso a dados
  - `*Repository`: Interfaces Spring Data JPA
  - `*RepositoryAdapter`: Implementações dos Ports
  - Conectam domínio ao banco de dados

**3. Infra (Camada de Infraestrutura)**
- **`BensConfig.java`**: Configurações e Beans
  - Injeção de dependências do Spring
  - Configurações da aplicação
  - Instanciação dos serviços e adaptadores

#### **Fluxo de uma Requisição**

```
Cliente HTTP
    ↓
Controller (adapter/controller/)
    ↓
Converter (adapter/convertes/) - DTO → Domain
    ↓
ServicePort (core/ports/) - Interface
    ↓
Service (core/services/) - Lógica de negócio
    ↓
RepositoryPort (core/ports/) - Interface
    ↓
RepositoryAdapter (adapter/repositories/)
    ↓
RepositoryJPA (adapter/repositories/)
    ↓
Entity (adapter/entities/) - JPA
    ↓
Banco de Dados (H2)
```

---

## 🔧 Instalação e Configuração

### Pré-requisitos

- **Java 17** ou superior instalado
- **Maven 3.6+** ou usar o Maven Wrapper incluído no projeto
- **Git** para clonar o repositório

### Passos para Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/acesso-api.git
   cd acesso-api
   ```

2. **Compile o projeto:**
   ```bash
   ./mvnw clean compile
   ```
   Ou no Windows:
   ```bash
   mvnw.cmd clean compile
   ```

3. **Execute os testes:**
   ```bash
   ./mvnw test
   ```

4. **Inicie a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

A aplicação estará disponível em: **http://localhost:8080**

---

## 📊 Banco de Dados

### H2 Database

O projeto utiliza **H2** como banco de dados em memória, ideal para desenvolvimento e testes.

### Acessar o Console H2

Quando a aplicação estiver rodando, acesse:

```
http://localhost:8080/h2-console
```

**Credenciais:**
- **Driver Class**: `org.h2.Driver`
- **JDBC URL**: `jdbc:h2:mem:acesso_db`
- **User Name**: `sa`
- **Password**: `sa`

### Configurações

```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:acesso_db
spring.datasource.username=sa
spring.datasource.password=sa
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🔌 Endpoints da API

### Base URL
```
http://localhost:8080/api
```

### Usuários

#### Criar Usuário (POST)

```http
POST /api/usuarios
Content-Type: application/json

{
  "email": "usuario@example.com",
  "senha": "senha123",
  "administrador": false,
  "pessoa": {
    "nome": "João Silva"
  }
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "email": "usuario@example.com",
  "senha": "senha123",
  "administrador": false,
  "pessoa": {
    "id": 1,
    "nome": "João Silva"
  }
}
```

**Validações**:
- ✅ Email único (não permite duplicatas)
- ✅ Referência a Pessoa obrigatória
- ⏳ Bean Validation (em desenvolvimento)

---

### Moradores

#### Criar Morador (POST)

```http
POST /api/moradores
Content-Type: application/json

{
  "cpf": "12345678901",
  "endereco": "Apto 101 - Bloco A",
  "celular": "(11) 98765-4321",
  "nome": "Maria Santos"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "nome": "Maria Santos",
  "cpf": "12345678901",
  "endereco": "Apto 101 - Bloco A",
  "celular": "(11) 98765-4321"
}
```

**Validações**:
- ✅ CPF único (não permite duplicatas)
- ✅ Criação automática de Pessoa associada
- ⏳ Validação de CPF (em desenvolvimento)
- ⏳ Endpoints GET, PUT, DELETE (em desenvolvimento)

---

### Visitantes

#### Criar Visitante (em desenvolvimento)
- ⏳ Endpoint não implementado ainda
- ⏳ DTO e Converter aguardando implementação

---

### Visitas

#### Registrar Visita (em desenvolvimento)
- ⏳ Endpoint não implementado ainda
- ⏳ Repositório e Serviço aguardando implementação

---

## 🗄️ Estrutura de Dados (Banco de Dados)

### Tabelas Principais

#### tb_pessoa
```sql
CREATE TABLE tb_pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);
```

#### tb_usuario
```sql
CREATE TABLE tb_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    administrador BOOLEAN DEFAULT FALSE,
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa(id)
);
```

#### tb_morador
```sql
CREATE TABLE tb_morador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    endereco VARCHAR(255),
    celular VARCHAR(20),
    pessoa_id BIGINT NOT NULL,
    FOREIGN KEY (pessoa_id) REFERENCES tb_pessoa(id)
);
```

**Status**: Visitante e Visita ainda não possuem tabelas criadas.

---

## 💻 Exemplos de Uso

### Exemplo 1: Criar um novo usuário

```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "email": "joao@example.com",
    "senha": "senha456",
    "administrador": false,
    "pessoa": {
      "nome": "João Santos"
    }
  }'
```

### Exemplo 2: Criar um novo morador

```bash
curl -X POST http://localhost:8080/api/moradores \
  -H "Content-Type: application/json" \
  -d '{
    "cpf": "98765432101",
    "endereco": "Apto 205 - Bloco B",
    "celular": "(11) 99999-8888",
    "nome": "Pedro Oliveira"
  }'
```

---

## 🧪 Testes

Os testes estão localizados em `src/test/java/`:

```bash
# Executar todos os testes
./mvnw test

# Executar um teste específico
./mvnw test -Dtest=AcessoApiApplicationTests

# Executar com relatório de cobertura
./mvnw test jacoco:report
```

---

## 📚 Modelos de Domínio

### Pessoa
Classe base que representa uma pessoa no sistema. Outras entidades (Usuario, Morador, Visitante) herdam ou referenciam dados de Pessoa.

```java
public class Pessoa {
    private Long id;
    private String nome;
    // Getters e Setters
}
```

**Uso**: Base de dados de pessoas do condomínio (proprietários, administradores, visitantes, etc.)

---

### Usuario
Representa um usuário do sistema com acesso à plataforma e controle de permissões.

```java
public class Usuario {
    private Long id;
    private String email;
    private String senha;
    private Boolean administrador;
    private Pessoa pessoa;  // Referência à Pessoa
    // Getters e Setters
}
```

**Campos**:
- `email`: Email único para autenticação
- `senha`: Senha para login (recomendado usar BCrypt em produção)
- `administrador`: Flag indicando se é admin do sistema
- `pessoa`: Referência à entidade Pessoa

**Endpoints Implementados**:
- `POST /api/usuarios` - Criar novo usuário

---

### Morador
Representa um morador do condomínio com informações específicas.

```java
public class Morador {
    private Long id;
    private String cpf;
    private String endereco;
    private String celular;
    private Pessoa pessoa;  // Referência à Pessoa
    // Getters e Setters
}
```

**Campos**:
- `cpf`: CPF único (validação: não permite duplicatas)
- `endereco`: Endereço do imóvel no condomínio
- `celular`: Telefone de contato
- `pessoa`: Referência à entidade Pessoa

**Endpoints Implementados**:
- `POST /api/moradores` - Criar novo morador

---

### Visitante
Representa um visitante do condomínio. Não possui acesso direto ao sistema, apenas é registrado nas visitas.

```java
public class Visitante {
    private Long id;
    private String rg;
    private Pessoa pessoa;  // Referência à Pessoa
    // Getters e Setters
}
```

**Status**: Entidade de domínio criada, aguardando implementação de DTOs, Controllers e API.

---

### Visita
Registro de cada visita realizada ao condomínio. Estabelece a relação entre Visitante e Morador.

```java
public class Visita {
    private Long id;
    private LocalDateTime dataHora;
    private Long idVisitante;
    private Long idMorador;
    // Getters e Setters
}
```

**Campos**:
- `dataHora`: Timestamp da visita
- `idVisitante`: Referência ao visitante
- `idMorador`: Referência ao morador sendo visitado

**Status**: Entidade de domínio criada, aguardando implementação de repositórios, serviços e API.

---

### Relacionamentos

```
Pessoa (1) ←→ (1) Usuario
Pessoa (1) ←→ (1) Morador
Pessoa (1) ←→ (1) Visitante
Morador (1) ←→ (N) Visita (N) ←→ (1) Visitante
```

---

## 🔐 Segurança

A aplicação inclui campos para autenticação básica com email e senha. Para produção, recomenda-se implementar:

- ✅ Spring Security com JWT
- ✅ Criptografia de senhas (BCrypt)
- ✅ HTTPS
- ✅ Validação de entrada (Bean Validation)
- ✅ Controle de acesso (RBAC)

---

## 🛠️ Desenvolvimento

### IDE Recomendada

- **IntelliJ IDEA** (Community ou Ultimate)
- **Eclipse IDE**
- **Visual Studio Code** com extensões Java

### Build

```bash
# Build completo
./mvnw clean package

# Gerar JAR executável
./mvnw clean package -DskipTests
```

### Variáveis de Ambiente

Configure conforme necessário em `application.properties`:

```properties
spring.application.name=acesso-api
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📖 Referências e Recursos

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [ModelMapper Documentation](http://modelmapper.org/)
- [Lombok Features](https://projectlombok.org/features/)
- [H2 Database](https://www.h2database.com/)
- [Maven Documentation](https://maven.apache.org/)

---

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

---

## 📝 Licença

Este projeto é fornecido como exemplo educacional. Para informações de licença, verifique o arquivo `LICENSE` no repositório.

---

## 👨‍💻 Autor
### GILBRTO JUNIOR DOS SANTOS
Projeto desenvolvido como parte de estudos em arquitetura de software e desenvolvimento backend com Java e Spring Boot.

---

## 🎯 Próximos Passos

### ✅ Concluído
- [x] Estrutura base com arquitetura hexagonal
- [x] Implementar endpoints POST para Pessoa
- [x] Implementar endpoints POST para Usuários com verificação de Email duplicatas e referência a Pessoa
- [x] Implementar endpoints POST para Morador com verificação de CPF duplicado e referência a Pessoa
- [x] Criar repositórios para Pessoa, Usuario e Morador
- [x] Implementar converters para transformação de dados (DTO ↔ Domain)
- [x] Configurar injeção de dependências com Spring

### 📋 Em Desenvolvimento / Planejado
- [ ] Implementar endpoints GET, PUT e DELETE para Usuários
- [ ] Implementar endpoints GET, PUT e DELETE para Moradores
- [ ] Criar DTOs, Controllers e Converters para Visitante
- [ ] Criar DTOs, Controllers e Converters para Visita
- [ ] Criar repositórios completos para Visitante e Visita
- [ ] Adicionar validações com Bean Validation (@NotNull, @Email, @Size, etc.)
- [ ] Implementar Spring Security com JWT
- [ ] Adicionar criptografia de senhas (BCrypt)
- [ ] Criar tratamento de exceções global (@ControllerAdvice)
- [ ] Adicionar logs com SLF4J e Logback
- [ ] Implementar testes unitários com JUnit 5 e Mockito
- [ ] Implementar testes de integração
- [ ] Documentar API com Swagger/OpenAPI
- [ ] Configurar CI/CD com GitHub Actions
- [ ] Adicionar paginação nos endpoints GET
- [ ] Implementar cache de consultas frequentes

---

## 📝 Notas de Desenvolvimento

### Convenções Utilizadas

- **Nomenclatura**: CamelCase para classes, snake_case para tabelas e atributos de banco de dados
- **Arquitetura**: Ports and Adapters (Hexagonal Architecture)
- **DTOs**: Apenas para entidades expostas via API (Usuario, Morador)
- **Converters**: Utilizados para transformação entre DTOs e Domain Objects
- **Services**: Implementam lógica de negócio e validações
- **Repositories**: Apenas um meio de persistência, implementam os Ports

### Padrões de Projeto Utilizados

- **Dependency Injection**: Utilizado com Spring Framework
- **Repository Pattern**: Abstração de acesso a dados
- **DTO Pattern**: Transferência segura de dados entre camadas
- **Converter/Mapper Pattern**: Transformação entre objetos

---

**Última atualização**: 19 de junho de 2026

Happy Coding! 🚀
