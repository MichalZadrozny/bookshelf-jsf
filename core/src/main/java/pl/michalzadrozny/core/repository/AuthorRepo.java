package pl.michalzadrozny.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.michalzadrozny.core.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

}
