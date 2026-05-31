package com.example.desafio_itau.Controller;

import com.example.desafio_itau.Config.EstastisticaProperties;
import com.example.desafio_itau.DTO.EstatisticaDTO;
import com.example.desafio_itau.Docs.EstatisticaControllerDoc;
import com.example.desafio_itau.Service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatisticaControllerDoc {
    private final TransacaoService transacaoService;


    public EstatisticaController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> mostrarEstatistica(){
        log.info("Gerando  Estatistica Solicitada");
       EstatisticaDTO estatisticaDTO= transacaoService.estatisticasTransacao();

       return ResponseEntity.status(HttpStatus.OK)
               .body(estatisticaDTO);
       

    }
}
