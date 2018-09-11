package bellproject.server.pojo;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRIES", schema = "BELL", catalog = "")
public class CountriesEntity {
    private long code;
    private String name;

    public CountriesEntity() {
    }

    public CountriesEntity(long code) {
        this.code = code;
    }

    @Id
    @Column(name = "CODE")
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (code != that.code) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (code ^ (code >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
