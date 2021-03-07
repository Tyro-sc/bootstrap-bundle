package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.Div
import sc.tyro.core.support.property.TextSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.bundle.bootstrap.Tyro.*
import static sc.tyro.bundle.bootstrap.Type.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Alert Tests")
class AlertTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'alert.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Alert in Div
        assert Alert in TextSupport
    }

    @Test
    @DisplayName("Should have expected properties")
    void properties() {
        Alert alert = $('.alert:eq(0)') as Alert

        assert alert.text() == "A simple primary alert—check it out!"
        assert alert.type() == PRIMARY

        alert = $('.alert:eq(1)') as Alert
        assert alert.type() == SECONDARY

        alert = $('.alert:eq(2)') as Alert
        assert alert.type() == SUCCESS

        alert = $('.alert:eq(3)') as Alert
        assert alert.type() == DANGER

        alert = $('.alert:eq(4)') as Alert
        assert alert.type() == WARNING

        alert = $('.alert:eq(5)') as Alert
        assert alert.type() == INFO

        alert = $('.alert:eq(6)') as Alert
        assert alert.type() == LIGHT

        alert = $('.alert:eq(7)') as Alert
        assert alert.type() == DARK

        alert = $('.alert:eq(0)') as Alert
        assert alert.type() == PRIMARY
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        Alert alert = findByText('A simple primary alert—check it out!', Alert)
        alert.should {
            have text('A simple primary alert—check it out!')
            have type(PRIMARY)
        }
    }
}
