package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.bootstrap.support.property.TypeSupport
import sc.tyro.bundle.html5.Span
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('span.badge')
class Badge extends Span implements TypeSupport {
    @Override
    Type type() {
        Type.valueOf(provider.eval(id(), "it.attr('class').split(' ').find(val => /badge-[\\w]+/.test(val)).replace('badge-', '').toUpperCase()"))
    }
}
