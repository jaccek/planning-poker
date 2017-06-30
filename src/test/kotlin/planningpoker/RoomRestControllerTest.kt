package planningpoker

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.runners.MockitoJUnitRunner
import org.assertj.core.api.Assertions.assertThat

@RunWith(MockitoJUnitRunner::class)
internal class RoomRestControllerTest {

    @InjectMocks
    lateinit var controller: RoomRestController

    @Test
    fun testGetState() {
        val state = controller.getState()

        assertThat(state).isNotNull()
    }

}