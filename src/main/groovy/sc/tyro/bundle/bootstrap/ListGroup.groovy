package sc.tyro.bundle.bootstrap


import sc.tyro.core.By
import sc.tyro.core.component.Item
import sc.tyro.core.component.ListView
import sc.tyro.core.support.property.SelectedItemSupport
import sc.tyro.web.CssIdentifier

/**
 * @author David Avenante
 * @since 1.0.0
 */
@CssIdentifier('.list-group')
class ListGroup extends ListView implements SelectedItemSupport {
    @Override
    List<ListGroupItem> items() {
        provider.findAll(ListGroupItem, By.expression('#' + id() + ' > *'))
    }

    @Override
    ListGroupItem item(String value) {
        items().find { it.value() == value }
    }

    @Override
    Item selectedItem() {
        items().find { it.selected() }
    }

    @Override
    boolean empty() {
        items().empty
    }

    @CssIdentifier('li, a, button')
    private class ListGroupItem extends Item {
        @Override
        boolean enabled() {
            !provider.check(id(), "el.is(':disabled') || el.attr('disabled') != undefined || it.hasClass('disabled')")
        }

        @Override
        Object value() {
            provider.eval(id(), "it.text()")
        }

        @Override
        boolean selected() {
            Boolean.valueOf(provider.eval(id(), "it.hasClass('active')"))
        }
    }
}


