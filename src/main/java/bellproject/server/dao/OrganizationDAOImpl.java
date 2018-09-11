package bellproject.server.dao;

import bellproject.server.pojo.OrganizationEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("organizationDAO")
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void saveOrganization(OrganizationEntity organizationEntity) {
        em.persist(organizationEntity);
    }

    public List<OrganizationEntity> findAllOrganizations() {
        TypedQuery<OrganizationEntity> query = em.createQuery("SELECT p FROM OrganizationEntity p", OrganizationEntity.class);
        return query.getResultList();
    }

    public OrganizationEntity findOrganizationById(long id) {
        return em.find(OrganizationEntity.class, id);
    }

    @Override
    public void update(OrganizationEntity organizationEntity) {
        em.merge(organizationEntity);
    }

}
