package bellproject.view;

import bellproject.server.pojo.OfficeEntity;
import bellproject.server.pojo.OrganizationEntity;

public class OfficeView extends View {

    public long id;
    public String name;
    public String address;
    public String phone;
    public boolean isActive;
    public long orgId;

    public OfficeView() {
    }

    public OfficeView(OfficeEntity officeEntity) {
        this.id = officeEntity.getId();
        this.name = officeEntity.getName();
        this.address = officeEntity.getAddress();
        this.phone = officeEntity.getPhone();
        this.isActive = officeEntity.isActive();
        if(officeEntity.getOrgId() != null) {
            this.orgId = officeEntity.getOrgId().getId();
        }
    }

    public OfficeEntity parseOfficeEntity(){
        OrganizationEntity organizationEntity = new OrganizationEntity();
        organizationEntity.setId(orgId);
        return new OfficeEntity(id, name, address, phone, isActive, organizationEntity);
    }
}
