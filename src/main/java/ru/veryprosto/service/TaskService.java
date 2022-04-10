package ru.veryprosto.service;

import ru.veryprosto.model.Task;

import java.util.List;

public interface TaskService {
    /**
     * Возвращает список всех имеющихся задач
     *
     * @return список задач
     */
    List<Task> readAll();

    /**
     * Возвращает зачачу по его ID
     *
     * @param id - ID задачи
     * @return - объект зачачи с заданным ID
     */
    Task read(int id);

    /**
     * Создает новую задачу
     *
     * @param task - задача для создания
     */
    void create(Task task);

    /**
     * Редактирует задачу с заданным ID,
     * в соответствии с переданной задачей
     *
     * @param task - задача в соответствии с которой нужно обновить данные
     * @param id   - id задачи которую нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Task task, int id);

    /**
     * Удаляет задачу с заданным ID
     *
     * @param id - id задачи, которую нужно удалить
     * @return - true если задача была удалена, иначе false
     */
    boolean delete(int id);
}
