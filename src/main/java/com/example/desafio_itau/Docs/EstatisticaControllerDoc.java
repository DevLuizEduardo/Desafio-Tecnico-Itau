package com.example.desafio_itau.Docs;

import com.example.desafio_itau.DTO.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatísticas",
        description = "Endpoint responsavel por mostrar a estatística das transações"
)
public interface EstatisticaControllerDoc {
    @Operation(summary = "Gerar Estatística de Transações",
            description = "Mostra a quantidade de transações(cont)," +
                    "o valor total das transações(sum)," +
                    "a média do valor de transação(avg)," +
                    "o menor valor de transação(min)," +
                    "o maior valor de transação(max)"

    )

    @ApiResponse(responseCode = "200",
            description = "Estatística gerada com sucesso"
    )

    public ResponseEntity<EstatisticaDTO> mostrarEstatistica();


}
