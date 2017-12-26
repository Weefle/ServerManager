package fr.weefle.servermanager;

import java.sql.*;

public class DataBaseConnection {

    private Connection connection;
    private String url;
    private String host;
    private String username;
    private String password;
    private String database;

    public DataBaseConnection(Connection connection, String url, String host, String username, String password, String database) {
        this.connection = connection;
        this.url = url;
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }

    public void connect(){
        try {
            if(isConnected()){
                return;
            }
            connection = DriverManager.getConnection(url + host + "/" + database, username, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isConnected(){
        try {
            return connection == null || !connection.isValid(5) || connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void disconnect(){
        if(!isConnected()){
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement prepare(String request){

        try {
            return connection.prepareStatement(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeUpdate(PreparedStatement statement){
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(PreparedStatement statement){
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
