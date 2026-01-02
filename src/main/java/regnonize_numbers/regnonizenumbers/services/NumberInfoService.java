package regnonize_numbers.regnonizenumbers.services;

import javax.sound.midi.Sequence;

import org.springframework.stereotype.Service;

import regnonize_numbers.regnonizenumbers.dto.InfoNumber.InfoNumberResponse;
import regnonize_numbers.regnonizenumbers.dto.InfoNumber.PropertiesDTO;
import regnonize_numbers.regnonizenumbers.dto.InfoNumber.SequenceDataDTO;
@Service
public class NumberInfoService {
    private final NumbersService numbersService;

    public NumberInfoService(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    public InfoNumberResponse getNumberInfo(Integer number) {
        InfoNumberResponse response = new InfoNumberResponse();
        PropertiesDTO properties = new PropertiesDTO();
        SequenceDataDTO sequenceData = new SequenceDataDTO();
        properties.setNatural(this.numbersService.isNaturalB(number));
        properties.setPrime(this.numbersService.isPrime(number));
        properties.setEven(this.numbersService.isEven(number));
        properties.setFibonacci(this.numbersService.isFibonacci(number));
        
        sequenceData.setBinary(this.numbersService.convertDecimalToBinary(number));

        response.setProperties(properties);
        response.setSequence_data(sequenceData);
        return response;
    }
}
