package Test;

import br.com.feRufato.dao.generic.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionFactory {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionFactory.getConnection();
            System.out.println("Conexão bem-sucedida: " + (connection != null));
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }
}
