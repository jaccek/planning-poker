package planningpoker

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import planningpoker.action.spring.JoinRoomSpringAction
import planningpoker.action.spring.ShowLobbySpringAction
import planningpoker.model.form.JoinRoomForm
import planningpoker.model.hibernate.Member
import planningpoker.model.hibernate.Room
import planningpoker.service.MemberService
import planningpoker.service.RoomService
import javax.validation.Valid

@Controller
class LobbyWebController {

    @Autowired
    private lateinit var roomService: RoomService

    @Autowired
    private lateinit var memberService: MemberService

    @PostMapping("/joinRoom")
    fun joinRoom(
            @Valid joinRoomForm: JoinRoomForm,
            bindingResult: BindingResult,
            model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return ShowLobbySpringAction().perform()
        }

        // create room if not exists
        val room = Room(name = joinRoomForm.roomName!!)
        roomService.createRoomIfNotExists(room)

        // get room by name (we need it because we need room id)
        val roomDb = roomService.findRoomByName(room.name) ?: throw NullPointerException("roomDb is null")
        val member = Member(
                name = joinRoomForm.username!!,
                room = roomDb
        )
        val memberDb = memberService.createMember(member, roomDb)

        return JoinRoomSpringAction(room.name)
                .withModel(model)
                .perform()
    }

    @GetMapping("/")
    fun showLobby(joinRoomForm: JoinRoomForm): String {
        return ShowLobbySpringAction().perform()
    }
}
