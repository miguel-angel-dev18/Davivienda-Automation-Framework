package co.com.davivienda.automation.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hook
{
    @Before
    public void prepareActor()
    {
        // Esto crea el "escenario" y permite llamar al actor desde cualquier clase
        OnStage.setTheStage(new OnlineCast());
    }

}
