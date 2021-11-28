package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    User userById(int id);

    void save(User user);

    void update(int id, User updateUser);

    void delete(int id);

    User getUserByLogin(String username);
}
