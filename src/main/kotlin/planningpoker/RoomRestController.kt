package planningpoker

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import planningpoker.entity.RoomState

@RestController
class RoomRestController {

    @RequestMapping(
            method = arrayOf(RequestMethod.GET),
            path = arrayOf("/state"))
    fun getState(): RoomState {
        return RoomState(arrayOf("abc"))
    }
}
