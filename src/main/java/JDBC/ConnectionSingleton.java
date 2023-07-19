package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static ConnectionSingleton instance;
    private Connection connection;
    private String nomeUser = "postgres";
    private String senhaUser = "1234";
    private String enderecoServer = "localhost";
    private String nomeBancoDeDados = "CRUDDEFINITIVO";

    private ConnectionSingleton() {
    }

    public static synchronized ConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:postgresql://" + enderecoServer + "/" + nomeBancoDeDados, nomeUser, senhaUser);
                System.out.println("Conexão estabelecida com sucesso com banco de dados - PostgreSQL");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao tentar se conectar com Banco de Dados - PostgreSQL");
            throw new RuntimeException(e);
        }
    }
}
