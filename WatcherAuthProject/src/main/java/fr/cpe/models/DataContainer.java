package fr.cpe.models;

import fr.cpe.utils.Role;

import java.util.List;

// User data container that checks users
public class DataContainer {
    public Role checkUser(UserModel user, List<User> userList) {
        for (User u : userList) {
            if (u.getLogin().equals(user.getLogin()) && u.getPwd().equals(user.getPwd())) {
                return Role.getEnumByString(u.getRole());
            }
        }
        return Role.NONE;
    }
}
