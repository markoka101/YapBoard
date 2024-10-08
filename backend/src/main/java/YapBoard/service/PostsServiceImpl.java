package YapBoard.service;

import YapBoard.entity.Posts;
import YapBoard.entity.Tags;
import YapBoard.entity.User;
import YapBoard.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void createPost(Posts posts,Long userId) {

        //set the user for the post
        User user = userService.getUser(userId);
        posts.setUser(user);

        //check if all the tags exist in list, if not create it
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
        //save the changes made to post
        postsRepository.save(posts);
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
        Pageable pageable;
        if (direction.equals("asc"))  {
            pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.ASC));
        } else {
            pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC));
        }

        Page<Posts> posts = postsRepository.findByUser(userId,pageable);

        if (posts == null) {
            return null;
        }
        return posts.getContent();
    }

    //get every post
    @Override
    public List<Posts> getAllPosts(int page) {
        Pageable pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.DESC));
        Page<Posts> posts = postsRepository.findAll(pageable);

        return posts.getContent();
    }

    //get posts by title
    @Override
    public List<Posts> getPostsByTitle(String title, int page, String direction) {
        Pageable pageable;
        if (direction.equals("asc")) {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.ASC));
        } else {
            pageable = PageRequest.of(page,10,Sort.by(Sort.Direction.DESC));
        }

        Page<Posts> posts = postsRepository.findByTitleLike(title,pageable);
        if (posts == null)  {
            return null;
        }
        return posts.getContent();
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
