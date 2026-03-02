package co.com.davivienda.automation.stepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.util.EnvironmentVariables;
import io.cucumber.java.Before;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {
    private EnvironmentVariables environmentVariables;

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
        String baseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://opensource-demo.orangehrmlive.com/web/index.php");

        theActorCalled("Usuario Test").can(CallAnApi.at(baseUrl));
    }
}
