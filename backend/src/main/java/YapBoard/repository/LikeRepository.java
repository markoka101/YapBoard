package YapBoard.repository;

import YapBoard.entity.Like;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like,Long> {
    Page<Like> findAllByPost(Long postId, Pageable pageable);
    Page<Like> findAllByUser(Long userId, Pageable pageable);
    Optional<Like> findByUserAndPost(Long userId,Long postId);
}
