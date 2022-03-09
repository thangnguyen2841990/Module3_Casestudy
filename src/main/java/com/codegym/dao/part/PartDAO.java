package com.codegym.dao.part;

import com.codegym.dao.part.IPartDAO;
import com.codegym.model.Part;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartDAO implements IPartDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/caseStudy?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "thuthuyda1";

    protected Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Part> seleceAllPartOfStory(int storyID) {
        String query = "{call SELECT_PART_BY_ID(?)}";
        List<Part> parts = new ArrayList<>();
        Connection connection = getConnection();
        try {
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt(1,storyID);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int episode = rs.getInt("episode");
                String name = rs.getString("name");

                parts.add(new Part(id,storyID,episode,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parts;
    }
    }

