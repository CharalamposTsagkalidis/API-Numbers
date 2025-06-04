package regnonize_numbers.regnonizenumbers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {
    // natural numbers
    public List<Integer> isNatural(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        if (number > 0) {
            // zerois is not a natural number
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }

    // whole numbers
    public List<Integer> ifWholeNumber(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        // zerois is not a natural number
        if (number >= 0) {
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }

    // rational numbers
    // irrational numbers
    public void ifRationalOrIrrational(List<Long> rationalNumbers, List<Long> irrationalNumbers) {
        if (rationalNumbers == null || rationalNumbers.isEmpty() || irrationalNumbers == null
                || irrationalNumbers.isEmpty()) {
            throw new IllegalArgumentException("Input lists cannot be null or empty");
        }

    }

    public List<Integer> ifReal(Integer number) {
        List<Integer> indeedNaturals = new ArrayList<>();
        if (number >= 0 || number <= 0) {
            indeedNaturals.add(number);
        }
        return indeedNaturals;
    }
}
