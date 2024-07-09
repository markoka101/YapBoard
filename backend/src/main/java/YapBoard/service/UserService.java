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
    List<User> getAllUsers(int page, String sortBy, String direction);
    List<User> searchUsers(String name, int page, String sortBy, String direction);
    List<User> followedUsers(Long id, int page, String sortBy, String direction);
    List<User> usersFollowing(Long id, int page, String sortBy, String direction);

    //check if user is following
    boolean isFollowing(Long userId,Long followId);

    //delete user
    void deleteUser(Long id);
}
