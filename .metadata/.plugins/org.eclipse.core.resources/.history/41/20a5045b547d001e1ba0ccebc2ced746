package com.DMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
	
	private static Connection connection ;

    public CategoryManager(String url, String username, String password) throws ClassNotFoundException {
        try {
        	Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:7070/Aubaid", "postgres","aubaid");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void addCategories(Category category) {
        try {
            String sql = "INSERT INTO categories (id, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  

    public static List<Category> getAllCategory() {
        List<Category> category = new ArrayList<Category>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categories");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
