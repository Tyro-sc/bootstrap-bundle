package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.Div
import sc.tyro.bundle.html5.list.Ul

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Progress Tests")
class ProgressTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'progress.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Progress in Div
    }

    @Test
    @DisplayName("Should have expected properties")
    void properties() {
        Progress progress = $('.progress:eq(3)') as Progress

        assert progress.maximum() == 100
        assert progress.value() == 75
        assert progress.label() == '75%'
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        Progress progress = $('.progress:eq(3)') as Progress
        progress.should {
            have label('75%')
            have maximum(100)
            have value(75)
        }
    }
}
