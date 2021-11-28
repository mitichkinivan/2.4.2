package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> allUsers() {
        System.out.println("таблица allUsers");
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    public User userById(int id) {
        TypedQuery<User> q = entityManager.createQuery("select user from User user where user.id = :id", User.class);
        q.setParameter("id", id);
        User result = q.getResultList().stream().filter(user -> user.getId() == id).findAny().orElse(null);
        return result;
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updateUser) {
        User user = userById(id);
        user.setName(updateUser.getName());
        user.setSurName(updateUser.getSurName());
        entityManager.merge(user);
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByLogin(String username) {
        TypedQuery<User> q = entityManager
                .createQuery("select user from User user where user.username = :username", User.class);
        q.setParameter("username", username);
        User result = q.getSingleResult();
        return result;
    }
}