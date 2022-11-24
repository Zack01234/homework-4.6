package ru.hogwarts.school.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.hogwarts.school.entity.Avatar;

import java.util.Optional;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);

    void deleteByStudentId(Long studentId);
}
