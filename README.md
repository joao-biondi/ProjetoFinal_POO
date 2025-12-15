🧬 BIONTECH - Sistema de Gestão Comercial e Estoque
Projeto Final - Programação Orientada a Objetos (POO) > Instituição: UTFPR - Campus Santa Helena

Ano: 2025

📋 Descrição do Projeto
Sistema completo de gerenciamento para varejo de pequeno e médio porte desenvolvido em linguagem Java. O sistema contempla todas as operações necessárias para a administração do negócio, focando na resolução do problema de descontrole de estoque e na agilidade do processo de vendas (PDV).

A solução garante a integridade dos dados através de um banco de dados relacional (MySQL) e uma interface gráfica robusta construída com Swing.

🚀 Funcionalidades Principais
📦 1. Gestão de Produtos
Cadastro completo (descrição, preço, estoque).

Vínculo automático com Fornecedores (Chave Estrangeira).

Listagem de inventário.

Edição de preços e visualização de códigos para venda rápida.

👥 2. Gestão de Clientes
Cadastro com dados completos (CPF, Telefone, Endereço).

Busca Inteligente: Localização automática por CPF na tela de vendas.

Operações de Edição e Remoção.

🚛 3. Gestão de Fornecedores
Cadastro de parceiros comerciais (Razão Social, CNPJ).

Vínculo direto com o cadastro de produtos.

🔐 4. Gestão de Acesso (Login)
Autenticação via banco de dados.

Máscara visual de senha (*****).

Controle de acesso restrito ao menu principal.

🛒 5. Gestão de Vendas (PDV)
Carrinho de compras com múltiplos itens.

Busca rápida de produtos por código (Tecla ENTER).

Busca de clientes por CPF com feedback visual.

Cálculo automático de subtotais e total geral.

Baixa Automática de Estoque: O sistema debita a quantidade vendida instantaneamente (Requisito RF007).

📄 6. Relatórios
Exportação PDF: Relatório de inventário utilizando biblioteca iText.

Formatação de data/hora no padrão brasileiro.

Layout tabular profissional.

🛠️ Conceitos Técnicos e Arquitetura
O projeto foi desenvolvido seguindo rigorosamente os pilares da Programação Orientada a Objetos e boas práticas de engenharia de software.

✅ Arquitetura MVC (Model-View-Controller)
Separação clara de responsabilidades:

Model: Regras de Negócio e Entidades (br.com.biontech.model).

View: Interface Gráfica Swing (br.com.biontech.view).

DAO: Camada de Persistência e SQL (br.com.biontech.dao).

✅ Persistência de Dados (JDBC)
Conexão robusta com MySQL 8.0.

Uso de PreparedStatement para prevenção contra SQL Injection.

CRUD completo (Create, Read, Update, Delete).

✅ Interface Gráfica (Swing)
Telas responsivas com JFrame e JPanel.

Tabelas dinâmicas (JTable) preenchidas via ArrayList.

Eventos de teclado (KeyListeners) para atalhos de PDV.

📂 Estrutura do Projeto
Plaintext

Biontech/
├── src/
│   └── br/com/biontech/
│       ├── dao/                # Data Access Objects (SQL)
│       │   ├── ClienteDAO.java
│       │   ├── ProdutoDAO.java
│       │   ├── VendaDAO.java
│       │   └── ...
│       ├── jdbc/               # Conexão com Banco
│       │   └── ConnectionFactory.java
│       ├── model/              # JavaBeans (Entidades)
│       │   ├── Cliente.java
│       │   ├── Produto.java
│       │   ├── Venda.java
│       │   └── ...
│       └── view/               # Telas (GUI)
│           ├── FrmLogin.java
│           ├── FrmMenu.java
│           ├── FrmVendas.java
│           └── ...
├── lib/                        # Dependências
│   ├── mysql-connector-j-8.3.0.jar
│   └── itextpdf-5.5.13.2.jar
└── README.md
💻 Exemplo de Modelagem de Dados
O sistema utiliza encapsulamento e composição de objetos.

Produto (Com Associação)
Java

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    
    // Associação: Produto "tem um" Fornecedor (Composição)
    private Fornecedor fornecedor;

    // Getters e Setters...
}
Venda (Relacionamento Complexo)
Java

public class Venda {
    private int id;
    private Cliente cliente; // Objeto Cliente associado
    private String data_venda;
    private double total_venda;
    
    // Métodos...
}
⚙️ Instalação e Execução
Pré-requisitos
Java JDK 8 ou superior.

NetBeans IDE (Recomendado) ou Eclipse/IntelliJ.

MySQL Server (via XAMPP, WAMP ou Workbench).

Passo a Passo
Configurar Banco de Dados: Execute o script SQL no seu gerenciador MySQL:

SQL

CREATE DATABASE biontech_db;
USE biontech_db;
-- (Importar o restante das tabelas do arquivo script.sql fornecido)
Importar o Projeto:

Faça o clone do repositório ou baixe o ZIP.

Abra no NetBeans: File > Open Project.

Configurar Bibliotecas:

Verifique se a pasta lib/ contém mysql-connector e itextpdf.

Adicione-os ao Classpath / Libraries do projeto na IDE.

Executar:

Rode o arquivo FrmLogin.java.

Login Padrão: admin

Senha Padrão: 123

👨‍💻 Autores
Desenvolvedor: João Vitor Antunes dos Santos

Orientador: Prof. Giuvane Conti

Projeto desenvolvido para fins acadêmicos - UTFPR 2025.
