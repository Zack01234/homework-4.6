package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entity.Faculty;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import java.util.Collection;
import java.util.stream.Stream;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty getFacultyById(Long id) {
        logger.info("Вызван метод getFacultyById");
        return facultyRepository.findById(id).get();
    }

    public Faculty addFaculty(Faculty faculty) {
        logger.info("Вызван метод addFaculty");
        faculty.setId(0L);
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Вызван метод editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        logger.info("Вызван метод deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFacultiesByNameOrColor(String nameOrColor) {
        logger.info("Вызван метод getAllFacultiesByNameOrColor");
        return facultyRepository.getFacultiesByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    public Collection<Faculty> findAllFaculties() {
        logger.info("Вызван метод findAllFaculties");
        return facultyRepository.findAll();
    }

    public Collection<Student> getAllStudentsOnFacultyById(Long id) {
        logger.info("Вызван метод getAllStudentsOnFacultyById");
        return facultyRepository.findById(id).get().getStudents();
    }

    public String getLongestFacultyName() {
        return facultyRepository.findAll().stream()
                .parallel()
                .map(Faculty::getName)
                .min((s1, s2) -> s2.length() - s1.length())
                .orElseThrow();
    }

    public Integer task4() {
        return Stream.iterate(1, a -> a + 1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, Integer::sum);
    }
}