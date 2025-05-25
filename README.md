<h1 align="center">🚀 Capital Quest</h1>

<p align="center">
  <img src="https://img.shields.io/github/license/ViniciusToledoBatista/CapitalQuest"/>
  <img src="https://img.shields.io/github/repo-size/ViniciusToledoBatista/CapitalQuest"/>
  <img src="https://img.shields.io/github/languages/count/ViniciusToledoBatista/CapitalQuest"/>
  <img src="https://img.shields.io/github/languages/top/ViniciusToledoBatista/CapitalQuest"/>
</p>

<p align="center">
  Sistema de gestão financeira e educacional pessoal.
</p>

---

## 💡 Sobre o Projeto

**Capital Quest** é um sistema de gestão financeira pessoal e educacional, desenvolvido em Java com banco de dados Oracle. Permite que usuários controlem suas finanças (entradas, saídas e investimentos) e acompanhem seu desenvolvimento educacional (cursos e formações), tudo em dashboards dinâmicos.

---

## 🔥 Funcionalidades

- ✅ Cadastro de usuário, telefone, DDI e DDD
- ✅ Controle de entradas financeiras e seus tipos
- ✅ Controle de saídas financeiras e seus tipos
- ✅ Gestão de investimentos e tipos de investimento
- ✅ Acompanhamento de cursos e formações
- ✅ Dashboards financeiros e educacionais
- ✅ Relatórios de progresso
- ✅ Banco Oracle com estrutura relacional normalizada

---

## 🏗️ Tecnologias e Ferramentas

- ☕ Java
- 🗄️ Oracle Database
- 🔗 JDBC (Java Database Connectivity)
- 🧠 SQL Developer
- 📄 SQL (DDL e DML)
- 📝 UML (Diagrama ER)
- 🖥️ IntelliJ IDEA
- 🗃️ Git & GitHub

---

## 🗂️ Estrutura do Projeto

📁 CapitalQuest/  
├── 📁 src/  
│   └── 📁 br/com/fiap/capitalquest/  
│       ├── 📁 model/  → Classes de modelo (entidades)  
│       ├── 📁 dao/    → Data Access Objects (DAO)  
│       └── 📁 factory/ → ConnectionFactory para banco de dados  
├── 📁 sql/ → Scripts SQL (DDL e DML)  
├── 📄 README.md  
├── 📜 LICENSE  
├── 📄 .gitignore  
└── 📄 pom.xml 

---

## 🗃️ Banco de Dados (Oracle)

### 🧍 Usuário
- T_CQ_USUARIO
- T_CQ_CADASTRO
- T_CQ_TELEFONE
- T_CQ_DDI
- T_CQ_DDD

### 💰 Finanças
- T_CQ_ENTRADA
- T_CQ_TIPO_ENTRADA
- T_CQ_SAIDA
- T_CQ_TIPO_SAIDA
- T_CQ_INVESTIMENTO
- T_CQ_TIPO_INVESTIMENTO

### 🎓 Educação
- T_CQ_CURSO
- T_CQ_FORMACAO
- T_CQ_CURSO_DASH

### 📊 Dashboards
- T_CQ_DASH_FINANCEIRO
- T_CQ_DASH_EDUCACIONAL


---

## 🧠 Modelo Entidade-Relacionamento (ER)

✔️ Projeto baseado em um modelo relacional normalizado.  
✔️ Todas as chaves primárias são geradas automaticamente.  
✔️ Relacionamentos estabelecidos com integridade referencial via foreign keys.

---

## 👨‍💻 Autor

- [Vinicius Toledo Batista](https://www.linkedin.com/in/vinicius-toledo-736442253/)

---

⭐ Se te ajudei ou você gostou do projeto, deixe uma estrela no repositório! ⭐
