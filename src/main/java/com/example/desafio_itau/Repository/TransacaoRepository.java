package com.example.desafio_itau.Repository;

import com.example.desafio_itau.Model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<Transacao> listaTransacoes = new ArrayList<>();

    public void save(Transacao transacao){
        listaTransacoes.add(transacao);

    }

    public void gerarEstatisticas(){

    }

    public void limparTransacoes(){

    }

    public void apagarDados(){
        listaTransacoes.clear();
    }
}
