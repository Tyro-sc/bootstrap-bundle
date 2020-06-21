package sc.tyro.bundle.bootstrap

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sc.tyro.bundle.TyroWebTestExtension

import static sc.tyro.bundle.TyroWebTestExtension.BASE_URL
import static sc.tyro.core.Tyro.visit

/**
 * @author David Avenante
 * @since 1.0.0
 */
@ExtendWith(TyroWebTestExtension)
@DisplayName("Alert Tests")
class AlertTest {
    @BeforeAll
    static void before() {
        visit BASE_URL + 'index.html'
    }

    @Test
    void dummy() {
        println "Yahhhh"
    }

}
