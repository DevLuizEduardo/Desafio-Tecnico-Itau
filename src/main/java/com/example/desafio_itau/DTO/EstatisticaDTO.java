package com.example.desafio_itau.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class EstatisticaDTO {
    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticaDTO(Long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }
}
