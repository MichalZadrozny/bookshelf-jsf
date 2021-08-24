package pl.michalzadrozny.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.michalzadrozny.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

}
