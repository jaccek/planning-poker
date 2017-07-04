package planningpoker.action.spring

import org.springframework.ui.Model
import planningpoker.action.Action

interface SpringAction: Action {
    fun withModel(model:Model): SpringAction
}
