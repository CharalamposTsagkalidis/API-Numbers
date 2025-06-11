package regnonize_numbers.regnonizenumbers.models;

import java.util.List;

public class GeneralNumbersModel {
    private List<String> numbers;
    private List<Long> longNumbers;
    public GeneralNumbersModel() {

    }

    public GeneralNumbersModel(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<Long> getLongNumbers() {
        return longNumbers;
    }

    public void setLongNumbers(List<Long> longNumbers) {
        this.longNumbers = longNumbers;
    }
    
}
