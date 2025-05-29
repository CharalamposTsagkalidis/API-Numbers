package regnonize_numbers.regnonizenumbers.models;

import java.util.List;

public class GeneralNumbersModel {
    private List<String> numbers;

    public GeneralNumbersModel() {

    }

    public GeneralNumbersModel(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getNumbers() {
        return numbers;
    }

}
