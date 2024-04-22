import YapBoard.YapBoardApplication;
import YapBoard.entity.Role;
import YapBoard.entity.User;
import YapBoard.repository.RoleRepository;
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
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;


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
                .email("testuser@gmail.com")
                .build();

        userService = new UserServiceImpl(userRepository,bCryptPasswordEncoder());
    }

    @DisplayName("Check get user methods")
    @Test
    public void findUserMethods() {

        userRepository.save(user);

        given(userRepository.findById(user.getId()))
                .willReturn(Optional.of(user));

        given(userRepository.findByEmail(user.getEmail()))
                .willReturn(Optional.of(user));

        given(userRepository.findByUsername(user.getUsername()))
                .willReturn(Optional.of(user));

        assertThat(userService.getUser(1L)).isEqualTo(user);
        assertThat(userService.getUserEmail("testuser@gmail.com")).isEqualTo(user);
        assertThat(userService.getUser("testuser")).isEqualTo(user);
    }
}
