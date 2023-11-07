package com.DMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
	
		
		private static Connection connection ;

	    public ItemManager(String url, String username, String password) throws ClassNotFoundException {
	        try {
	        	Class.forName("org.postgresql.Driver");
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:7070/Aubaid", "postgres","aubaid");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void addItems(Item item) {
	        try {
	            String sql = "INSERT INTO items (id, name, description, categoryId) VALUES (?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, item.getId());
	            preparedStatement.setString(2, item.getName());
	            preparedStatement.setString(3, item.getDescription());
	            preparedStatement.setInt(4, item.getCategoryId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }  

	    public static List<Item> getAllItems() {
	        List<Item> item = new ArrayList<Item>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM items,categories where item.id = categories.id");
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String description = resultSet.getString("description");
	                int categoryId = resultSet.getInt("categoryId");
	                item.add(new Item(id, name, description, categoryId));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return item;
	    }

	    public void updateItems(Item item) {
	        try {
	            String sql = "UPDATE items SET name = ?, description = ?, categoryId = ? WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, item.getId());
	            preparedStatement.setString(2, item.getName());
	            preparedStatement.setString(3, item.getDescription());
	            preparedStatement.setInt(4, item.getCategoryId());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteItems(int id) {
	        try {
	            String sql = "DELETE FROM items WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void close() {
	        try {
	            if (connection != null) {
	            	System.out.println("Connection Closed");
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
