package YapBoard.service;

import YapBoard.entity.Posts;

import java.util.List;

public class PostsServiceImpl implements PostsService{
    @Override
    public void createPost(Posts posts) {

    }

    @Override
    public void editPost(Posts posts) {

    }

    @Override
    public void deletePost(Posts post) {

    }

    @Override
    public List<Posts> getUserPosts(Long userId, int page) {
        return null;
    }

    @Override
    public List<Posts> getAllPosts(int page) {
        return null;
    }

    @Override
    public List<Posts> getPostsByTitle(String title, int page) {
        return null;
    }

    @Override
    public List<Posts> getFollowedPosts(Long userId, int page) {
        return null;
    }

    @Override
    public List<Posts> getByTag(String tag, int page) {
        return null;
    }
}
