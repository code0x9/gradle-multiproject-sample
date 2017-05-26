package com.mark.sub1

import com.mark.sub2.CustomAnnotation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by mark on 2017-05-26.
 */
@SpringBootApplication
@ComponentScan("com.mark")
@RestController
open class Sub1Application {
    @Autowired
    lateinit var beanFactory: ConfigurableListableBeanFactory

    @GetMapping("/")
    fun index(): Map<String, Any> {
        val annotatedBeans = beanFactory.getBeanNamesForAnnotation(CustomAnnotation::class.java).toList()
        return mapOf<String, Any>(
                "beans with @CustomAnnotation" to annotatedBeans
        )
    }
}

@Component
@CustomAnnotation
class TestBean

@Component
@CustomAnnotation
class TestBean2

@Component
@CustomAnnotation
class TestBean3

fun main(args: Array<String>) {
    SpringApplication.run(Sub1Application::class.java, *args)
}