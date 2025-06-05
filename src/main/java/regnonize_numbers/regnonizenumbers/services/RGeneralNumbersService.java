package regnonize_numbers.regnonizenumbers.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;
import regnonize_numbers.regnonizenumbers.helper.ResponseNumbers;
import regnonize_numbers.regnonizenumbers.models.GeneralNumbersModel;
import java.util.Arrays;
import java.util.stream.Collectors;
import regnonize_numbers.regnonizenumbers.services.NumbersService;
import java.util.ArrayList;

@Service
public class RGeneralNumbersService {
    private final NumbersService numbersService;

    public RGeneralNumbersService(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    public Mono<ResponseNumbers> getRAllNumbers(List<String> incomingStringNumbers) {

        List<Integer> validNumbers = incomingStringNumbers.stream()
                .filter(s -> s != null && s.matches("-?\\d+"))
                .map(Integer::parseInt)
                .toList();

        List<Mono<List<Integer>>> naturalNumbersMonos = validNumbers.stream()
                .map(number -> Mono.fromCallable(() -> new NumbersService().isNatural(number)))
                // .map(numbersService::isNatural)
                .toList();

        List<Mono<List<Integer>>> wholeNumbersMonos = validNumbers.stream()
                .map(number -> Mono.fromCallable(() -> new NumbersService().ifWholeNumber(number)))
                .toList();

        List<Mono<List<Integer>>> realNumbersMonos = validNumbers.stream()
                .map(number -> Mono.fromCallable(() -> new NumbersService().ifReal(number)))
                .toList();
        return Mono.zip(
                Mono.zip(naturalNumbersMonos, this::mergeLists),
                Mono.zip(wholeNumbersMonos, this::mergeLists),
                Mono.zip(realNumbersMonos, this::mergeLists))
                .map(tuple -> {
                    ResponseNumbers responseNumbers = new ResponseNumbers();
                    responseNumbers.setNaturalNumbers(tuple.getT1());
                    responseNumbers.setWholeNumbers(tuple.getT2());
                    responseNumbers.setRealNumbers(tuple.getT3());
                    return responseNumbers;
                });
    }

    @SafeVarargs
    private List<Integer> mergeLists(Object... results) {
        return Arrays.stream(results).flatMap(o -> ((List<Integer>) o).stream())
                .collect(Collectors.toList());
    }

}
