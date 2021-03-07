package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.html5.Div
import sc.tyro.core.support.property.LabelSupport
import sc.tyro.core.support.property.MaximumSupport
import sc.tyro.core.support.property.ValueSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('div.progress')
class Progress extends Div implements MaximumSupport, ValueSupport, LabelSupport {
    @Override
    Object maximum() {
        provider.eval(id(), "it.find('.progress-bar').attr('aria-valuemax')") as BigDecimal
    }

    @Override
    Object value() {
        provider.eval(id(), "it.find('.progress-bar').attr('aria-valuenow')") as BigDecimal
    }

    @Override
    String label() {
        provider.eval(id(), "it.find('.progress-bar').text().trim()")
    }
}
