package planningpoker

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import sun.security.x509.OIDMap.addAttribute



data class TestModel(
        var roomName: String? = null
)

@Controller
class LobbyWebController {

    @PostMapping("/joinRoom")
    fun joinRoom(
            @ModelAttribute("testModel") testModel: TestModel
    ): String {
        return "lobby"
    }

    @GetMapping("/")
    fun showLobby(model: Model): String {
        model.addAttribute("testModel", TestModel())
        return "index"
    }

//    @RequestMapping(
//            path = arrayOf("/"),
//            method = arrayOf(RequestMethod.GET))
//    fun showLobby(model: Model): String {
//        model.addAttribute("name", "test")
//        return "lobby"
//    }
}
