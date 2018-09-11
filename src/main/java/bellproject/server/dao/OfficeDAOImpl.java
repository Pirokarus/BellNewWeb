package bellproject.server.dao;

import bellproject.server.pojo.OfficeEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("officeDAO")
public class OfficeDAOImpl implements OfficeDAO {

    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void saveOffice(OfficeEntity officeEntity) {
        em.persist(officeEntity);
    }

    public List<OfficeEntity> findAllOffices() {
        TypedQuery<OfficeEntity> query = em.createQuery("SELECT p FROM OfficeEntity p", OfficeEntity.class);
        return query.getResultList();
    }

    public OfficeEntity findOfficeById(long id) {
        return em.find(OfficeEntity.class, id);
    }

    @Override
    public void update(OfficeEntity officeEntity) {
        em.merge(officeEntity);
    }

}
