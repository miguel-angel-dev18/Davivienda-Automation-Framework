package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class WaitUntilReady implements Interaction {
    private final Target target;
    private final String textoEsperado;

    public WaitUntilReady(Target target,String textoEsperado) {
        this.target = target;
        this.textoEsperado = textoEsperado;

    }

    public static WaitUntilReady target(String texto,Target target) {
        return instrumented(WaitUntilReady.class, target,texto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(target, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(target, containsText(textoEsperado)).forNoMoreThan(15).seconds()

        );
    }
}