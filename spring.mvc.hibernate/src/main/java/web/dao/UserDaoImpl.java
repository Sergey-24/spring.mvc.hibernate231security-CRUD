package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    EntityManagerFactory entityManagerFactory;


    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<User> allUsers = entityManager.createQuery("from User"
                , User.class).getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(user);

    }
}
