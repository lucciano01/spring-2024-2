package edu.br.catolica.ppi.execption.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponseDTO {

    private String message;
    private HttpStatus httpStatus;
    private Integer statusCode;
    private LocalDateTime dateTime;
}
