package main.java;

import java.util.List;

public class AddProductResponse {

    private boolean success;
    private List<String> errors;

    public AddProductResponse(boolean success,
                              List<String> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getErrorMessage() {
        return errors;
    }
}
