import YapBoard.entity.Posts;
import YapBoard.entity.User;
import YapBoard.repository.FollowRepository;
import YapBoard.repository.PostsRepository;
import YapBoard.repository.UserRepository;
import YapBoard.service.PostsServiceImpl;
import YapBoard.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PostsServiceTests {

    /*
    Mocks for posts
     */
    @Mock
    private PostsRepository postsRepository;
    @InjectMocks
    private PostsServiceImpl postsService;

    /*
    Mocks for user
     */
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    //Mocks/beans required for userService to work
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Mock
    private FollowRepository followRepository;

    private Posts post;
    private User user;
    private List<Posts> postsList;
    private Page<Posts> postsPage;

    @BeforeEach
    public void setUp() {
        postsRepository = Mockito.mock(PostsRepository.class);
        userRepository = Mockito.mock(UserRepository.class);
    }

    @DisplayName("Create post")
    @Test
    public void createUser(){}

    @DisplayName("Edit post")
    @Test
    public void editPost(){}

    @DisplayName("Get user posts")
    @Test
    public void getUserPosts(){}

    @DisplayName("Get all posts")
    @Test
    public void getAllPosts(){}

    @DisplayName("Get posts by title")
    @Test
    public void getPostsByTitle(){}
}
