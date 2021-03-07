package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.list.Ol

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Breadcrumb Tests")
class BreadcrumbTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'breadcrumb.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Breadcrumb in Ol
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        Breadcrumb breadcrumb = $('.breadcrumb') as Breadcrumb
        breadcrumb.should {
            have items('Home', 'Library', 'Data')
            have selectedItem('Data')
        }
    }
}
