package bellproject.server.service;

import bellproject.view.UserView;

import java.util.List;

public interface UserService {

    void saveUser(UserView usersView);

    List<UserView> findAllUsers();

    UserView findUserById(long id);

    void update(UserView usersView);
}
