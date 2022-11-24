package com.example.homework4_2.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.entity.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void contextLoads() {
        Assertions.assertThat(studentController).isNotNull();
        Assertions.assertThat(this.restTemplate).isNotNull();
    }

    @Test
    public void addStudent() {
        final String name = "Lenin";
        Student student = new Student();
        student.setName(name);
        Assertions.assertThat(restTemplate.postForEntity("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }

    @Test
    public void getStudentById() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + 1, String.class))
                .isNotNull();
    }

    @Test
    public void getAllStudentsByAge() {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotNull();
    }

    @Test
    public void editStudent() {
        final long id = 1L;
        final String name = "Grib";
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        HttpEntity<Student> entity = new HttpEntity<>(student);

        Assertions.assertThat(this.restTemplate.exchange("http://localhost:" + port + "/student/", HttpMethod.PUT, entity, String.class)).isNotNull();
    }

    @Test
    public void getStudentsFacultyByStudentsId() {
        final long id = 1L;
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student/" + id + "/faculty", String.class))
                .isNotNull();
    }

    @Test
    public void deleteStudent() {
        final long id = 1L;
        HttpEntity<Student> entity = new HttpEntity<>(new Student());
        Assertions.assertThat(this.restTemplate.exchange("http://localhost:" + port + "/student/" + id, HttpMethod.DELETE, entity, String.class))
                .isNotNull();
    }
}
