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
    @Throws(ServletException::class, IOException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        println("Request URL: ${httpRequest.requestURI}")
        println("Request Method: ${httpRequest.method}")

        val requestUri = httpRequest.requestURI
        val authorizationHeader = httpRequest.getHeader("Authorization")

        println("requestUri : $authorizationHeader")

        // Bypass authorization for Swagger API URIs or public endpoints
        if (!(requestUri.startsWith("/swagger") || requestUri.startsWith("/v3/api-docs")
            || requestUri.startsWith("/swagger-ui") || requestUri.startsWith("/api-docs"))) {
            if (authorizationHeader.isNullOrEmpty()) {
                // Return a 400 Bad Request if the Authorization header is missing
                httpResponse.status = HttpServletResponse.SC_BAD_REQUEST
                httpResponse.writer.write("Missing Authorization header")
                return
            }
        }

        // Continue the request-response chain
        chain.doFilter(request, response)
    }

    override fun init(filterConfig: FilterConfig?) {}
    override fun destroy() {}
}