<<<<<<< HEAD
//package io.bootify.spring_boot_arlindiii.config;
//
//import java.time.OffsetDateTime;
//import java.util.Optional;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.auditing.DateTimeProvider;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//@Configuration
//@EntityScan("io.bootify.spring_boot_arlindiii")
//@EnableJpaRepositories("io.bootify.spring_boot_arlindiii")
//@EnableTransactionManagement
//@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
//public class DomainConfig {
//
//    @Bean(name = "auditingDateTimeProvider")
//    public DateTimeProvider dateTimeProvider() {
//        return () -> Optional.of(OffsetDateTime.now());
//    }
//
//}
=======
package io.bootify.spring_boot_arlindiii.config;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.bootify.spring_boot_arlindiii")
@EnableJpaRepositories("io.bootify.spring_boot_arlindiii")
@EnableTransactionManagement
@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class DomainConfig {

    @Bean(name = "auditingDateTimeProvider")
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }

}
>>>>>>> fb96a41cbe1c5dda5939dfa6b1aa1f5cb1c7fbe9
