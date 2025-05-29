package regnonize_numbers.regnonizenumbers.helper;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

public class ServerErrorException extends RuntimeException {
    private List<ResponseEntity<Map<String, String>>> errors;

    public ServerErrorException(String message) {
        super(message);
    }

    public List<ResponseEntity<Map<String, String>>> getErrors() {
        return errors;
    }

    public List<ResponseEntity<Map<String,String>>> setErrors(List<ResponseEntity<Map<String, String>>> errors) {
        this.errors = errors;
        return errors;
    }


}
