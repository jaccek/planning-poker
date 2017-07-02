package planningpoker

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import planningpoker.entity.RoomState

@RestController
class RoomRestController {

    @RequestMapping(
            method = arrayOf(RequestMethod.GET),
            path = arrayOf("/room/{roomName}/state"))
    fun getState(
            @PathVariable("roomName") roomName: String
    ): RoomState {
        return RoomState(arrayOf("abc"))
    }
}
