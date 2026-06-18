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
│   │   │   ├── adapter/
│   │   │   │   ├── controller/
│   │   │   │   │   └── UsuarioController.java       # Endpoints REST
│   │   │   │   ├── convertes/
│   │   │   │   │   └── UsuarioConverter.java        # Conversão entre Domain e DTO
│   │   │   │   ├── dtos/
│   │   │   │   │   └── UsuarioDto.java              # Data Transfer Object
│   │   │   │   ├── entities/
│   │   │   │   │   └── UsuarioEntity.java           # Mapeamento JPA
│   │   │   │   └── repositories/
│   │   │   │       ├── UsuarioRepository.java       # Interface Spring Data JPA
│   │   │   │       └── UsuarioRepositoryAdapter.java # Adaptador
│   │   │   ├── core/
│   │   │   │   ├── domain/
│   │   │   │   │   ├── Usuario.java                 # Entidade de domínio
│   │   │   │   │   ├── Pessoa.java                  # Base para usuários
│   │   │   │   │   ├── Morador.java                 # Morador do condomínio
│   │   │   │   │   ├── Visitante.java               # Visitante
│   │   │   │   │   └── Visita.java                  # Registro de visita
│   │   │   │   ├── ports/
│   │   │   │   │   ├── UsuarioServicePort.java      # Contrato do serviço
│   │   │   │   │   └── UsuarioRepositoryPort.java   # Contrato do repositório
│   │   │   │   └── services/
│   │   │   │       └── UsuarioService.java          # Lógica de negócio
│   │   │   └── infra/
│   │   │       └── BensConfig.java                  # Configurações gerais
│   │   └── resources/
│   │       ├── application.properties               # Configurações da aplicação
│   │       ├── static/                              # Arquivos estáticos
│   │       └── templates/                           # Templates (se necessário)
│   └── test/
│       └── java/io/dev/acesso_api/
│           └── AcessoApiApplicationTests.java       # Testes
├── pom.xml                                          # Configuração Maven
├── mvnw & mvnw.cmd                                  # Maven Wrapper
└── README.md                                        # Este arquivo

```

### Explicação da Arquitetura

#### **Arquitetura Hexagonal (Ports and Adapters)**

O projeto segue a arquitetura hexagonal para garantir independência de frameworks e facilitar testes:

- **Core (Domínio)**: Contém a lógica de negócio pura
  - `domain/`: Entidades de domínio
  - `ports/`: Contratos/interfaces
  - `services/`: Implementação de serviços

- **Adapter**: Conecta o domínio ao mundo externo
  - `controller/`: API REST
  - `dtos/`: Transferência de dados
  - `convertes/`: Mapeamento entre camadas
  - `entities/`: Mapeamento JPA
  - `repositories/`: Acesso a dados

- **Infra**: Configurações gerais da aplicação

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

### Usuários

#### Criar Usuário

```http
POST /api/usuarios
Content-Type: application/json

{
  "email": "usuario@example.com",
  "senha": "senha123",
  "administrador": false,
  "idPessoa": 1
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "email": "usuario@example.com",
  "senha": "senha123",
  "administrador": false,
  "idPessoa": 1
}
```

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
    "idPessoa": 1
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

### Usuario

Representa um usuário do sistema com acesso à plataforma.

```java
public class Usuario {
    private Long id;
    private String email;
    private String senha;
    private Boolean administrador;
    private Long idPessoa;
}
```

### Pessoa

Classe base para representar pessoas no sistema.

```java
public class Pessoa {
    private  Long id;
    private String nome;
    // ...
}
```

### Morador

Representa um morador do condomínio.

```java
public class Morador {
    private Long id;
    private String rg;
    private String endereco;
    private String celular;
    private Long idPessoa;
    // ...
}
```

### Visitante

Representa um visitante do condomínio.

```java
public class Visitante{
    private Long id;
    private String rg;
    private Long idPessoa;
    // ...
}
```

### Visita

Registro de visita ao condomínio.

```java
public class Visita {
    private Long id;
    private LocalDateTime dataHora;
    private Long idVisitante;
    private Long idMorador;    
    // ...
}
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
Projeto desenvolvido como parte de um curso de certificação em Spring Boot.

---

## 🎯 Próximos Passos Sugeridos

Após clonar e entender o projeto, considere:

- [x] Implementar endpoints GET, PUT e DELETE para Usuários
- [ ] Adicionar validações com Bean Validation
- [ ] Implementar Spring Security com JWT
- [ ] Criar repositórios para Morador, Visitante e Visita
- [ ] Adicionar logs com SLF4J
- [ ] Implementar tratamento de exceções global
- [ ] Adicionar testes unitários com JUnit e Mockito
- [ ] Documentar API com Swagger/OpenAPI
- [ ] Configurar CI/CD com GitHub Actions

---

**Última atualização**: Junho 2026

Happy Coding! 🚀
