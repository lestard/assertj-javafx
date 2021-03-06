package eu.lestard.assertj.javafx.api;

import eu.lestard.assertj.javafx.internal.ObservableValueAssertions;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ObservableNumberValue;
import org.assertj.core.api.AbstractAssert;


/**
 * Assertion methods for {@link ReadOnlyIntegerProperty}s.
 *
 * <p> To create an instance of this class, invoke
 * <code>{@link eu.lestard.assertj.javafx.api.Assertions#assertThat(ReadOnlyIntegerProperty)}</code>.
 * </p>
 *
 * @author manuel mauky
 */
public class ReadOnlyIntegerPropertyAssert extends AbstractAssert<ReadOnlyIntegerPropertyAssert, ReadOnlyIntegerProperty> {
    protected ReadOnlyIntegerPropertyAssert(ReadOnlyIntegerProperty actual) {
        super(actual, ReadOnlyIntegerPropertyAssert.class);
    }

    /**
     * Verifies that the actual observable has the expected value set.
     *
     * @param expectedValue the value to compare to the actual observables current value.
     * @return {@code this} assertion instance.
     */
    public ReadOnlyIntegerPropertyAssert hasValue(int expectedValue) {
        new ObservableValueAssertions<>(actual).hasValue(expectedValue);

        return this;
    }

    /**
     * Verifies that the actual observable has the same value as the given observable.
     *
     * @param expectedValue the observable value to compare with the actual observables current value.
     *
     * @return {@code this} assertion instance.
     */
    public ReadOnlyIntegerPropertyAssert hasSameValue(ObservableNumberValue expectedValue) {
        new ObservableValueAssertions<>(actual).hasSameValue(expectedValue);
        return this;
    }
}
