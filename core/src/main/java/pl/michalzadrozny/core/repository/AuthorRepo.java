package pl.michalzadrozny.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.michalzadrozny.core.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

	@Query(value = "SELECT a FROM Author a LEFT JOIN FETCH a.books b WHERE a.id = ?1")
	Optional<Author> findById(Long id);
}
