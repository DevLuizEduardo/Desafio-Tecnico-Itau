package com.example.desafio_itau.Config;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstastisticaProperties(
        @NotNull
        @Positive
        Integer seconds

) {
}
