package org.example.booking;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class ReplaceUnderscoresAndOmitParameterTypes extends DisplayNameGenerator.ReplaceUnderscores {

    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return super.generateDisplayNameForMethod(testClass, testMethod).replaceAll("[(].*","");
    }
}
