package com.example.desafio_itau.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "estatistica")
public record EstastisticaProperties(Integer seconds) {
}
