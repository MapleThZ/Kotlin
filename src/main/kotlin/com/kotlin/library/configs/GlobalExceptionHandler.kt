//package com.kotlin.library.configs
//
//import com.kotlin.library.models.ErrorException
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.MessageSource
//import org.springframework.context.i18n.LocaleContextHolder
//import org.springframework.http.HttpStatus
//import org.springframework.ui.Model
//import org.springframework.web.bind.annotation.ControllerAdvice
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.bind.annotation.ResponseStatus
//import java.util.Locale
//
//@ControllerAdvice
//class GlobalExceptionHandler {
//
//    @Autowired
//    lateinit var messageSource: MessageSource
//
//    @ExceptionHandler(Exception::class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    fun handleException(exception: Exception, model: Model): ErrorException {
//        model.addAttribute("error", exception.message)
//        var message = messageSource.getMessage("greeting", null, Locale("en","EN"))
//        var error : ErrorException = ErrorException("E0001",message)
//        return error
//    }
//}
