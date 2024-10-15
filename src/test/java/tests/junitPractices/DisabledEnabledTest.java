package tests.junitPractices;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class DisabledEnabledTest {

    @Test
    public void firstTest(){
        System.out.println("This is the first test ");
    }

    @Disabled(value = "Disabled for demo")
    @Test
    public void secondTest(){
        System.out.println("This is the second test ");
    }

    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Windows test are enabled")
    @Test
    public void thirdTest(){
        System.out.println("This is the third test ");
    }

    @DisabledIfSystemProperty(named = "env", matches = "staging")
    @Test
    public void fourthTest(){
        System.out.println("This is the fourth test ");
    }


    @DisabledIf(value = "provider", disabledReason = "Disabled for if condition method")
    @Test
    public void fifthTest(){
        System.out.println("This is the fourth test ");
    }

    boolean provider(){
        return true;
    }
}
