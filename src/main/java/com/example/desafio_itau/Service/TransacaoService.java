package com.example.desafio_itau.Service;

import com.example.desafio_itau.Config.EstastisticaProperties;
import com.example.desafio_itau.DTO.EstatisticaDTO;
import com.example.desafio_itau.DTO.TransacaoDTO;
import com.example.desafio_itau.DTO.TransacaoMapper;
import com.example.desafio_itau.Model.Transacao;
import com.example.desafio_itau.Repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
@Slf4j
@Service
public class TransacaoService {

   private final TransacaoRepository transacaoRepository;
   private final TransacaoMapper transacaoMapper;
   private final EstastisticaProperties estastisticaProperties;

    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper, EstastisticaProperties estastisticaProperties) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
        this.estastisticaProperties = estastisticaProperties;
    }

    private  void validarTransacao(TransacaoDTO transacaoDTO){


        if(transacaoDTO.getValor().compareTo(BigDecimal.ZERO)<0){

             throw new IllegalArgumentException("Valor nao pode ser negativo");
        }

        if(transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())) {

            throw new IllegalArgumentException("Data de Transacao invalida");
        }

        if(transacaoDTO.getValor()==null ){
            throw new IllegalArgumentException("Valor da transação esta null");
        }

        if(transacaoDTO.getDataHora()==null){
            throw new IllegalArgumentException("Data da transação esta null");
        }

    }

    public void addTransacao(TransacaoDTO transacaoDTO){
        validarTransacao(transacaoDTO);
        Transacao transacao = transacaoMapper.map(transacaoDTO);
        transacaoRepository.save(transacao);
        log.info("Transacao Salva com sucesso!!!");

    }

    public void deletarTransacoes(){

        transacaoRepository.apagarDados();
    }

    public EstatisticaDTO estatisticasTransacao(){

    log.info("Listando as Transacoes dos ultimos {} segundos",estastisticaProperties.seconds());
        final var horaInicial = OffsetDateTime
                .now().
                minusSeconds(estastisticaProperties.seconds());

        List<Transacao>lista = transacaoRepository.findByDataHoraAfter(horaInicial);

         if (lista.isEmpty()){
             EstatisticaDTO estatisticaDTO = new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
             log.warn("Nenhuma transação encontrada para o período");
             return estatisticaDTO;

        }
             var summary = lista.stream()
                     .mapToDouble(t->t.getValor().doubleValue())
                     .summaryStatistics();

             EstatisticaDTO estatisticaDTO = new EstatisticaDTO(summary.getCount(),
                     summary.getSum(),
                     summary.getAverage(),
                     summary.getMin(),
                     summary.getMax());

            log.info("Estatisca gerada com sucesso");
             return estatisticaDTO;




    }


}
