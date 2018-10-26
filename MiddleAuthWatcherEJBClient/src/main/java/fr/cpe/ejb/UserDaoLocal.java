package fr.cpe.ejb;

import fr.cpe.models.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDaoLocal {
    List<User> getUserList();
}
