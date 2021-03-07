package sc.tyro.bundle.bootstrap

import sc.tyro.bundle.bootstrap.hamcrest.matcher.property.TypeMatcher

/**
 * @author David Avenante
 * @since 1.0.0
 */
class Tyro extends sc.tyro.core.Tyro {
    static TypeMatcher type(Type type) { new TypeMatcher(type) }
}
