package bellproject.view;

import bellproject.server.pojo.CountriesEntity;
import bellproject.server.pojo.DocsEntity;
import bellproject.server.pojo.OfficeEntity;
import bellproject.server.pojo.UsersEntity;

public class UserView extends View {
    public long id;
    public String firstName;
    public String lastName;
    public String middleName;
    public String position;
    public String officeId;
    public String docCode;
    public String docName;
    public String citizenshipCode;
    public String citizenshipName;

    public UserView() {
    }

    public UserView(UsersEntity usersEntity) {
        this.id = usersEntity.getId();
        this.firstName = usersEntity.getFirstName();
        this.lastName = usersEntity.getLastName();
        this.middleName = usersEntity.getMiddleName();
        this.position = usersEntity.getPosition();
        if(usersEntity.getOfficeId() != null) {
            this.officeId = Long.toString(usersEntity.getOfficeId().getId());
        }
        if (usersEntity.getDocCode() != null) {
            this.docCode = Long.toString(usersEntity.getDocCode().getCode());
            this.docName = usersEntity.getDocCode().getName();
        }
        if (usersEntity.getCitizenshipCode() != null) {
            this.citizenshipCode = Long.toString(usersEntity.getCitizenshipCode().getCode());
            this.citizenshipName = usersEntity.getCitizenshipCode().getName();
        }
    }

    public UsersEntity parseUsersEntity(){
        OfficeEntity officeEntity = this.officeId != null ? new OfficeEntity(Long.parseLong(this.officeId)) : null;
        DocsEntity docsEntity = this.docCode != null ? new DocsEntity(Long.parseLong(this.docCode)) : null;
        CountriesEntity countriesEntity = this.citizenshipCode != null ? new CountriesEntity(Long.parseLong(this.citizenshipCode)) : null;

        return new UsersEntity(id, firstName, lastName, middleName, position, officeEntity, docsEntity, countriesEntity);
    }

}
