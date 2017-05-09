/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

/**
 *
 * @author Felipe Rubin
 */


//import ConnectionProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerConnect {
    private Connection connection = null;
    private ConnectionProperties cprop;
    
    public ServerConnect(){
        
    }
    
    public ConnectionProperties getConnectionProp() {
        return cprop;
    }
    
    public void setConnectionProp(ConnectionProperties cprop){
        this.cprop = cprop;
    }
    
    public void setConnection(Connection connection){
    
        this.connection = connection;
    }
    
    public void initConnection(){
        getConnection();
    }
    
    public Connection getConnection() {
        connection = getConnectionMySQL(cprop);
        return connection;
    }
    
    public ServerConnect(ConnectionProperties cprop) {
        this.cprop = cprop;

    }
    
    public static Connection getConnectionMySQL(ConnectionProperties cprop) {

        Connection connection = null;
        
        try{
        
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(cprop.getUrl(), cprop.getUser(), cprop.getPass());
            
            if(connection != null){          
              return connection;              
            }else{return null;}
        }catch (ClassNotFoundException | SQLException e) {//Driver nao encontrado
            System.out.println("WTF\n"+e.getMessage() + "\nWTF");
            return null;
        }
    }
    
    public static boolean CloseConnection(Connection c) {

        try {
            c.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    
    public ResultSet QueryEndereco(){
        Statement st = null;
        String sql;
        
        try{
            st = connection.createStatement();
            sql = "SELECT * FROM Endereco";
            ResultSet rs = st.executeQuery(sql);
            return rs;            
        }catch (SQLException ex){
            Logger.getLogger(ServerConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;         
        }        
    }
    
    
    public ResultSet QueryPedido(){
        Statement st = null;
        String sql;
        
        try{
            st = connection.createStatement();
            sql = "SELECT * FROM Pedido";
            ResultSet rs = st.executeQuery(sql);
            return rs;            
        }catch (SQLException ex){
            Logger.getLogger(ServerConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;         
        }        
    }
        public ResultSet QueryProfile(){
        Statement st = null;
        String sql;
        
        try{
            st = connection.createStatement();
            sql = "SELECT * FROM Profile";
            ResultSet rs = st.executeQuery(sql);
            return rs;            
        }catch (SQLException ex){
            Logger.getLogger(ServerConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;         
        }        
    }
    

    
    public ResultSet QueryGeneric(String sql){ //Generica requer input da Sql
    
        Statement st = null;
        if(connection == null) System.out.println("ta null");
        try{
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs;           
        }catch (SQLException ex){
            Logger.getLogger(ServerConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;          
        }
    }
}
