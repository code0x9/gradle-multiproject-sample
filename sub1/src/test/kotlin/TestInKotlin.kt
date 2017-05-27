import com.mark.sub1.TestTargetClass
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

/**
 * Created by mark on 2017-05-27.
 */
class KotlinTest {
    @Test
    fun test1() {
        val target = TestTargetClass()
        assertEquals(target.add(1, 2), 3)
        assertEquals(target.add(2, 2), 4)
    }
}