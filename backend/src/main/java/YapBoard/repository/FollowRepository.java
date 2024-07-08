package YapBoard.repository;

import YapBoard.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow,Long> {
    Page<Follow> findByUser(Long user_id);
    Optional<Follow> findByUserAndFollowing(Long user_id,Long id);
}
