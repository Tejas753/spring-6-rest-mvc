package guru.springframework.spring6restmvc.controller;

import org.springframework.http.ResponseEntity;

/**
 * @author : tejas
 * @created : 4/11/23, Tuesday
 **/
//@ControllerAdvice
public class ExceptionController {

    //@ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(){
        return ResponseEntity.notFound().build();
    }
}
