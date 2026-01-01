package regnonize_numbers.regnonizenumbers.dto.InfoNumber;

public class PropertiesDTO {
    private Boolean isNatural;
    private Boolean isFibonacci;
    private Boolean isPrime;
    private Boolean isEven;

    public PropertiesDTO() {
    }

    public Boolean isNatural() {
        return isNatural;
    }

    public void setNatural(Boolean isNatural) {
        this.isNatural = isNatural;
    }

    public Boolean isFibonacci() {
        return isFibonacci;
    }

    public void setFibonacci(Boolean isFibonacci) {
        this.isFibonacci = isFibonacci;
    }

    public Boolean isPrime() {
        return isPrime;
    }

    public void setPrime(Boolean isPrime) {
        this.isPrime = isPrime;
    }
    public Boolean isEven() {
        return isEven;
    }

    public void setEven(Boolean isEven) {
        this.isEven = isEven;
    }
}
