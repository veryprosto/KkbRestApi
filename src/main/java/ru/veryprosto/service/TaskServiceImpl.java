package ru.veryprosto.service;

import org.springframework.stereotype.Service;
import ru.veryprosto.dao.TaskDao;
import ru.veryprosto.model.Task;

import java.sql.SQLException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao = new TaskDao(Init.getConnectionSource(), Task.class);

    public TaskServiceImpl() throws SQLException {
    }

    @Override
    public List<Task> readAll() {
        List<Task> tasks = null;
        try {
            tasks = taskDao.queryBuilder().query();
        } catch (SQLException e) {
            System.out.println("Ошибка при запросе в БД");
        }
        return tasks;
    }

    @Override
    public Task read(int id) {
        Task task = null;
        try {
            task = taskDao.queryBuilder().where().eq("id", id).queryForFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка при запросе в БД");
        }
        return task;
    }

    @Override
    public void create(Task task) {
        try {
            taskDao.create(task);
        } catch (SQLException e) {
            System.out.println("Ошибка при запросе в БД");
        }
    }

    @Override
    public boolean update(Task task, int id) {
        try {
            Task oldTask = taskDao.queryBuilder().where().eq("id", id).queryForFirst();
            if (oldTask == null) return false;
            taskDao.update(task);
        } catch (SQLException e) {
            System.out.println("Ошибка при запросе в БД");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Task oldTask = taskDao.queryBuilder().where().eq("id", id).queryForFirst();
            if (oldTask == null) return false;
            taskDao.delete(oldTask);
        } catch (SQLException e) {
            System.out.println("Ошибка при запросе в БД");
            return false;
        }
        return true;
    }
}
