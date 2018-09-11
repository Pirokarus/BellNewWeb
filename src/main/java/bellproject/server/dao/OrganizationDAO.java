package bellproject.server.dao;

import bellproject.server.pojo.OrganizationEntity;

import java.util.List;

public interface OrganizationDAO {
    void saveOrganization(OrganizationEntity organizationEntity);

    List<OrganizationEntity> findAllOrganizations();

    OrganizationEntity findOrganizationById(long id);

    void update(OrganizationEntity organizationEntity);
}
