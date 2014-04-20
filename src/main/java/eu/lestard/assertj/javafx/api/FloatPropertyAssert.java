package eu.lestard.assertj.javafx.api;

import eu.lestard.assertj.javafx.internal.ObservableNumberValueAssert;
import eu.lestard.assertj.javafx.internal.PropertyAssert;
import javafx.beans.property.FloatProperty;
import org.assertj.core.api.AbstractAssert;

public class FloatPropertyAssert extends AbstractAssert<FloatPropertyAssert, FloatProperty> {

    protected FloatPropertyAssert(FloatProperty actual) {
        super(actual, FloatPropertyAssert.class);
    }


    public FloatPropertyAssert hasValue(float expectedValue){
        new ObservableNumberValueAssert(actual).hasValue(expectedValue);

        return this;
    }

    public FloatPropertyAssert isBound(){
        new PropertyAssert(actual).isBound();

        return this;
    }
}