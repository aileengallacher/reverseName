import kotlinx.css.img
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv
import styled.styledInput
import react.dom.*
import styled.*
import kotlinx.html.js.*

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name)
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +WelcomeStyles.textContainer
            }
            +"Hello, ${state.name}!"
            +"Your name backwards is ${state.name.reversed()}!"
        }
        styledInput {
            css {
                +WelcomeStyles.textInput
            }
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = { event ->
                    setState(
                            WelcomeState(name = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
        div {
            img(src="https://placekitten.com/408/287") {}
        }
        button {
            attrs.onClickFunction = {
                setState(
                    WelcomeState(name="Some name")
                )
            }
            +"Change name"
        }
    }
}
