package YapBoard.service;

import YapBoard.entity.Follow;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FollowService {
    //modify follow
    void followUser(Follow follow);
    void unfollow(Follow follow);
    //check if follow exists
    boolean followExists(Long userId, Long id);
    //get list of followers
    List<Follow> followers(Long userId, Pageable pageable);
    //get list of following
    List<Follow> following(Long userId, Pageable pageable);
}
