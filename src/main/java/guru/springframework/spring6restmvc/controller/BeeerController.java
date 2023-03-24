package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * @author : tejas
 * @created : 3/24/23, Friday
 **/
@AllArgsConstructor
@Controller
public class BeeerController {
    private final BeerService beerService;
}
