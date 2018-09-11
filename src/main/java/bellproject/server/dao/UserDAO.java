package bellproject.server.dao;


import bellproject.view.UserView;

import java.util.List;

public interface UserDAO {
    void saveUser(UserView userEntity);

    List<UserView> findAllUsers();

    UserView findUserById(long id);

    void update(UserView userView);

}
