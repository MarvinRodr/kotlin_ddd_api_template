package com.marvinrodr.config

import com.marvinrodr.common.domain.Publisher
import com.marvinrodr.common.infrastructure.InMemoryPublisher
import com.marvinrodr.password.application.create.PasswordCreator
import com.marvinrodr.password.application.find.PasswordFinder
import com.marvinrodr.password.domain.PasswordRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DependencyInjectionConf {

    @Bean
    fun publisher() = InMemoryPublisher()

    @Bean
    fun passwordCreator(passwordRepository: PasswordRepository, publisher: Publisher) = PasswordCreator(passwordRepository, publisher)

    @Bean
    fun passwordFinder(passwordRepository: PasswordRepository) = PasswordFinder(passwordRepository)
}