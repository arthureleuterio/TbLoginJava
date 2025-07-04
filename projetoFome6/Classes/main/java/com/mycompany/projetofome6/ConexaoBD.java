package com.mycompany.projetofome6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "projeto_fome6";
    private static String usuario = "root";
    private static String senha = "mnam1000";

    public static Connection obtemConexao() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + porta + "/" + db + 
                "?useTimezone=true&serverTimezone=UTC", usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace(); // Mostra o erro no console
            return null;
        }
    }
}
