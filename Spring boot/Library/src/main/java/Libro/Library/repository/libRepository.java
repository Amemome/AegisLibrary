package Libro.Library.repository;

import  Libro.Library.entity.book_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface libRepository extends JpaRepository<book_list, Integer>{
}
