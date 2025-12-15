package br.com.biontech.jdbc;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/biontech_db?serverTimezone=UTC";
            String usuario = "root";
            String senha = "";

            return DriverManager.getConnection(url, usuario, senha);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão: " + erro);
            throw new RuntimeException(erro);
        }
    }

    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado ao Banco BIONTECH_PF com Sucesso! 🚀");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Falha: " + e);
        }
    }
}