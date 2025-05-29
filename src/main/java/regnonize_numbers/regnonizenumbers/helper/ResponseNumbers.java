package regnonize_numbers.regnonizenumbers.helper;
import java.util.List;
public class ResponseNumbers {
    List<Integer> naturalNumbers;
    List<Integer> wholeNumbers;
    List<Integer> realNumbers;

    public ResponseNumbers() {}

    //get set
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

    
}
