package edu.br.catolica.ppi.execption.handler;

import edu.br.catolica.ppi.execption.DataNotFoundException;
import edu.br.catolica.ppi.execption.ErroFieldException;
import edu.br.catolica.ppi.execption.InvalidMessageException;
import edu.br.catolica.ppi.execption.dto.ErroResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(InvalidMessageException.class)
    public ResponseEntity<Object> invalidMessageException(InvalidMessageException ex){
        final var httpStatus = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(httpStatus)
                .body(builderErroResponseDTO(httpStatus, ex));
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> dataNotFoundException(DataNotFoundException ex){
        final var httpStatus = HttpStatus.NOT_FOUND;
         return ResponseEntity.status(httpStatus)
                 .body(builderErroResponseDTO(httpStatus, ex));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> dataNotFoundException(MethodArgumentNotValidException ex){
        final var httpStatus = HttpStatus.NOT_ACCEPTABLE;
        var messages = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach( error ->{
            var fieldErro = ((FieldError) error).getField();
            var valueErro = error.getDefaultMessage();
            messages.put(fieldErro, valueErro);
        });

        return ResponseEntity.status(httpStatus)
                .body(ErroResponseDTO.builder()
                        .message(Arrays.toString(messages.entrySet().toArray()))
                        .dateTime(LocalDateTime.now())
                        .httpStatus(httpStatus)
                        .statusCode(httpStatus.value())
                        .build());
    }

    private ErroResponseDTO builderErroResponseDTO(HttpStatus status, RuntimeException ex){
        return ErroResponseDTO.builder()
                .message(ex.getMessage())
                .dateTime(LocalDateTime.now())
                .statusCode(status.value())
                .httpStatus(status)
                .build();
    }
}
