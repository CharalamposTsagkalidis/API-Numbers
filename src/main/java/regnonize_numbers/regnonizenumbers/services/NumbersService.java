package regnonize_numbers.regnonizenumbers.services;

import java.util.List;

import org.springframework.stereotype.Service;

import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;

@Service
public class NumbersService {

    // natural numbers
    public List<Long> isNatural(List<Long> naturalNumbers) {
        if (naturalNumbers == null || naturalNumbers.isEmpty()) {
            if (naturalNumbers.stream().allMatch(num -> num >= 0)) {
                return naturalNumbers;
            } else {
                throw new IllegalArgumentException("Input list contains non-natural numbers");
            }
        } else {
            throw new IllegalArgumentException("Input list is null or empty");
        }
    }

    // whole numbers
    public void ifWholeNumber() {

    }

    // integers
    public void ifInteger() {

    }

    // rational numbers
    // irrational numbers
    public void ifRationalIrrational(List<Long> rationalNumbers, List<Long> irrationalNumbers) {
        if(rationalNumbers == null || rationalNumbers.isEmpty() || irrationalNumbers == null || irrationalNumbers.isEmpty()) {
            throw new IllegalArgumentException("Input lists cannot be null or empty");
        }
        
    }

    // real numbers
    public void idReal() {

    }

    // complex numbers
    public void ifComplex() {

    }

}
