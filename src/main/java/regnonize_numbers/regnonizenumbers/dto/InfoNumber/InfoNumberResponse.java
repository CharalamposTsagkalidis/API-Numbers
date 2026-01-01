package regnonize_numbers.regnonizenumbers.dto.InfoNumber;


public class InfoNumberResponse {
    
    private PropertiesDTO properties;
    private String fun_fact;
    private SequenceDataDTO sequence_data;

    public InfoNumberResponse() {
    }

    public PropertiesDTO getProperties() {
        return properties;
    }

    public void setProperties(PropertiesDTO properties) {
        this.properties = properties;
    }

    public String getFun_fact() {
        return fun_fact;
    }

    public void setFun_fact(String fun_fact) {
        this.fun_fact = fun_fact;
    }

    public SequenceDataDTO getSequence_data() {
        return sequence_data;
    }

    public void setSequence_data(SequenceDataDTO sequence_data) {
        this.sequence_data = sequence_data;
    }
}
