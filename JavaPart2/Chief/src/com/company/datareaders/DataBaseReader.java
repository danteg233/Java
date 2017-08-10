package com.company.datareaders;


import com.company.model.Salad;
import com.company.model.Vegetable;

import java.lang.reflect.Constructor;
import java.sql.*;

public class DataBaseReader extends AbstractReader {

    private Connection connection;
    private String statement = "select  ingredients.name, ingredients.cal, comp.weight\n" +
            "from salad, comp, ingredients\n" +
            "where ingredients.id = comp.ingId and salad.id = comp.salId\n" +
            "and salad.name = ?";

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public DataBaseReader(Connection connection) {
        this.connection = connection;

    }

    @Override
    public Salad readInfo(String name) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Salad salad = new Salad(name);
        Vegetable vegetable;
        try {
            preparedStatement = getConnection().prepareStatement(statement);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                try {
                    String className = resultSet.getString(1);      //Get name from DB
                    double calories = (double) resultSet.getInt(2);
                    double weight = (double) resultSet.getInt(3);
                    className = "com.company.model." + className;
                    Class<?> ingredientClass = Class.forName(className);
                    Constructor<?> constructor = ingredientClass.getConstructor(new Class[]{double.class, double.class});
                    vegetable = (Vegetable) constructor.newInstance(calories, weight);
                    salad.addIngredient(vegetable);
                } catch (Exception e) {
                    System.out.println("Couldn't find a class with name  " + e.getMessage());
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        if (salad.isEmpty()){
            System.err.println("Couldn't find salad in DB with name " + name);
            return null;
        }
        return salad;
    }
}
