package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Write implements Interaction
{
    private final Target target;
    private final String value;

    public Write(String value, Target target)
    {
        this.target = target;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Aquí espera inteligente
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(value).into(target)
        );
    }

    public static Write theValue(String value, Target target)
    {
        return instrumented(Write.class, value, target);
    }

}
