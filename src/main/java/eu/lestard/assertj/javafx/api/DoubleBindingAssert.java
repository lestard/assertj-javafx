package eu.lestard.assertj.javafx.api;

import eu.lestard.assertj.javafx.internal.ObservableNumberValueAssertions;
import eu.lestard.assertj.javafx.internal.ObservableValueAssertions;
import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.value.ObservableNumberValue;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.data.Offset;

/**
 * Assertion methods for {@link DoubleBinding}s.
 *
 * <p> To create an instance of this class, invoke
 * <code>{@link eu.lestard.assertj.javafx.api.Assertions#assertThat(DoubleBinding)}</code>.
 * </p>
 *
 * @author manuel mauky
 */
public class DoubleBindingAssert extends AbstractAssert<DoubleBindingAssert, DoubleBinding> {

    protected DoubleBindingAssert(DoubleBinding actual) {
        super(actual, DoubleBindingAssert.class);
    }

    /**
     * Verifies that the actual observable has the expected value set.
     *
     * @param expectedValue the value to compare to the actual observables current value.
     * @return {@code this} assertion instance.
     */
    public DoubleBindingAssert hasValue(Double expectedValue) {
        new ObservableValueAssertions<>(actual).hasValue(expectedValue);
        return this;
    }

    /**
     * Verifies that the actual observable number has a value that is close to the given one by less then the given offset.
     *
     * @param expectedValue the given value to compare the actual observables value to.
     * @param offset the given positive offset.
     * @return  {@code this} assertion object.
     *
     * @throws java.lang.NullPointerException if the given offset is <code>null</code>.
     * @throws java.lang.AssertionError if the actual observables value is not equal to the expected one.
     */
    public DoubleBindingAssert hasValue(Double expectedValue, Offset offset){
        new ObservableNumberValueAssertions(actual).hasValue(expectedValue, offset);

        return this;
    }

    /**
     * Verifies that the actual Binding is bound and depends on the given Observable value.
     *
     * @param observable the observable that is expected to be a binding dependency of the actual binding.
     * @return {@code this} assertion instance
     */
    public DoubleBindingAssert dependsOn(Observable observable) {
        new BindingAssert<>(actual).dependsOn(observable);
        return this;
    }

    /**
     * Verifies that the actual observable has the same value as the given observable.
     *
     * @param expectedValue the observable value to compare with the actual observables current value.
     *
     * @return {@code this} assertion instance.
     */
    public DoubleBindingAssert hasSameValue(ObservableNumberValue expectedValue) {
        new ObservableValueAssertions<>(actual).hasSameValue(expectedValue);
        return this;
    }
}