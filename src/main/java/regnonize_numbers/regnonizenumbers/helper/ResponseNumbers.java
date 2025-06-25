package regnonize_numbers.regnonizenumbers.helper;

import java.util.List;

public class ResponseNumbers {
    private List<Integer> naturalNumbers;
    private List<Integer> wholeNumbers;
    private List<Integer> realNumbers;
    private Integer sizeOfNaturalNumbers;
    private Integer sizeOfWholeNumbers;
    private Integer sizeOfRealNumbers;

    public ResponseNumbers() {
    }

    // get set
    public List<Integer> getNaturalNumbers() {
        return naturalNumbers;
    }

    public void setNaturalNumbers(List<Integer> naturalNumbers) {
        this.naturalNumbers = naturalNumbers;
    }

    public List<Integer> getWholeNumbers() {
        return wholeNumbers;
    }

    public void setWholeNumbers(List<Integer> wholeNumbers) {
        this.wholeNumbers = wholeNumbers;
    }

    public List<Integer> getRealNumbers() {
        return realNumbers;
    }

    public void setRealNumbers(List<Integer> realNumbers) {
        this.realNumbers = realNumbers;
    }

    public Integer getSizeOfNaturalNumbers() {
        return naturalNumbers != null ? naturalNumbers.size() : 0;
    }

    public Integer getSizeOfWholeNumbers() {
        return wholeNumbers != null ? wholeNumbers.size() : 0;
    }

    public Integer getSizeOfRealNumbers() {
        return realNumbers != null ? realNumbers.size() : 0;
    }

    public void setSizeOfNaturalNumbers(Integer sizeOfNaturalNumbers) {
        this.sizeOfNaturalNumbers = sizeOfNaturalNumbers;
    }

    public void setSizeOfWholeNumbers(Integer sizeOfWholeNumbers) {
        this.sizeOfWholeNumbers = sizeOfWholeNumbers;
    }

    public void setSizeOfRealNumbers(Integer sizeOfRealNumbers) {
        this.sizeOfRealNumbers = sizeOfRealNumbers;
    }

    

}
