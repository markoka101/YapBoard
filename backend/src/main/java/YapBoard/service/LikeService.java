package YapBoard.service;

import YapBoard.entity.Like;

import java.util.List;

public interface LikeService {
    //modifying like
    void likePost(Like like);
    void deleteLiked(Like like);

    //accessing likes
    boolean isLiked(Long userId,Long postId);
    List<Like> getLikedPosts(Long userId, int page, String direction);
    List<Like> getPostLikes(Long postId, int page, String direction);
}
