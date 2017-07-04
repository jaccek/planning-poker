package planningpoker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import planningpoker.action.spring.JoinRoomSpringAction
import planningpoker.action.spring.ShowLobbySpringAction
import planningpoker.model.JoinRoomForm
import javax.validation.Valid

@Controller
class LobbyWebController {

    @PostMapping("/joinRoom")
    fun joinRoom(
            @Valid joinRoomForm: JoinRoomForm,
            bindingResult: BindingResult,
            model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return ShowLobbySpringAction().perform()
        }

        return JoinRoomSpringAction(joinRoomForm.roomName!!)
                .withModel(model)
                .perform()
    }

    @GetMapping("/")
    fun showLobby(joinRoomForm: JoinRoomForm): String {
        return ShowLobbySpringAction().perform()
    }
}
