package com.example.desafio_itau.Service;

import com.example.desafio_itau.Config.EstastisticaProperties;
import com.example.desafio_itau.DTO.EstatisticaDTO;
import com.example.desafio_itau.DTO.TransacaoDTO;
import com.example.desafio_itau.DTO.TransacaoMapper;
import com.example.desafio_itau.Model.Transacao;
import com.example.desafio_itau.Repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

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
             throw new IllegalArgumentException("Erro: transacao nao e valida, transacao tem que ser um valor maior que zero");

        }

        if(transacaoDTO.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: na data de transacao");
        }
        if(transacaoDTO.getValor()==null ){
            throw new IllegalArgumentException("Erro: Valor da transação é obrigatório");
        }

        if(transacaoDTO.getDataHora()==null){
            throw new IllegalArgumentException("Erro: Data da transação é obrigatório");
        }

    }

    public void addTransacao(TransacaoDTO transacaoDTO){
        validarTransacao(transacaoDTO);
        Transacao transacao = transacaoMapper.map(transacaoDTO);
        transacaoRepository.save(transacao);

    }

    public void deletarTransacoes(){

        transacaoRepository.apagarDados();
    }

    public EstatisticaDTO estatisticasTransacao(){

        final var horaInicial = OffsetDateTime
                .now().
                minusSeconds(estastisticaProperties.seconds());

        List<Transacao>lista = transacaoRepository.findByDataHoraAfter(horaInicial);

         if (lista.isEmpty()){
             EstatisticaDTO estatisticaDTO = new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
             return estatisticaDTO;
        }
             var sumary = lista.stream()
                     .map(Transacao::getValor)
                     .mapToDouble(BigDecimal::doubleValue)
                     .summaryStatistics();

             EstatisticaDTO estatisticaDTO = new EstatisticaDTO(sumary.getCount(),
                     sumary.getSum(),
                     sumary.getAverage(),
                     sumary.getMin(),
                     sumary.getMax());
             return estatisticaDTO;


    }


}
