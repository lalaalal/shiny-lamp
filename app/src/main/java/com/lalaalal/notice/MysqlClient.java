package com.lalaalal.notice;

import android.os.AsyncTask;

import com.lalaalal.notice.view.CardViewMaker;
import com.lalaalal.notice.view.CategoryCardViewMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MysqlClient extends AsyncTask<Integer, Integer, Integer> {
    private static final String DBName = "notice";
    private static final String TARGET_URL = "jdbc:mysql://mysql.isdj.ml/" + DBName;
    private static final String USER = "notice";
    private static final String PASSWORD = "isdj_107";

    private static final int CONNECT = 0x00;
    private static final int GET_CATEGORIES = 0x10;
    private static final int GET_SUBJECTS = 0x11;
    private static final int GET_POSTS = 0x12;

    private Statement statement;
    private ArrayList<CardViewMaker> cardViewMakers;

    public MysqlClient() {
        cardViewMakers = new ArrayList<>();
    }

    private void connect() throws ClassNotFoundException, SQLException{
        Connection connection;

        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(TARGET_URL, USER, PASSWORD);
        statement = connection.createStatement();
    }

    private void selectCategories() throws SQLException {
        final String categorySelectQuery = "SELECT * FROM category";
        ResultSet result = statement.executeQuery(categorySelectQuery);

        while (result.next()) {
            cardViewMakers.add(new CategoryCardViewMaker(result));
        }
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        try {
            connect();
            int cmd = integers[0];
            switch (cmd) {
                case GET_CATEGORIES:
                    selectCategories();
                    break;
                case GET_SUBJECTS:
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException e) {
            return -1;
        } catch (SQLException e) {
            return -2;
        }

        return 0;
    }

    public ArrayList<CardViewMaker> getCategories() {
        cardViewMakers.clear();
        execute(GET_CATEGORIES);

        return cardViewMakers;
    }
}