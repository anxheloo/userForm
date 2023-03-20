<<<<<<< HEAD
//package io.bootify.spring_boot_arlindiii.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class JacksonConfig {
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
//        return jacksonObjectMapperBuilder -> {
//                jacksonObjectMapperBuilder.featuresToDisable(
//                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
//                        DeserializationFeature.ACCEPT_FLOAT_AS_INT,
//                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//                };
//    }
//
//}
=======
package io.bootify.spring_boot_arlindiii.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return jacksonObjectMapperBuilder -> {
                jacksonObjectMapperBuilder.featuresToDisable(
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                        DeserializationFeature.ACCEPT_FLOAT_AS_INT,
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                };
    }

}
>>>>>>> fb96a41cbe1c5dda5939dfa6b1aa1f5cb1c7fbe9
