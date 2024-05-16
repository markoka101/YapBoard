package YapBoard.service;

import YapBoard.entity.Role;
import YapBoard.entity.User;
import YapBoard.repository.FollowRepository;
import YapBoard.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private FollowRepository followRepository;

    //save user to repo
    @Override
    public void saveUser(User user) {
        //encode password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        //set user role
        user.addRole(new Role(2L));

        userRepository.save(user);
    }

    //getting user by id
    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user);
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return unwrapUser(user);
    }

    //getting user by email
    @Override
    public User getUserEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return unwrapUser(user);
    }

    //edit user's username
    @Override
    public void editUsername(Long id, String updatedName) {
        Optional<User> user = userRepository.findById(id);
        User unwrapped = unwrapUser(user);

        unwrapped.setUsername(updatedName);
        userRepository.save(unwrapped);
    }

    //set user's email
    @Override
    public void setUserEmail(Long id, String email) {
        Optional<User> user = userRepository.findById(id);
        User unwrapped = unwrapUser(user);
        unwrapped.setEmail(email);
    }

    //delete user's email
    @Override
    public void deleteEmail(Long id) {
        Optional<User> user = userRepository.findById(id);
        User unwrapped = unwrapUser(user);
        unwrapped.setEmail(null);
        userRepository.save(unwrapped);
    }

    //get all users by page
    @Override
    public List<User> getAllUsers(int page, String sortBy, String direction) {
        Pageable pageable;
        //how it will be ordered
        if (direction.equals("asc")) {
            pageable = PageRequest.of(page,5,Sort.by(Sort.Direction.ASC,sortBy));
        } else {
            pageable = PageRequest.of(page,5,Sort.by(Sort.Direction.DESC,sortBy));
        }

        Page<User> users = userRepository.findAll(pageable);

        return users.getContent();
    }

    //search users by page
    @Override
    public List<User> searchUsers(String name, int page, String sortBy, String direction) {
        Pageable pageable;
        //how it will be ordered
        if (direction.equals("asc")) {
            pageable = PageRequest.of(page,5,Sort.by(Sort.Direction.ASC,sortBy));
        } else {
            pageable = PageRequest.of(page,5,Sort.by(Sort.Direction.DESC, sortBy));
        }

        Page<User> users = userRepository.findByUsernameLike(name,pageable);

        if (users == null) {
            return null;
        }
        return users.getContent();
    }

    @Override
    public List<User> followedUsers(Long id, int page, String sortBy, String direction) {
        return null;
    }

    @Override
    public List<User> usersFollowing(Long id, int page, String sortBy, String direction) {
        return null;
    }

    //delete user
    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        User unwrappedUser = unwrapUser(user);
        userRepository.delete(unwrappedUser);
    }

    //unwrap optional to user object
    static User unwrapUser(Optional<User> entity) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException("User not found");
        }
    }
}
