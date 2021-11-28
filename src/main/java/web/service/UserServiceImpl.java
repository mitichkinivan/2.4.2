package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAOImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDAOImpl userDAO;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.getUserByLogin(username);
    }

    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public User userById(int id) {
        return userDAO.userById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(int id, User updateUser) {
        userDAO.update(id, updateUser);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getUserByLogin(String username) {
        return userDAO.getUserByLogin(username);
    }
}