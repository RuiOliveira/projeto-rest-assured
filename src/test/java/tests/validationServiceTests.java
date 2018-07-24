package tests;

import net.thucydides.core.annotations.Steps;
import steps.requests.requestExample;

public class validationServiceTests {
    @Steps requestExample requestExample;

    public validationServiceTests(){
        //requestExample.requestExample("UMA_SOURCE_QUALQUER");
        requestExample.requestExample("https://reqres.in");
    }
}
