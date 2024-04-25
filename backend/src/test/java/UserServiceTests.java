import YapBoard.entity.User;
import YapBoard.repository.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        user = User.builder()
                .id(1L)
                .username("testuser")
                .password("password123")
                .build();

        userService = new UserServiceImpl(userRepository,bCryptPasswordEncoder());
    }

    @DisplayName("get user by id")
    @Test
    public void findUserMethods() {

        userRepository.save(user);

        given(userRepository.findById(user.getId()))
                .willReturn(Optional.of(user));

        assertThat(userService.getUser(1L)).isEqualTo(user);
    }

    @DisplayName(("get user by email"))
    @Test
    public void findByEmail() {

        user.setEmail("testuser@gmail.com");
        userRepository.save(user);

        given(userRepository.findByEmail(user.getEmail()))
                .willReturn(Optional.of(user));

        assertThat(userService.getUserEmail("testuser@gmail.com")).isEqualTo(user);
    }

    @DisplayName("get user by username")
    @Test
    public void findByUsername() {
        userRepository.save(user);

        given(userRepository.findByUsername(user.getUsername()))
                .willReturn(Optional.of(user));

        assertThat(userService.getUser("testuser")).isEqualTo(user);
    }
    @DisplayName("edit username")
    @Test
    public void editUsername() {
        userRepository.save(user);

        given(userRepository.findById(user.getId()))
                .willReturn(Optional.of((user)));

        userService.editUsername(user.getId(),"edited");
        assertThat(user.getUsername()).isEqualTo("edited");
    }

    @DisplayName("delete user email")
    @Test
    public void editEmail() {
        user.setEmail("delete@gmail.com");
        userRepository.save(user);

        given(userRepository.findById(user.getId()))
                .willReturn(Optional.of(user));

        userService.deleteEmail(user.getId());
        assertThat(user.getEmail()).isNull();
    }

    @DisplayName("set user email")
    @Test
    public void setEmail() {
        userRepository.save(user);

        given(userRepository.findById(user.getId()))
                .willReturn(Optional.of(user));

        userService.setUserEmail(user.getId(),"newEmail@gmail.com");

        assertThat(user.getEmail()).isEqualTo("newEmail@gmail.com");
    }
    @DisplayName("get all users with pagination")
    @Test
    public void getAllUsers() {
    }

    @DisplayName("search users with pagination")
    @Test
    public void searchUsers() {

    }

    @DisplayName("look at user followers with pagination")
    @Test
    public void searchFollowers(){

    }

    @DisplayName("look at user followed with pagination")
    @Test
    public void searchFollowed() {

    }
}
