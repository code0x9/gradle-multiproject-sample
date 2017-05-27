package com.mark.sub1

import com.mark.sub2.CustomAnnotation
import org.axonframework.eventsourcing.AggregateFactory
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.axonframework.spring.stereotype.Aggregate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
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
        val annotatedAggregates = beanFactory.getBeanNamesForAnnotation(Aggregate::class.java).toList()
        val allAggregateFactories = beanFactory.getBeansOfType(AggregateFactory::class.java)
        println("-----")

        return mapOf<String, Any>(
                "a" to 1,
                "b" to 2,
                "c" to 3,
                "d" to 400,
                "beans with @CustomAnnotation" to annotatedBeans,
                "beans with @Aggregate" to annotatedAggregates,
                "all AggregateFactories" to allAggregateFactories
        )
    }
}

@Configuration
open class AppConfiguration {
    @Bean
    open fun eventStore() =
            EmbeddedEventStore(InMemoryEventStorageEngine())
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

@Aggregate
class TestAggregate1

@Component
class TestTargetClass {
    fun add(a: Int, b: Int) = a + b
}

fun main(args: Array<String>) {
    SpringApplication.run(Sub1Application::class.java, *args)
}
