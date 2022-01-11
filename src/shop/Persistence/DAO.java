
package shop.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAO {
    
     protected Connection connection = null;
    protected ResultSet result = null;
    protected Statement sentence = null;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "shop";
    private final String DRIVER = "com.mysql.jdbc.Driver";
        
    public void connect() throws SQLException, ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            String urlDataBase = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            connection = DriverManager.getConnection(urlDataBase, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
       
        
    }
    protected void disconnectBase() throws Exception {
       try {
            if (result != null) {
                result.close();
            }
            if (sentence != null) {
                sentence.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void insertEditDelete(String sql) throws Exception {
        try {
            connect();
            sentence = connection.createStatement();
            sentence.executeUpdate(sql);
        } catch (SQLException ex) {
            
            throw ex;
        } finally {
            disconnectBase();
        }
    }

    protected void consultBase(String sql) throws Exception {
        try {
            connect();
            sentence = connection.createStatement();
            result = sentence.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
