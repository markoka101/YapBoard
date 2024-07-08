package YapBoard.repository;

import YapBoard.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    Page<Comments> findByUser(Long user_id, Pageable pageable);
    Page<Comments> findByPosts(Long id, Pageable pageable);
}
