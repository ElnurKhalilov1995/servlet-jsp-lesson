package dao;

import com.mycompany.servlet.ptoject.entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    
    private Connection con;
    
    public DbConnection (String url, String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url , user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Client> findAllClient() throws SQLException {        
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from client");
            
            List<Client> clients = new ArrayList();
            
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString(2), rs.getString(3), rs.getInt("age")));
            }     
            
            return clients;
    }
    
    public Client findByIdClient(int id) {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from client where id =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            System.out.println("test");
            
            while (rs.next()) {
                return new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt("age"));
            }     
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Client();
    }
    
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
