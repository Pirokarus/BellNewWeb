package bellproject.server.service;



import bellproject.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    void saveOrganization(OrganizationView organizationView);

    List<OrganizationView> findAllOrganization();

    OrganizationView findOrganizationById(long id);

    void update(OrganizationView organizationView);
}
