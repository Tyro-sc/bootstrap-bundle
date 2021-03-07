package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.html5.list.Li
import sc.tyro.bundle.html5.list.Ul
import sc.tyro.core.By
import sc.tyro.core.component.Item
import sc.tyro.core.component.ListView
import sc.tyro.core.support.property.SelectedItemSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('ul.pagination')
class Pagination extends Ul implements SelectedItemSupport {
    @Override
    List<PaginationItem> items() {
        provider.findAll(PaginationItem, By.expression('#' + id() + ' li'))
    }

    @Override
    Item selectedItem() {
        return items().find { Boolean.valueOf(provider.eval(it.id(), "it.hasClass('active')")) }
    }

    class PaginationItem extends Li {
        @Override
        boolean enabled() {
            !provider.check(id(), "it.hasClass('disabled')")
        }
    }
}