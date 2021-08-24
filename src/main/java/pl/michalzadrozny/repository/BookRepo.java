package pl.michalzadrozny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.michalzadrozny.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
