package eu.lestard.assertj.javafx.internal;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableDoubleValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ObservableNumberValueAssertions_hasValue_double_with_offset_Test {

    @Test
    public void should_pass_if_actual_has_given_value_with_offset(){
        ObservableDoubleValue actual = new SimpleDoubleProperty(10.123);

        new ObservableNumberValueAssertions(actual).hasValue(10.12, offset(0.01));
    }

    @Test
    public void should_fail_if_actual_has_wrong_value(){
        try{
            ObservableDoubleValue actual = new SimpleDoubleProperty(10.123);

            new ObservableNumberValueAssertions(actual).hasValue(10.12, offset(0.001));
            fail("Should throw an AssertionError");
        }catch(AssertionError error){
            assertThat(error).hasMessageContaining("less than <0.001> but difference was <0.0030");
        }
    }

    @Test(expected = AssertionError.class)
    public void should_fail_if_actual_is_null(){
        new ObservableNumberValueAssertions(null).hasValue(10.123, offset(0.1));
    }

    @Test
    public void should_fail_if_offset_is_null(){
        try{
            ObservableDoubleValue actual = new SimpleDoubleProperty(10.123);
            new ObservableNumberValueAssertions(actual).hasValue(10.123, null);

            fail("Should throw an AssertionError");
        }catch(AssertionError error){
            assertThat(error).hasMessageContaining("offset may not be null");
        }
    }
}
