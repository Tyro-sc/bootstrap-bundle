package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.list.Ul
import sc.tyro.core.component.ListView
import sc.tyro.core.support.property.SelectedItemSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("ListGroup Tests")
class ListGroupTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'list-group.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert ListGroup in ListView
        assert ListGroup in SelectedItemSupport
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        ListGroup listGroup = $('.list-group:eq(0)') as ListGroup
        listGroup.should {
            have 5.items
            have items('An item', 'A second item', 'A third item', 'A fourth item', 'And a fifth one')
            have selectedItem('A fourth item')
        }

        listGroup.item('An item').should { be disabled }

        listGroup = $('.list-group:eq(1)') as ListGroup
        listGroup.should {
            have 5.items
            have items('The current link item', 'A second link item', 'A third link item', 'A fourth link item', 'A disabled link item')
            have selectedItem('The current link item')
        }

        listGroup.item('A disabled link item').should { be disabled }

        listGroup = $('.list-group:eq(2)') as ListGroup
        listGroup.should {
            have 5.items
            have items('The current button', 'A second item', 'A third button item', 'A fourth button item', 'A disabled button item')
            have selectedItem('The current button')
        }

        listGroup.item('A disabled button item').should { be disabled }
    }
}
