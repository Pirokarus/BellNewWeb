package bellproject.server.pojo;

import javax.persistence.*;

@Entity
@Table(name = "DOCS", schema = "BELL", catalog = "")
public class DocsEntity {
    private long code;
    private String name;

    public DocsEntity() {
    }

    public DocsEntity(long code) {
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

        DocsEntity that = (DocsEntity) o;

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
