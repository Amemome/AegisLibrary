package Libro.Library.repository;
import Libro.Library.entity.siteuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<siteuser, Long> {
    boolean existsByStudentID(String studentID);
    boolean existsByUsname(String name);
    Optional<siteuser> findByStudentID(String studentID);

}