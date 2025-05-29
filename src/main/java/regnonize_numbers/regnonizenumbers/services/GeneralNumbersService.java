package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import regnonize_numbers.regnonizenumbers.helper.ResponseNumbers;
import regnonize_numbers.regnonizenumbers.helper.ServerErrorException;

@Service
public class GeneralNumbersService {
    private final NumbersService numbersService;
    public Integer globalNumber = 0;
    public GeneralNumbersService(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    public ResponseNumbers getAllNumbers(List<String> incomingStringNumbers) {
        List<Integer> indeedNumbers = new ArrayList<>();
        ResponseNumbers responseNumbers = new ResponseNumbers();
        for (String stringNumber : incomingStringNumbers) {
            if ((stringNumber == null || stringNumber.isEmpty()) && ifStringContainsOnlyDigits(stringNumber)) {
                indeedNumbers.add(Integer.parseInt(stringNumber));
                globalNumber = Integer.parseInt(stringNumber);
                List<Integer> responseOfNaturals = this.numbersService.isNatural(globalNumber);
                responseNumbers.setNaturalNumbers(responseOfNaturals);
                List<Integer> responseOfWholeNumbers = this.numbersService.ifWholeNumber(globalNumber);
                responseNumbers.setWholeNumbers(responseOfWholeNumbers);
                //ResponseEntity<List<Integer>> responseOfReals = numbersService.ifReal(indeedNumbers);        
            }
        }
        return responseNumbers;
    }

    private boolean ifStringContainsOnlyDigits(String stringNumbers) {
        if (stringNumbers != null && stringNumbers.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
