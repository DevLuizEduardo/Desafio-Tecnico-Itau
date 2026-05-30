package com.example.desafio_itau.Controller;

import com.example.desafio_itau.Config.EstastisticaProperties;
import com.example.desafio_itau.DTO.EstatisticaDTO;
import com.example.desafio_itau.Service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {
    private final TransacaoService transacaoService;
    private final EstastisticaProperties estastisticaProperties;

    public EstatisticaController(TransacaoService transacaoService, EstastisticaProperties estastisticaProperties) {
        this.transacaoService = transacaoService;
        this.estastisticaProperties = estastisticaProperties;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> mostrarEstatistica(){

        final var horaInicial = OffsetDateTime
                .now().
                minusSeconds(estastisticaProperties.seconds());

       EstatisticaDTO estatisticaDTO= transacaoService.estatisticasTransacao();

       return ResponseEntity.status(HttpStatus.OK)
               .body(estatisticaDTO);

    }
}
