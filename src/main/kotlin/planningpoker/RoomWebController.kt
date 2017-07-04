package planningpoker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import planningpoker.entity.RoomState
import planningpoker.entity.User
import planningpoker.entity.UserVote
import planningpoker.entity.Vote

@Controller
class RoomWebController {

    @GetMapping("/room/{roomName}")
    fun showRoomStatus(
            @PathVariable("roomName") roomName: String,
            model: Model
    ): String {
        val roomState = RoomState(
                roomName = roomName,
                users = listOf(
                        UserVote(
                                user = User(username = "tester"),
                                vote = Vote.VOTE_INFINITY
                        ),
                        UserVote(
                                user = User(username = "member"),
                                vote = Vote.NOT_VOTED
                        )
                )
        )
        model.addAttribute("roomState", roomState)
        return "room"
    }
}
