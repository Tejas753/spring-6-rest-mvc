package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> beerList(){
        return beerService.beerList();
    }

    public Beer getBeerById(UUID id){
        log.debug("Get Beer by id - in controller");

        return beerService.getBeerById(id);
    }
}
