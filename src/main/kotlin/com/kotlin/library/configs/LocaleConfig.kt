package com.kotlin.library.configs

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.FixedLocaleResolver
import java.util.Locale

@Configuration
class LocaleConfig {
    @Bean
    fun messageSource(): MessageSource {
        val messageSource = ResourceBundleMessageSource()
        messageSource.setBasename("messages/message") // This will look for messages.properties in src/main/resources
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }
}