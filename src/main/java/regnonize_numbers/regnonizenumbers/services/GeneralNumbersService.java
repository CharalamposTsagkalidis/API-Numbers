package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;

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
        responseNumbers.setSizeOfNaturalNumbers(responseNumbers.getSizeOfNaturalNumbers());
        responseNumbers.setSizeOfWholeNumbers(responseNumbers.getSizeOfWholeNumbers());
        responseNumbers.setSizeOfRealNumbers(responseNumbers.getSizeOfRealNumbers());
        return responseNumbers;
    }

    private boolean ifStringContainsOnlyDigits(String stringNumbers) {
        if (stringNumbers != null && stringNumbers.matches("-?\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> primeOrComposite(GeneralNumbersModel longNumbers) {
        List<String> response = new ArrayList<>();
        for (Long number : longNumbers.getLongNumbers()) {
            if (number < 2) {
                // neither prime nor composite
                response.add(number + " is neither prime nor composite.");
            } else if (this.isPrime(number)) {
                // prime
                response.add(number + " is a prime number.");
            } else {
                // composite
                response.add(number + " is a composite number.");
            }
        }
        return response;
    }

    private boolean isPrime(Long number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }

    public Integer fibonacciResult(ArrayList<Integer> incomingNumbers) {
        if (incomingNumbers != null && !incomingNumbers.isEmpty()) {
            if(incomingNumbers.getLast() > 0 && incomingNumbers.getLast() > 2) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            Integer lastNumber = incomingNumbers.getLast();
            Integer oneBeforeLastNumber = incomingNumbers.get(incomingNumbers.size() - 2);
            Integer result = lastNumber + oneBeforeLastNumber;
            return result;
        }

        return null;
    }
}
