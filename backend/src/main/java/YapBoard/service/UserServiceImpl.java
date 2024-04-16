package YapBoard.service;

import YapBoard.entity.Role;
import YapBoard.entity.User;
import YapBoard.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private FollowService followService;


    @Override
    public void saveUser(User user) {
        //encode password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        //set user role
        user.addRole(new Role(2L));

        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public User getUserEmail(String email) {
        return null;
    }

    @Override
    public void editUsername(Long id, String updatedName) {

    }

    @Override
    public void setUserEmail(Long id, String email) {

    }

    @Override
    public void deleteEmail(Long id) {

    }

    @Override
    public List<User> getAllUsers(int page) {
        return null;
    }

    @Override
    public List<User> searchUsers(String name, int page) {
        return null;
    }

    @Override
    public List<User> followedUsers(Long id, int page) {
        return null;
    }

    @Override
    public List<User> usersFollowing(Long id, int page) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
