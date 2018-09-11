package bellproject.server.service;

import bellproject.server.dao.UserDAO;
import bellproject.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("usersService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void saveUser(UserView userView) {
        userDAO.saveUser(userView);
    }

    public List<UserView> findAllUsers() {
        return userDAO.findAllUsers();
    }

    public UserView findUserById(long id) {
        return userDAO.findUserById(id);
    }

    public void update(UserView userView){
        userDAO.update(userView);
    }

}
