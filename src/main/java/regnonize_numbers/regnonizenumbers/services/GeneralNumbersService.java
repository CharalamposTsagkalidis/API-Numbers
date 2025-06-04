package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import regnonize_numbers.regnonizenumbers.helper.ResponseNumbers;

@Service
public class GeneralNumbersService {
    private final NumbersService numbersService;
    public Integer globalNumber = 0;

    public GeneralNumbersService(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    public ResponseNumbers getAllNumbers(List<String> incomingStringNumbers) {
        List<Integer> indeedNumbers = new ArrayList<>();
        List<Integer> naturalNumbers = new ArrayList<>();
        List<Integer> wholeNumbers = new ArrayList<>();
        List<Integer> realNumbers = new ArrayList<>();
        ResponseNumbers responseNumbers = new ResponseNumbers();
        for (String stringNumber : incomingStringNumbers) {
            if (stringNumber != null && ifStringContainsOnlyDigits(stringNumber)) {
                indeedNumbers.add(Integer.parseInt(stringNumber));
                globalNumber = Integer.parseInt(stringNumber);
                List<Integer> responseOfNaturals = this.numbersService.isNatural(globalNumber);
                naturalNumbers.addAll(responseOfNaturals);
                List<Integer> responseOfWholeNumbers = this.numbersService.ifWholeNumber(globalNumber);
                wholeNumbers.addAll(responseOfWholeNumbers);
                List<Integer> responseOfRealNumbers = this.numbersService.ifReal(globalNumber);
                realNumbers.addAll(responseOfRealNumbers);
            }
        }
        responseNumbers.setNaturalNumbers(naturalNumbers);
        responseNumbers.setWholeNumbers(wholeNumbers);
        responseNumbers.setRealNumbers(realNumbers);
        return responseNumbers;
    }

    private boolean ifStringContainsOnlyDigits(String stringNumbers) {
        if (stringNumbers != null && stringNumbers.matches("-?\\d+")) {
            return true;
        } else {
            return false;
        }
    }
}
