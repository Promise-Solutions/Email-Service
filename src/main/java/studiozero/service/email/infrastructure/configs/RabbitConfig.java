package studiozero.service.email.infrastructure.configs;

import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class RabbitConfig {

    // ===== Normalmente o Consumer tenta desserializar o DTO pelo seu nome      ===== //
    // ===== Ignora o nome do DTO recebido pela fila e verifica apenas os campos ===== //
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();

        typeMapper.setTrustedPackages("*");
        typeMapper.setIdClassMapping(Collections.EMPTY_MAP);

        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}
