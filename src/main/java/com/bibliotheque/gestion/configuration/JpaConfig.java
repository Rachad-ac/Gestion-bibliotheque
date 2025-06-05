package com.bibliotheque.gestion.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.bibliotheque.gestion.repository")
public class JpaConfig {
}
