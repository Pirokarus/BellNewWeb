package bellproject.server.service;

import bellproject.server.dao.OrganizationDAO;
import bellproject.server.pojo.OrganizationEntity;
import bellproject.view.OrganizationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDAO;

    public void saveOrganization(OrganizationView organizationView) {
        organizationDAO.saveOrganization(new OrganizationEntity(organizationView.id,
                organizationView.name,
                organizationView.fullName,
                organizationView.inn,
                organizationView.kpp,
                organizationView.address,
                organizationView.phone,
                organizationView.isActive));
    }

    public List<OrganizationView> findAllOrganization() {
        return organizationDAO.findAllOrganizations().stream().map(getOrganizationView()).collect(Collectors.toList());
    }

    public OrganizationView findOrganizationById(long id) {
        return getOrganizationView().apply(organizationDAO.findOrganizationById(id));
    }

    @Override
    public void update(OrganizationView organizationView) {
        organizationDAO.update(new OrganizationEntity(organizationView.id,
                organizationView.name,
                organizationView.fullName,
                organizationView.inn,
                organizationView.kpp,
                organizationView.address,
                organizationView.phone,
                organizationView.isActive));
    }

    private Function<OrganizationEntity, OrganizationView> getOrganizationView(){
        return o -> {
            OrganizationView organizationView = new OrganizationView();
            organizationView.id = o.getId();
            organizationView.name = o.getName();
            organizationView.fullName = o.getFullName();
            organizationView.inn = o.getInn();
            organizationView.kpp = o.getKpp();
            organizationView.address = o.getAddress();
            organizationView.phone = o.getPhone();
            organizationView.isActive = o.isActive();
            return organizationView;
        };
    }
}
