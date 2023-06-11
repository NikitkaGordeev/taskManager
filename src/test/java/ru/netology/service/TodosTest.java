package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.objects.*;


class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям, напомнить купить Хлеб");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() { // Находим все классы
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchInSimpleTasks() { // Находим в одном классе
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "родителям";
        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpicTasks() { // Находим в одном классе
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "Яйца";
        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingTasks() { // Находим в одном классе
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "НетоБанка";
        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldEmptyResultNonExistentRequest() { // Не находим не в одном классе
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "Привет";
        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMultipleTasks() { //Находим несколько задач
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        String query = "Хлеб";
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}