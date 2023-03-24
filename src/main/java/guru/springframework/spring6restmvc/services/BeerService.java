package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
public interface BeerService {

    Beer getBeerById(UUID id);
}
