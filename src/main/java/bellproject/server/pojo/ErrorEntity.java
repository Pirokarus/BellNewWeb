package bellproject.server.pojo;

import java.util.Objects;

public class ErrorEntity {

    String error;

    public ErrorEntity() {
    }

    public ErrorEntity(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorEntity)) return false;
        ErrorEntity that = (ErrorEntity) o;
        return Objects.equals(error, that.error);
    }

    @Override
    public int hashCode() {

        return Objects.hash(error);
    }
}
