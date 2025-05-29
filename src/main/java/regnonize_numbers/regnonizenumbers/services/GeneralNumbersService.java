package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import regnonize_numbers.regnonizenumbers.helper.ServerErrorException;

@Service
public class GeneralNumbersService {
    private final ServerErrorException serverError;
    private final NumbersService numbersService;

    public GeneralNumbersService(ServerErrorException serverError, NumbersService numbersService) {
        this.serverError = serverError;
        this.numbersService = numbersService;
    }

    public List<?> getAllNumbers(List<String> incomingStringNumbers) {
        List<Integer> indeedNumbers = new ArrayList<>();
        for (String stringNumber : incomingStringNumbers) {
            if ((stringNumber == null || stringNumber.isEmpty()) && ifStringContainsOnlyDigits(stringNumber)) {
                indeedNumbers.add(Integer.parseInt(stringNumber));
                ResponseEntity<List<Integer>> responseOfNaturals = numbersService.isNatural(indeedNumbers);
                ResponseEntity<List<Integer>> responseOfWholeNumbers = numbersService.ifWholeNumber(indeedNumbers);
                ResponseEntity<List<Integer>> responseOfReals = numbersService.ifReal(indeedNumbers);
                if (responseOfNaturals.getStatusCode().is2xxSuccessful()
                        || responseOfWholeNumbers.getStatusCode().is2xxSuccessful()
                        || responseOfReals.getStatusCode().is2xxSuccessful()) {
                    return indeedNumbers;
                }
                return indeedNumbers;
            }
            return indeedNumbers;
        }
        return indeedNumbers;
    }

    private boolean ifStringContainsOnlyDigits(String stringNumbers) {
        if (stringNumbers != null && stringNumbers.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
