package planningpoker

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import planningpoker.action.spring.JoinRoomSpringAction
import planningpoker.action.spring.ShowLobbySpringAction
import planningpoker.model.form.JoinRoomForm
import planningpoker.model.hibernate.Room
import planningpoker.service.RoomService
import javax.validation.Valid

@Controller
class LobbyWebController {

    @Autowired
    private lateinit var roomService: RoomService

    @PostMapping("/joinRoom")
    fun joinRoom(
            @Valid joinRoomForm: JoinRoomForm,
            bindingResult: BindingResult,
            model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return ShowLobbySpringAction().perform()
        }

        val room = Room(name = joinRoomForm.roomName!!)
        roomService.createRoomIfNotExists(room)

        return JoinRoomSpringAction(room.name)
                .withModel(model)
                .perform()
    }

    @GetMapping("/")
    fun showLobby(joinRoomForm: JoinRoomForm): String {
        return ShowLobbySpringAction().perform()
    }
}
