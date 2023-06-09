package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.objects.Epic;
import ru.netology.objects.Meeting;
import ru.netology.objects.SimpleTask;

class TasksTest {
    //    @Test
//    public void shouldDisplayTitleSimpleTask(){
//        SimpleTask simpleTask = new SimpleTask(5, "Поиск дефектов");
//        String expected = "Поиск дефектов";
//        String actual = simpleTask.getTitle();
//        Assertions.assertEquals(expected,actual);
//    }
    @Test
    public void shouldNotFindInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Поиск дефектов");
        String query = "ошибка";
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Поиск дефектов");
        String query = "дефектов";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    //    @Test
//    public void shouldDisplayTitleEpic(){
//        Epic epic = new Epic(13, new String[]{"Task1", "Task2", "Task3"});
//        String[] expected = {"Task1", "Task2", "Task3"};
//        String[] actual = epic.getSubtasks();
//        Assertions.assertArrayEquals(expected,actual);
//    }
    @Test
    public void shouldNotFindInEpic() {
        Epic epic = new Epic(13, new String[]{"Task1", "Task2", "Task3"});
        String query = "Task4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindInEpic() {
        Epic epic = new Epic(13, new String[]{"Task1", "Task2", "Task3"});
        String query = "Task2";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    //    @Test
//    public void shouldDisplayTitleMeetingTopic(){
//        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
//        String expected = "Дефекты";
//        String actual = meeting.getTopic();
//        Assertions.assertEquals(expected,actual);
//    }
//    @Test
//    public void shouldDisplayTitleMeetingProject(){
//        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
//        String expected = "Тестирование продукта";
//        String actual = meeting.getProject();
//        Assertions.assertEquals(expected,actual);
//    }
//    @Test
//    public void shouldDisplayTitleMeetingStart(){
//        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
//        String expected = "Восемь часов вечера по МСК";
//        String actual = meeting.getStart();
//        Assertions.assertEquals(expected,actual);
//    }
    @Test
    public void shouldNotFindInMeeting() {
        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
        String query = "Время";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindInMeetingTopic() {
        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
        String query = "Дефекты";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindInMeetingProject() {
        Meeting meeting = new Meeting(22, "Дефекты", "Тестирование продукта", "Восемь часов вечера по МСК");
        String query = "Тестирование продукта";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);

    }
}