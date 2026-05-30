package com.example.desafio_itau.Controller;

import com.example.desafio_itau.DTO.TransacaoDTO;
import com.example.desafio_itau.Service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;

    public TransacoesController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping()
    public ResponseEntity adicionarTransacao(@RequestBody TransacaoDTO transacaoDTO){

        try {
            transacaoService.addTransacao(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        }



    }


    @DeleteMapping
    public ResponseEntity deletarTransacoes(){

         transacaoService.deletarTransacoes();
         return ResponseEntity.status(HttpStatus.OK).build();

    }
}
