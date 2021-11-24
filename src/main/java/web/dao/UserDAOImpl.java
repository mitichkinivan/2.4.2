package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Component
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> allUsers() {
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
        user.setAge(updateUser.getAge());
        entityManager.persist(user);
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}