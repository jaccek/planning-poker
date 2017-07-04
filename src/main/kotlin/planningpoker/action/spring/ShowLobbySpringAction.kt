package planningpoker.action.spring

import org.springframework.ui.Model

class ShowLobbySpringAction: SpringAction {

    override fun withModel(model: Model): SpringAction =
            this

    override fun perform(): String =
            "lobby"
}
