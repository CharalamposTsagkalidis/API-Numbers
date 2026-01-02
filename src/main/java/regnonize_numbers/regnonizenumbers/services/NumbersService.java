package regnonize_numbers.regnonizenumbers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {
    // natural numbers
    protected List<Integer> isNatural(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        if (number > 0) {
            // zerois is not a natural number
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }

    // whole numbers
    protected List<Integer> ifWholeNumber(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        // zerois is not a natural number
        if (number >= 0) {
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }

    protected Boolean isPrime(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    protected Boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    protected Boolean isNaturalB(Integer number) {
        return number > 0;
    }

    public void ifRationalOrIrrational(List<Long> rationalNumbers, List<Long> irrationalNumbers) {
        // TODO: Implement logic to determine if numbers are rational or irrational
    }

    protected List<Integer> ifReal(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        if (number >= 0 || number <= 0) {
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }

    protected Boolean isFibonacci(Integer number) { //number = 3
        int a = 0, b = 1;
        while (b < number) {
            int temp = b; // temp = 1 // temp = 1 // temp = 2
            b = a + b; //b = 0 + 1 = 1 // b = 1 + 1 = 2 // b = 1 + 2 = 3
            a = temp; // a = 1 // a = 1 // a = 2
        }
        return b == number; //3 == 3
    }

    protected final String convertDecimalToBinary(Integer decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal = decimal / 2;
        }
        return binary.toString();
    }
}
