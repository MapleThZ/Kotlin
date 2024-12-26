package com.kotlin.library.configs

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.FilterConfig
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RequestFilter : Filter {

    val listBypass = arrayListOf("/swagger","/v3/api-docs","/swagger-ui","/api-docs")

    @Throws(ServletException::class, IOException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        println("Request URL: ${httpRequest.requestURI}")
        println("Request Method: ${httpRequest.method}")

        val requestUri = httpRequest.requestURI
        val authorizationHeader = httpRequest.getHeader("Authorization")

        println("authorizationHeader : $authorizationHeader")

        // Bypass authorization for Swagger API URIs or public endpoints
        val result = listBypass.any { bypass -> requestUri.startsWith(bypass, ignoreCase = true) }
        println("Bypass : $result")
        if(result){
            chain.doFilter(request, response)
        } else {
            if (authorizationHeader.isNullOrEmpty()) {
                // Return a 400 Bad Request if the Authorization header is missing
                httpResponse.status = HttpServletResponse.SC_BAD_REQUEST
                httpResponse.writer.write("Missing Authorization header")
                return
            }
        }
    }

    override fun init(filterConfig: FilterConfig?) {}
    override fun destroy() {}
}