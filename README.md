BIONTECH - Sistema de Gestão Comercial e Estoque

Projeto Final - Programação Orientada a Objetos (POO)
UTFPR - Campus Santa Helena
Ano: 2025
Desenvolvedor: João Vitor Antunes dos Santos
Orientador: Prof. Giuvane Conti

Descrição do Projeto

Sistema completo de gerenciamento para varejo de pequeno e médio porte desenvolvido em linguagem Java. O sistema contempla todas as operações necessárias para a administração do negócio, focando na resolução do problema de descontrole de estoque e na agilidade do processo de vendas (PDV). A solução garante a integridade dos dados através de um banco de dados relacional (MySQL) e uma interface gráfica robusta construída com Swing.

Funcionalidades Principais

1. Gestão de Produtos

Cadastrar produtos (descrição, preço, estoque)

Vínculo automático com Fornecedores (Chave Estrangeira)

Listar inventário completo

Editar preços e quantidades

Visualizar códigos para venda rápida

2. Gestão de Clientes

Cadastrar clientes com dados completos (CPF, Telefone, Endereço)

Listar todos os clientes

Busca Inteligente: Localização automática por CPF na tela de vendas

Editar dados cadastrais

Remover clientes da base de dados

3. Gestão de Fornecedores

Cadastrar fornecedores (Razão Social, CNPJ, Contato)

Listar parceiros comerciais

Vínculo com o cadastro de produtos

Editar e remover fornecedores

4. Gestão de Acesso (Login)

Autenticação de funcionários via banco de dados

Proteção de senhas com máscara visual (*****)

Controle de acesso ao menu principal

5. Gestão de Vendas (PDV)

Realizar vendas com múltiplos itens (Carrinho de Compras)

Busca rápida de produtos por código (Tecla ENTER)

Busca de clientes por CPF com feedback visual imediato

Cálculo automático de subtotais e total geral

Baixa Automática de Estoque: O sistema debita a quantidade vendida instantaneamente (Requisito RF007)

Geração de número único de venda (ID)

6. Relatórios Gerenciais

Exportação PDF: Geração de relatório de inventário de produtos

Formatação de data e hora local (Padrão Brasileiro)

Layout tabular profissional utilizando biblioteca externa (iText)

Conceitos Técnicos Implementados

✅ Programação Orientada a Objetos (POO)

Abstração de entidades do mundo real em Classes (Cliente, Produto, Venda)

Encapsulamento (Atributos private e métodos Getters/Setters)

Instanciação de objetos e manipulação de estado

✅ Arquitetura MVC (Model-View-Controller)

Separação de responsabilidades em pacotes distintos:

Model: Representação dos dados (Regras de Negócio)

View: Interface Gráfica (Telas Swing)

DAO: Acesso a Dados (SQL e Persistência)

JDBC: Conexão com Banco

✅ Persistência de Dados (JDBC)

Conexão robusta com banco de dados MySQL 8.0

Uso de PreparedStatement para segurança contra SQL Injection

Operações CRUD completas (Create, Read, Update, Delete)

✅ Interface Gráfica (Java Swing)

Criação de telas responsivas (JFrame)

Uso de Painéis (JPanel) e Bordas (TitledBorder) para organização visual

Tabelas dinâmicas (JTable) e Menus (JMenuBar)

Eventos de teclado (KeyListeners) para atalhos e buscas rápidas

✅ Manipulação de Coleções

Uso de ArrayList e List para transporte de dados entre o Banco e a Tela

Iteração (for-each) sobre listas para preenchimento de tabelas e menus suspensos (ComboBox)

Estrutura do Projeto

Biontech/
├── src/
│   └── br/com/biontech/
│       ├── dao/                # Camada de Persistência (SQL)
│       │   ├── ClienteDAO.java
│       │   ├── ProdutoDAO.java
│       │   ├── VendaDAO.java
│       │   ├── ItemVendaDAO.java
│       │   └── FuncionarioDAO.java
│       ├── jdbc/               # Conexão
│       │   └── ConnectionFactory.java
│       ├── model/              # Classes (JavaBeans)
│       │   ├── Cliente.java
│       │   ├── Produto.java
│       │   ├── Venda.java
│       │   ├── ItemVenda.java
│       │   └── Fornecedor.java
│       └── view/               # Telas (GUI)
│           ├── FrmLogin.java
│           ├── FrmMenu.java
│           ├── FrmVendas.java
│           ├── FrmCliente.java
│           ├── FrmFornecedor.java
│           └── FrmProduto.java
├── lib/                        # Bibliotecas Externas
│   ├── mysql-connector-j-8.3.0.jar
│   └── itextpdf-5.5.13.2.jar
└── README.md


Estruturas de Dados Principais

Cliente (Classe Java)

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    
    // Construtores, Getters e Setters...
}


Produto (Com Associação)

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;
    
    // Associação: Produto "tem um" Fornecedor (Composição)
    private Fornecedor fornecedor;
}


Venda (Relacionamento Complexo)

public class Venda {
    private int id;
    private Cliente cliente; // Relacionamento com Cliente
    private String data_venda;
    private double total_venda;
}


Compilação e Execução

Requisitos do Sistema

Java JDK 8 ou superior

NetBeans IDE (Recomendado) ou qualquer IDE Java

MySQL Server (XAMPP, WAMP ou Workbench)

Passo a Passo

1. Configurar Banco de Dados:
Execute o script SQL no seu gerenciador MySQL para criar o banco e tabelas:

CREATE DATABASE biontech_db;
-- (Importar o restante do script SQL fornecido no projeto)
