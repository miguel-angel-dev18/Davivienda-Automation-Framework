package co.com.davivienda.automation.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class WaitUntilVisible implements Interaction {

    private final Target target;

    public WaitUntilVisible(Target target)
    {
        this.target = target;
    }

    public static WaitUntilVisible the(Target target) {
        return instrumented(WaitUntilVisible.class, target);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isPresent()).forNoMoreThan(15).seconds()
        );
    }
}