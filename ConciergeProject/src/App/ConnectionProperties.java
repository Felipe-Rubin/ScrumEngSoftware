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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

public class ConnectionProperties {
    
    private String hostname, port, database, user, password;
    
    public ConnectionProperties(String hostname, String port, String database, String user, String password){
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        
    }
    
    public void setHost(String hostname){this.hostname = hostname;}
    public void setPort(String port){this.port = port;}
    public void setDB(String database){this.database = database;}
    public void setUser(String user){this.user = user;}
    public void setPass(String password){this.password = password;}
    
    public String getHost(){return hostname;}
    public String getPort(){return port;}
    public String getDB(){return database;}
    public String getUser(){return user;}
    public String getPass(){return password;}
    
    public String getUrl(){
        return "jdbc:mysql://"+hostname+":"+port+"/"+database;
    }
    
    public boolean isOK(){
    
        if(getHost() != null && getPort() != null && getDB()!= null && getUser()!= null && getPass() != null){
        
            return true;
        }
        return false;
    }
}
