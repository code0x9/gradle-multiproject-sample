package com.mark.sub1

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

/**
 * Created by mark on 2017-05-27.
 */
class KotlinTest {
    @Test
    fun unitTest() {
        val target = TestTargetClass()
        assertEquals(target.add(1, 2), 3)
        assertEquals(target.add(1, 2), 3)
        assertEquals(target.add(2, 2), 4)
    }
}

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringIntegrationTest : AbstractTestNGSpringContextTests() {

    @Autowired
    lateinit var target: TestTargetClass

    @Test
    fun integrationTest() {
        assertEquals(target.add(1, 2), 3)
        assertEquals(target.add(2, 2), 4)
    }
}