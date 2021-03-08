package web.dao;



import org.springframework.stereotype.Repository;
import web.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User"
                , User.class).getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User findUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUsername(String name) {
        User user = entityManager.createQuery("SELECT u from User u WHERE u.firstName = :name", User.class).
                setParameter("name", name).getSingleResult();
        return user;

    }
}
