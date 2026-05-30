package com.example.desafio_itau.Service;

import com.example.desafio_itau.DTO.TransacaoDTO;
import com.example.desafio_itau.DTO.TransacaoMapper;
import com.example.desafio_itau.Model.Transacao;
import com.example.desafio_itau.Repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

   private final TransacaoRepository transacaoRepository;
   private final TransacaoMapper transacaoMapper;

    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
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


}
