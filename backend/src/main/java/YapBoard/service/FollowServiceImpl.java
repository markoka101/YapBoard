package YapBoard.service;

import YapBoard.entity.Follow;
import YapBoard.repository.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowServiceImpl implements FollowService {
    private FollowRepository followRepository;
    @Override
    public void followUser(Follow follow) {
        followRepository.save(follow);
    }

    @Override
    public void unfollow(Follow follow) {
        followRepository.delete(follow);
    }
}
