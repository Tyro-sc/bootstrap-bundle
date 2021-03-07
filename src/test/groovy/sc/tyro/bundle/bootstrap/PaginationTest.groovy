package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.list.Ul

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Pagination Tests")
class PaginationTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'pagination.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Pagination in Ul
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        Pagination pagination = $('.pagination') as Pagination
        pagination.should {
            have items('Previous', '1', '2', '3', 'Next')
            have selectedItem('2')
        }

        pagination.item('Next').should { be disabled }
    }
}
