package co.com.davivienda.automation.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenThePage implements Task
{
    @Override
    public <T extends Actor> void performAs(T actor) {
        // acción base  Serenity para abrir la URL configurada
        actor.attemptsTo(
                Open.browserOn().thePageNamed("webdriver.base.url")
        );
    }

    public static OpenThePage orangeHrmPlatform()
    {
        return instrumented(OpenThePage.class);
    }
}
