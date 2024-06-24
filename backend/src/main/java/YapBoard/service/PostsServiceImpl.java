package YapBoard.service;

import YapBoard.entity.Posts;
import YapBoard.entity.Tags;
import YapBoard.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostsServiceImpl implements PostsService{
    private PostsRepository postsRepository;
    private TagsService tagsService;
    private UserService userService;

    //create post
    @Override
    public void createPost(Posts posts) {
        if (posts.getTags() != null) {
            for (Tags t : posts.getTags()) {
                if (!tagsService.tagExists(t.getTag())) {
                    tagsService.createTag(t);
                }
                tagsService.addPostToTags(posts,t);
            }
        }
        postsRepository.save(posts);
    }

    //edit post
    @Override
    public void editPost(Posts posts) {

    }

    //delete post
    @Override
    public void deletePost(Long id) {
        Optional<Posts> post = postsRepository.findById(id);
        Posts unwrappedPost = unwrapPost(post);
        postsRepository.delete(unwrappedPost);
    }

    //get posts by user
    @Override
    public List<Posts> getUserPosts(Long userId, int page, String direction) {
        return null;
    }

    //get every post
    @Override
    public List<Posts> getAllPosts(int page) {
        return null;
    }

    //get posts by title
    @Override
    public List<Posts> getPostsByTitle(String title, int page, String direction) {
        return null;
    }

    //get posts from followed users
    @Override
    public List<Posts> getFollowedPosts(Long userId, int page, String direction) {
        return null;
    }

    //get posts by their tags
    @Override
    public List<Posts> getByTag(String tag, int page, String direction) {
        return null;
    }

    //unwrap optional to Posts object
    static Posts unwrapPost(Optional<Posts> entity) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }
}
