package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import regnonize_numbers.regnonizenumbers.helper.ServerErrorException;

@Service
public class GeneralNumbersService {
    private ServerErrorException serverError;

    public GeneralNumbersService(ServerErrorException serverError) {
        this.serverError = serverError;
    }

    public List<?> getAllNumbers(List<String> incomingStringNumbers) {
        for (String stringNumber : incomingStringNumbers) {
            if ((stringNumber == null || stringNumber.isEmpty()) && ifStringContainsOnlyDigits(stringNumber)) {

                return serverError.setErrors(
                        List.of(ResponseEntity.badRequest().body(Map.of("error", "Input list cannot be null or empty"))));
            }

        }

        return null;
    }

    private boolean ifStringContainsOnlyDigits(String stringNumbers) {

        if (stringNumbers != null && stringNumbers.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
