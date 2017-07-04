package planningpoker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
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
            return "lobby"
        }

        model.addAttribute("name", joinRoomForm.roomName)
        return "redirect:/room/${joinRoomForm.roomName}"
    }

    @GetMapping("/")
    fun showLobby(joinRoomForm: JoinRoomForm): String {
        return "lobby"
    }
}
