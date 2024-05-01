package YapBoard.service;

import YapBoard.entity.Posts;

import java.util.List;

public interface PostsService {
    //modifying posts
    void createPost(Posts posts);
    void editPost(Posts posts);
    void deletePost(Long id);

    //getting posts
    List<Posts> getUserPosts(Long userId, int page, String direction);
    List<Posts> getAllPosts(int page);
    List<Posts> getPostsByTitle(String title, int page, String direction);
    List<Posts> getFollowedPosts(Long userId, int page, String direction);
    List<Posts> getByTag(String tag, int page, String direction);

}
