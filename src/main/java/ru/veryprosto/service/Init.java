package ru.veryprosto.service;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import ru.veryprosto.model.Task;

import java.sql.SQLException;

public class Init {
    private static ConnectionSource connectionSource;

    static {
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:kkbtesttask.db");
        } catch (SQLException throwables) {
            System.out.println("Ошибка при создании БД " + throwables.getMessage());
        }
    }

    public static void init() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Task.class);
        } catch (SQLException throwables) {
            System.out.println("Ошибка при создании таблицы " + throwables.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }
}
