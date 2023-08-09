package shelter.disaster.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shelter.disaster.domain.Shelter;
import shelter.disaster.service.ShelterService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService shelterService;

    @GetMapping("/api/v1/shelters")
    public List<Shelter> sheltersV1() {

        return shelterService.findAll();
    }

    @GetMapping("/api/v2/shelters")
    public Result sheltersV2() {
        List<Shelter> findShelters = shelterService.findAll();
        List<ShelterDto> collect = findShelters.stream().map(s -> new ShelterDto(s.getLatitude(), s.getLongitude()))
                .collect(Collectors.toList());
        return new Result(collect);
    }



    @Data
    @AllArgsConstructor
    static class ShelterDto {
        private BigDecimal latitude;
        private BigDecimal longitude;

    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}

