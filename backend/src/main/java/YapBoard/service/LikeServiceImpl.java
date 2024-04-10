package YapBoard.service;

import YapBoard.entity.Like;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService{
    @Override
    public void likePost(Like like) {

    }

    @Override
    public void deleteLiked(Like like) {

    }

    @Override
    public boolean isLiked(Like like) {
        return false;
    }

    @Override
    public List<Like> getLikedPosts(Long userId, int page) {
        return null;
    }

    @Override
    public List<Like> getPostLikes(Long postId, int page) {
        return null;
    }
}
