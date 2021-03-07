package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.bootstrap.support.property.TypeSupport
import sc.tyro.bundle.html5.Div
import sc.tyro.core.support.property.TextSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('div.alert')
class Alert extends Div implements TextSupport, TypeSupport {
    @Override
    String text() {
        provider.eval(id(), 'it.text().trim()')
    }

    Type type() {
        Type.valueOf(provider.eval(id(), "it.attr('class').split(' ').find(val => /alert-[\\w]+/.test(val)).replace('alert-', '').toUpperCase()"))
    }
}