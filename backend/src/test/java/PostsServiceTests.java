import YapBoard.repository.PostsRepository;
import YapBoard.repository.UserRepository;
import YapBoard.service.PostsServiceImpl;
import YapBoard.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PostsServiceTests {

    @Mock
    private PostsRepository postsRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostsServiceImpl postsService;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {

    }
}
