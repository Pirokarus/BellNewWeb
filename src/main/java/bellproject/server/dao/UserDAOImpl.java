package bellproject.server.dao;

import bellproject.server.pojo.UsersEntity;
import bellproject.view.UserView;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void saveUser(UserView userView) {
        em.persist(userView.parseUsersEntity());
    }

    public List<UserView> findAllUsers() {
        TypedQuery<UsersEntity> query = em.createQuery("SELECT p FROM UsersEntity p", UsersEntity.class);
        return query.getResultList().stream().map(UserView::new).collect(Collectors.toList());
    }

    public UserView findUserById(long id) {
        return new UserView(em.find(UsersEntity.class, id));
    }

    @Override
    public void update(UserView userView) {
        em.merge(userView.parseUsersEntity());
    }

}
