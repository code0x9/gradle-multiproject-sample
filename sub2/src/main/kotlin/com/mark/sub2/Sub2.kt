package com.mark.sub2

import org.axonframework.spring.stereotype.Aggregate
import org.springframework.stereotype.Component

/**
 * Created by mark on 2017-05-26.
 */

annotation class CustomAnnotation

@Component
@CustomAnnotation
class TestBeanFromSub1

@Aggregate
class TestAggregateFromSub1