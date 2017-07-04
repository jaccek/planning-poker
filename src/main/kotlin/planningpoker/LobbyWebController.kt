package planningpoker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import planningpoker.model.NewRoomForm

@Controller
class LobbyWebController {

    @PostMapping("/joinRoom")
    fun joinRoom(newRoomModel: NewRoomForm, model: Model): String {
        model.addAttribute("name", newRoomModel.roomName)
        return "redirect:/room/${newRoomModel.roomName}"
    }

    @GetMapping("/")
    fun showLobby(model: Model): String {
        model.addAttribute("newRoomModel", NewRoomForm())
        return "lobby"
    }
}
