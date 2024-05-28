package Libro.Library.repository;
import Libro.Library.entity.siteuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<siteuser, Long> {
    boolean existsByStudentID(String studentID);
    boolean existsByUsname(String usname);

}
