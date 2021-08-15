package com.example.spring_thymeleaf.nterceptores_spring

import org.slf4j.LoggerFactory
import org.slf4j.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.math.log
import kotlin.random.Random

@Component("interceptorSpring")
class InterceptoresSpreing : HandlerInterceptor {

    private val logger: Logger? = LoggerFactory.getLogger(InterceptoresSpreing::class.java)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        logger?.info("InterceptoresSpreing entrando al metodo: preHandle\n")
        val tiempo = System.currentTimeMillis()
        request.setAttribute("tiempo", tiempo)

        val demora = Random.nextInt(500)
        Thread.sleep(demora.toLong())

        return true;
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {

        val tiempoFin: Long = System.currentTimeMillis()
        val tiempoInicio: Long = request.getAttribute("tiempo").toString().toLong()
        val tiempoTranscurrido = tiempoFin - tiempoInicio

        modelAndView?.addObject("tiempoTranscurrido", tiempoTranscurrido)

        logger?.info("\nTiempo transcurrido: $tiempoTranscurrido milisegundos")
        logger?.info("\n Tiempo Transcurrido Interruptor posHandle saliendo...\n")


    }
}