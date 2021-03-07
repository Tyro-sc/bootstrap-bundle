package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.html5.list.Ol
import sc.tyro.core.component.Item
import sc.tyro.core.support.property.SelectedItemSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('ol.breadcrumb')
class Breadcrumb extends Ol implements SelectedItemSupport {
    @Override
    Item selectedItem() {
        return items().find { Boolean.valueOf(provider.eval(it.id(), "it.hasClass('active')")) }
    }
}
