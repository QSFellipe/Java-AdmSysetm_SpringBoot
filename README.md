# 💰 Financial Control System

Sistema web completo para gerenciamento financeiro pessoal, permitindo controle de gastos, visualização de dados e tomada de decisões baseada em dados.

---

## 📌 Sobre o Projeto

O **Financial Control System** foi desenvolvido com o objetivo de fornecer autonomia ao usuário na gestão de suas finanças, oferecendo:

* Controle de receitas e despesas
* Visualização gráfica de dados financeiros
* Integração com APIs externas
* Autenticação segura de usuários

Este projeto segue uma arquitetura baseada em **API REST com padrão MVC**, garantindo escalabilidade e organização do código.

---

## 🚀 Funcionalidades

* 🔐 Login de usuário
* 💵 Cadastro e gerenciamento de receitas e despesas
* 📊 Dashboard com gráficos interativos
* 📈 Acompanhamento de saldo em tempo real
* 🌐 Integração com API de mercado financeiro (Finnhub)
* 🤖 ChatBot com sugestões financeiras

---

## 🛠️ Tecnologias Utilizadas

### 🔙 Back-end

* Java 17
* Spring Boot
* Spring MVC
* Spring Security
* Hibernate (JPA)

### 🗄️ Banco de Dados

* MySQL

### 🎨 Front-end

* HTML5
* CSS3
* JavaScript
* Bootstrap
* FontAwesome

### 🔌 Integrações

* Finnhub API
* Chart.js

---

## ⚙️ Arquitetura do Sistema

O projeto segue o padrão **MVC (Model-View-Controller)**:

```text
src/
 ├── controller/   → Camada de entrada (requisições HTTP)
 ├── service/      → Regras de negócio
 ├── repository/   → Acesso ao banco de dados
 ├── model/        → Entidades do sistema
```

---

## ⚙️ Como Rodar o Projeto

### 🔧 Pré-requisitos

* Java 17+
* Maven
* MySQL

---

### ▶️ Passo a passo

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/financial-control-system.git

# Acessar a pasta
cd financial-control-system

# Rodar o projeto
mvn spring-boot:run
```

---

## 🔐 Configuração do Banco de Dados

No arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/financial_db
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🔑 Integração com APIs

### Finnhub API

Utilizada para dados de mercado financeiro:

```properties
finnhub.api.key=SUA_API_KEY
```

---

## 📊 Dashboard

O sistema apresenta gráficos dinâmicos utilizando **Chart.js**, permitindo:

* Visualizar gastos por categoria
* Acompanhar evolução financeira
* Identificar padrões de consumo

---

## 🔒 Segurança

* Autenticação com Spring Security
* Proteção de rotas
* Criptografia de senha

---

## 👨‍💻 Autor

Desenvolvido por **Fellipe Queiroz Silva**

---

## 💡 Diferenciais do Projeto

* Arquitetura limpa e escalável
* Integração com APIs reais
* Foco em experiência do usuário
* Aplicação real para portfólio profissional
