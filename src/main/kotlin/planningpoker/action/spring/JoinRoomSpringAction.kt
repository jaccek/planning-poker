package planningpoker.action.spring

import org.springframework.ui.Model

class JoinRoomSpringAction(val roomName:String): SpringAction {

    private lateinit var model: Model

    override fun withModel(model: Model): SpringAction =
            apply { this.model = model }

    override fun perform(): String {
        model.addAttribute("name", roomName)
        return "redirect:/room/$roomName"
    }
}
