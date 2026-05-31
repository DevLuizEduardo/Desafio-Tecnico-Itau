package com.example.desafio_itau.Repository;

import com.example.desafio_itau.Model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    private List<Transacao> listaTransacoes = new ArrayList<>();

    public void save(Transacao transacao){
        listaTransacoes.add(transacao);

    }

    public List<Transacao> findByDataHoraAfter(OffsetDateTime dataHora){


        return this.listaTransacoes.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(dataHora)|| transacao.getDataHora().equals(dataHora))
                .collect(Collectors.toList());
    }



    public void apagarDados(){
        listaTransacoes.clear();
    }
}
