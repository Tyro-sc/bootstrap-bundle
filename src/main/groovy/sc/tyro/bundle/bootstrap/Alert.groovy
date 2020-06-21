package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.html5.Div
import sc.tyro.web.CssIdentifier

@CssIdentifier('div.alert')
class Alert extends Div {
    String text() {
        provider.eval(id(), 'it.text().trim()')
    }
}
