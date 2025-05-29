package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
@Service
public class GeneralNumbersService {
   
    public ResponseEntity<List<?>> getAllNumbers(List<String> incomingStringNumbers) {
        for(String stringNumber : incomingStringNumbers) {

        }

        return null;
    }
}
