import YapBoard.entity.User;
import YapBoard.repository.FollowRepository;
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
import org.springframework.data.domain.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;
    @Mock
    private FollowRepository followRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    private User user6;
    private User user7;
    private List<User> users;
    private Page<User> usersPage;
    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        user = User.builder()
                .id(1L)
                .username("testuser")
                .password("password123")
                .build();

        user2 = User.builder()
                .id(2L)
                .username("testr2")
                .password("password123")
                .build();

        user3 = User.builder()
                .id(3L)
                .username("t3")
                .password("password123")
                .build();

        user4 = User.builder()
                .id(4L)
                .username("4tester")
                .password("password123")
                .build();

        user5 = User.builder()
                .id(5L)
                .username("5user")
                .password("password123")
                .build();

        user6 = User.builder()
                .id(6L)
                .username("t6er")
                .password("password123")
                .build();

        user7 = User.builder()
                .id(7L)
                .username("7th")
                .password("password123")
                .build();

        users = Arrays.asList(user,user2,user3,user4,user5,user6,user7);
        usersPage = new PageImpl<>(users);
        userService = new UserServiceImpl(userRepository,bCryptPasswordEncoder(),followRepository);
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
        userRepository.saveAll(users);
        Pageable paging = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC,"id"));
        given(userRepository.findAll(paging))
                .willReturn(usersPage);

        assertThat(userService.getAllUsers(0,"id","asc")).isEqualTo(usersPage.getContent());
    }

    @DisplayName("search users with pagination")
    @Test
    public void searchUsers() {
        userRepository.saveAll(users);
        Pageable paging = PageRequest.of(0,5, Sort.by(Sort.Direction.ASC,"id"));
        given(userRepository.findByUsernameLike("tes",paging))
                .willReturn(usersPage);

        assertThat(userService.searchUsers("tes",0,"id","asc")).isEqualTo(usersPage.getContent());
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
