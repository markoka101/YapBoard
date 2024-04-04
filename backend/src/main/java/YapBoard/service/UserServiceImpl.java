package YapBoard.service;

import YapBoard.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public void saveUser(User user) {

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
