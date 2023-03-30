package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
public interface BeerService {

    List<Beer> beerList();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteByBeerId(UUID beerId);

    void patchByBeerId(UUID beerId, Beer beer);
}
