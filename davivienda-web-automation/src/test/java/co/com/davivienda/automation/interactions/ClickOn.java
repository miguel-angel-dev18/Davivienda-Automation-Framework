package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ClickOn implements Interaction
{
    private final Target target;

    public ClickOn(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isEnabled()).forNoMoreThan(15).seconds(),
                Click.on(target)
        );
    }

    public static ClickOn theButton(Target target) {
        return instrumented(ClickOn.class, target);
    }
}
