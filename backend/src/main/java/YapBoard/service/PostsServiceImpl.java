package YapBoard.service;

import YapBoard.entity.Posts;
import YapBoard.repository.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService{
    private PostsRepository postsRepository;
    private UserService userService;
    @Override
    public void createPost(Posts posts) {

    }

    @Override
    public void editPost(Posts posts) {

    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public List<Posts> getUserPosts(Long userId, int page, String direction) {
        return null;
    }

    @Override
    public List<Posts> getAllPosts(int page) {
        return null;
    }

    @Override
    public List<Posts> getPostsByTitle(String title, int page, String direction) {
        return null;
    }

    @Override
    public List<Posts> getFollowedPosts(Long userId, int page, String direction) {
        return null;
    }

    @Override
    public List<Posts> getByTag(String tag, int page, String direction) {
        return null;
    }
}
