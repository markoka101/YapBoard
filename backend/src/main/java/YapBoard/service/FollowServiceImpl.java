package YapBoard.service;

import YapBoard.entity.Follow;
import YapBoard.repository.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean followExists(Long userId, Long id) {
        return followRepository.findByUserAndFollowing(userId,id).isPresent();
    }

    @Override
    public List<Follow> followers(Long userId, Pageable pageable) {
        Page<Follow> followPage = followRepository.findByUser(userId,pageable);
        if (followPage == null) {
            return null;
        }

        return followPage.getContent();
    }
}
