package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension
import sc.tyro.bundle.html5.Span
import sc.tyro.core.support.property.TextSupport

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.bundle.bootstrap.Type.*
import static sc.tyro.bundle.bootstrap.Tyro.type
import static sc.tyro.core.Tyro.*

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Badge Tests")
class BadgeTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'badge.html'
    }

    @Test
    @DisplayName("Should have expected inheritance")
    void inheritance() {
        assert Badge in Span
        assert Badge in TextSupport
    }

    @Test
    @DisplayName("Should have expected properties")
    void properties() {
        Badge badge = $('.badge:eq(0)') as Badge

        assert badge.text() == "Primary"
        assert badge.type() == PRIMARY

        badge = $('.badge:eq(1)') as Badge
        assert badge.type() == SECONDARY

        badge = $('.badge:eq(2)') as Badge
        assert badge.type() == SUCCESS

        badge = $('.badge:eq(3)') as Badge
        assert badge.type() == DANGER

        badge = $('.badge:eq(4)') as Badge
        assert badge.type() == WARNING

        badge = $('.badge:eq(5)') as Badge
        assert badge.type() == INFO

        badge = $('.badge:eq(6)') as Badge
        assert badge.type() == LIGHT

        badge = $('.badge:eq(7)') as Badge
        assert badge.type() == DARK

        badge = $('.badge:eq(0)') as Badge
        assert badge.type() == PRIMARY
    }

    @Test
    @DisplayName("Should be use with DSL")
    void dsl() {
        Badge badge = findByText('Danger', Badge)
        badge.should {
            have text('Danger')
            have type(DANGER)
        }
    }
}
