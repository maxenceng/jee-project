package fr.cpe.ejb;

import fr.cpe.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// EJB that gets user list from the DB
@Stateless
public class UserDao implements UserDaoLocal {
    @PersistenceContext(unitName = "primary") EntityManager em;

    @Override
    public List<User> getUserList() {
        return em.createNamedQuery("Users.list").getResultList();
    }
}
