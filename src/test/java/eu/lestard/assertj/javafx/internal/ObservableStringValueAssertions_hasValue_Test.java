package eu.lestard.assertj.javafx.internal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableStringValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ObservableStringValueAssertions_hasValue_Test {

    @Test
    public void should_pass_if_actual_has_given_value(){
        ObservableStringValue actual = new SimpleStringProperty("test");

        new ObservableStringValueAssertions(actual).hasValue("test");
    }

    @Test
    public void should_fail_if_expected_value_is_null(){
        try{
            ObservableStringValue actual = new SimpleStringProperty("test");

            new ObservableStringValueAssertions(actual).hasValue(null);
            fail("Should throw an AssertionError");
        }catch(AssertionError error){
            assertThat(error).hasMessageContaining("expected value may not be null");
        }
    }

    @Test
    public void should_fail_if_actual_has_wrong_value(){
        try{
            ObservableStringValue actual = new SimpleStringProperty("test");

            new ObservableStringValueAssertions(actual).hasValue("testest");
            fail("Should throw an AssertionError");
        }catch(AssertionError error){
            assertThat(error).hasMessageContaining("<testest> but was <test>");
        }
    }

    @Test
    public void should_fail_if_actual_has_value_of_null(){
        try{
            ObservableStringValue actual = new SimpleStringProperty();

            new ObservableStringValueAssertions(actual).hasValue("test");
            fail("Should throw an AssertionError");
        }catch(AssertionError error){
            assertThat(error).hasMessageContaining("<test> but was <null>");
        }
    }

    @Test(expected = AssertionError.class)
    public void should_fail_if_actual_is_null(){
        new ObservableStringValueAssertions(null).hasValue("test");
    }
}
