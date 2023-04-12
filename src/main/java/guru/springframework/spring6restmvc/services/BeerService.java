package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
public interface BeerService {

    List<BeerDTO> beerList();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeerById(UUID beerId, BeerDTO beerDTO);

    void deleteByBeerId(UUID beerId);

    void patchByBeerId(UUID beerId, BeerDTO beerDTO);
}
