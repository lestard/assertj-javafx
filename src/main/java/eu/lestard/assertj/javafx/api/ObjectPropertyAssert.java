package eu.lestard.assertj.javafx.api;

import eu.lestard.assertj.javafx.internal.ObservableValueAssertions;
import eu.lestard.assertj.javafx.internal.PropertyAssertions;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import org.assertj.core.api.AbstractAssert;

/**
 * Assertion methods for {@link ObjectProperty}s.
 *
 * <p> To create an instance of this class, invoke
 * <code>{@link eu.lestard.assertj.javafx.api.Assertions#assertThat(ObjectProperty)}</code>.
 * </p>
 *
 * @author manuel mauky
 */
public class ObjectPropertyAssert<T> extends AbstractAssert<ObjectPropertyAssert<T>, ObjectProperty<T>> {

    protected ObjectPropertyAssert(ObjectProperty<T> actual) {
        super(actual, ObjectPropertyAssert.class);
    }

    /**
     * Verifies that the actual observable has the expected value set.
     *
     * @param expectedValue the value to compare to the actual observables current value.
     * @return {@code this} assertion instance.
     */
    public ObjectPropertyAssert<T> hasValue(T expectedValue) {
        new ObservableValueAssertions<>(actual).hasValue(expectedValue);
        return this;
    }

    /**
     * Verifies that the actual observable is bound by another observable.
     *
     * @return {@code this} assertion instance.
     */
    public ObjectPropertyAssert isBound() {
        new PropertyAssertions(actual).isBound();
        return this;
    }


    /**
     * Verifies that the actual observable has a value of <code>null</code>.
     *
     * @return {@code this} assertion instance.
     */
    public ObjectPropertyAssert<T> hasNullValue() {
        new ObservableValueAssertions<>(actual).hasNullValue();
        return this;
    }


    /**
     * Verifies that the actual observable has NOT a value of <code>null</code>.
     *
     * @return {@code this} assertion instance.
     */
    public ObjectPropertyAssert<T> hasNotNullValue() {
        new ObservableValueAssertions<>(actual).hasNotNullValue();
        return this;
    }

    /**
     * Verifies that the actual observable has the same value as the given observable.
     *
     * @param expectedValue the observable value to compare with the actual observables current value.
     *
     * @return {@code this} assertion instance.
     */
    public ObjectPropertyAssert<T> hasSameValue(ObservableObjectValue<T> expectedValue) {
        new ObservableValueAssertions<>(actual).hasSameValue(expectedValue);
        return this;
    }
}