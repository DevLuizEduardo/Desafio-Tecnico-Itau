package com.example.desafio_itau.DTO;

import com.example.desafio_itau.Model.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public Transacao map (TransacaoDTO transacaoDTO){
        Transacao transacao = new Transacao();
        transacao.setValor(transacaoDTO.getValor());
        transacao.setDataHora(transacaoDTO.getDataHora());

        return  transacao;

    }

    public TransacaoDTO map (Transacao transacao){
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        transacaoDTO.setValor(transacao.getValor());
        transacaoDTO.setDataHora(transacao.getDataHora());

        return transacaoDTO;
    }
}
