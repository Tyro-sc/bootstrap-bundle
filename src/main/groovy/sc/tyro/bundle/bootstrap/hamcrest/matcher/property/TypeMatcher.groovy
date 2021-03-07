package sc.tyro.bundle.bootstrap.hamcrest.matcher.property

import org.hamcrest.Description
import sc.tyro.bundle.bootstrap.Type
import sc.tyro.bundle.bootstrap.support.property.TypeSupport
import sc.tyro.core.hamcrest.PropertyMatcher

/**
 * @author David Avenante
 * @since 1.0.0
 */
class TypeMatcher extends PropertyMatcher<TypeSupport> {
    private Type type;

    TypeMatcher(Type type) {
        this.type = type
    }

    @Override
    protected boolean matchesSafely(TypeSupport component) {
        return component.type() == type
    }

    @Override
    void describeTo(Description description) {
        description.appendText('type ').appendValue(type)
    }

    @Override
    protected void describeMismatchSafely(TypeSupport component, Description mismatchDescription) {
        mismatchDescription.appendText('has type ').appendValue(component.type())
    }
}
