package regnonize_numbers.regnonizenumbers.models;

import java.util.List;

public class GeneralNumbersModel {
    private List<Long> naturalNumbers;
    private List<Long> wholeNumbers;
    private List<Long> integers;
    private List<Double> rationalNumbers;
    private List<Double> irrationalNumbers;
    private List<Double> realNumbers;
    private List<String> complexNumbers;

    public GeneralNumbersModel() {

    }

    public List<Long> getNaturalNumbers() {
        return naturalNumbers;
    }

    public void setNaturalNumbers(List<Long> naturalNumbers) {
        this.naturalNumbers = naturalNumbers;
    }

    public List<Long> getWholeNumbers() {
        return wholeNumbers;
    }

    public void setWholeNumbers(List<Long> wholeNumbers) {
        this.wholeNumbers = wholeNumbers;
    }

    public List<Long> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Long> integers) {
        this.integers = integers;
    }

    public List<Double> getRationalNumbers() {
        return rationalNumbers;
    }

    public void setRationalNumbers(List<Double> rationalNumbers) {
        this.rationalNumbers = rationalNumbers;
    }

    public List<Double> getIrrationalNumbers() {
        return irrationalNumbers;
    }

    public void setIrrationalNumbers(List<Double> irrationalNumbers) {
        this.irrationalNumbers = irrationalNumbers;
    }

    public List<Double> getRealNumbers() {
        return realNumbers;
    }

    public void setRealNumbers(List<Double> realNumbers) {
        this.realNumbers = realNumbers;
    }

    public List<String> getComplexNumbers() {
        return complexNumbers;
    }

    public void setComplexNumbers(List<String> complexNumbers) {
        this.complexNumbers = complexNumbers;
    }

}
