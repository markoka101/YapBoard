package YapBoard.repository;

import YapBoard.entity.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostsRepository extends JpaRepository<Posts,Long> {
    Page<Posts> findByTitleLike(String title, Pageable pageable);
    Page<Posts> findByUser(Long user_id, Pageable pageable);

}
