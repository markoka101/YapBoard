package YapBoard.repository;

import YapBoard.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagsRepository extends JpaRepository<Tags,Long> {
    Optional<Tags> findByTag(String tag);
}
