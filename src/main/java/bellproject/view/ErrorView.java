package bellproject.view;

public class ErrorView {
    public String error;

    public ErrorView() {
    }

    public ErrorView(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "{" +
                "\"error\" : \"" + error + "\"" +
                "}";
    }
}
