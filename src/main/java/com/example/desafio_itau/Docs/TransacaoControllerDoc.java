package com.example.desafio_itau.Docs;

import com.example.desafio_itau.DTO.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transações",
        description = "Endpoints responsaveis por adicionar transações e  apagar lista de transações"
)
public interface TransacaoControllerDoc {

    @Operation(summary = "Criar Transações",
            description = "Recebe uma transação valida e adiciona em uma lista"
    )

    @ApiResponse(responseCode = "201",
            description = "Transação criada com sucesso"
    )

    @ApiResponse(responseCode = "422",
            description = "Erro de validação capturado"
    )

    @ApiResponse(responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoDTO transacaoDTO);

    @Operation(summary = "Deleta todas as Transações",
            description = "Remove todas as transações adicionadas na lista"
    )

    @ApiResponse(responseCode = "200",
            description = "Todas as transações foram deletadas"
    )

    public ResponseEntity<Void> deletarTransacoes();
}
