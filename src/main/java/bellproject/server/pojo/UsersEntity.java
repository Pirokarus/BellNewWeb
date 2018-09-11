package bellproject.server.pojo;

import javax.persistence.*;

@Entity
@Table(name = "USERS", schema = "BELL", catalog = "")
public class UsersEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String position;
    private OfficeEntity officeId;
    private DocsEntity docCode;
    private CountriesEntity citizenshipCode;

    public UsersEntity() {
    }

    public UsersEntity(long id, String firstName, String lastName, String middleName, String position, OfficeEntity officeId, DocsEntity docCode, CountriesEntity citizenshipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.officeId = officeId;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
    }

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "MIDDLE_NAME")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "POSITION")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public OfficeEntity getOfficeId() {
        return officeId;
    }

    public void setOfficeId(OfficeEntity officeId) {
        this.officeId = officeId;
    }

    @ManyToOne
    @JoinColumn(name = "doc_code", referencedColumnName = "code")
    public DocsEntity getDocCode() {
        return docCode;
    }

    public void setDocCode(DocsEntity docCode) {
        this.docCode = docCode;
    }

    @ManyToOne
    @JoinColumn(name = "citizenship_code", referencedColumnName = "code")
    public CountriesEntity getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(CountriesEntity citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (officeId != null ? !officeId.equals(that.officeId) : that.officeId != null) return false;
        if (docCode != null ? !docCode.equals(that.docCode) : that.docCode != null) return false;
        if (citizenshipCode != null ? !citizenshipCode.equals(that.docCode) : that.citizenshipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
