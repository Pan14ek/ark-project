package ua.nure.makieiev.ark.configuration

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse

class CORSFilter : Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpResponse: HttpServletResponse = response as HttpServletResponse
        httpResponse.setHeader("Access-Control-Allow-Origin", "*")
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true")
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE")
        httpResponse.setHeader("Access-Control-Max-Age", "3600")
        httpResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
        chain?.doFilter(request, response)
    }

}