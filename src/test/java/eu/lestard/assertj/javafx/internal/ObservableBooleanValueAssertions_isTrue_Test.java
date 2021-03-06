package eu.lestard.assertj.javafx.internal;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ObservableBooleanValueAssertions_isTrue_Test {


    @Test
    public void should_pass_if_actual_is_true(){
        ObservableBooleanValue actual = new SimpleBooleanProperty(true);

        new ObservableBooleanValueAssertions(actual).isTrue();
    }

    @Test
    public void should_fail_if_actual_is_false(){
        try{
            ObservableBooleanValue actual = new SimpleBooleanProperty(false);

            new ObservableBooleanValueAssertions(actual).isTrue();
            fail("Should throw an AssertionError");
        }catch (AssertionError error){
            assertThat(error).hasMessageContaining("to be true but it wasn't");
        }
    }

    @Test(expected = AssertionError.class)
    public void should_fail_if_actual_is_null(){
        new ObservableBooleanValueAssertions(null).isTrue();
    }

}
