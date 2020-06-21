package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.html5.A
import sc.tyro.bundle.html5.Nav
import sc.tyro.core.By
import sc.tyro.web.CssIdentifier

@CssIdentifier('nav.navbar')
class NavBar extends Nav {
    A brand() {
        provider.find(By.expression('#' + id() + ' a.navbar-brand'), A)
    }
}
