package YapBoard.service;

import YapBoard.entity.Role;
import YapBoard.entity.User;
import YapBoard.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user);
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return unwrapUser(user);
    }

    @Override
    public User getUserEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return unwrapUser(user);
    }

    @Override
    public void editUsername(Long id, String updatedName) {
        Optional<User> user = userRepository.findById(id);
        User unwrapped = unwrapUser(user);

        unwrapped.setUsername(updatedName);
        userRepository.save(unwrapped);
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

    static User unwrapUser(Optional<User> entity) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }
}
