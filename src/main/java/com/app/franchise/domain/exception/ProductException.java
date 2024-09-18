package com.app.franchise.domain.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
public class ProductException extends RuntimeException{

        private String message;
        private HttpStatus code;

        public ProductException(String message, HttpStatus code) {
            super(message);
            this.message = message;
            this.code = code;
        }
}
