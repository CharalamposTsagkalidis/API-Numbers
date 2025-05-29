package regnonize_numbers.regnonizenumbers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

    // public ResponseEntity<List<Integer>> ifReal(List<Integer> numbers) {
    //     List<Integer> indeedNaturals = new ArrayList<>();
    //     if (numbers == null || numbers.isEmpty()) {
    //         for (Integer number : numbers) {
    //             if (number >= 0 || number <= 0) {
    //                 indeedNaturals.add(number);
    //             }
    //         }
    //         return ResponseEntity.ok(indeedNaturals);

    //     } else {
    //         return ResponseEntity.badRequest().body(null);
    //     }
    // }
}
