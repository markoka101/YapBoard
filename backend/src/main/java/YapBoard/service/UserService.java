package YapBoard.service;

import YapBoard.entity.User;

import java.util.List;

public interface
UserService {

    //accessing user
    void saveUser(User user);
    User getUser(Long id);
    User getUser(String username);
    User getUserEmail(String email);

    //edit user
    void editUsername(Long id, String updatedName);
    void setUserEmail(Long id, String email);
    void deleteEmail(Long id);

    //searching users
    List<User> getAllUsers(int page);
    List<User> searchUsers(String name, int page);
    List<User> followedUsers(Long id, int page);
    List<User> usersFollowing(Long id, int page);

    //delete user
    void deleteUser(Long id);
}
