package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
public class ClickOnNonButton implements Interaction {

    private final Target target;

    public ClickOnNonButton(Target target) {
        this.target = target;
    }

    public static ClickOnNonButton element(Target target) {
        return instrumented(ClickOnNonButton.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        // 1. ESPERA EXPLÍCITA
        actor.attemptsTo(
                WaitUntil.the(target, isPresent()).forNoMoreThan(15).seconds()
        );

        // 2. PREGUNTA: Si el elemento está presente y es visible para el actor
        if (target.resolveFor(actor).isVisible()) {

            // 3. ACCIÓN: Clic de JavaScript (evita errores de "Not Enabled")
            WebElement element = target.resolveFor(actor);
            BrowseTheWeb.as(actor).evaluateJavascript("arguments[0].click();", element);

        } else {
            // Si llega aquí y no es visible, lanza un error claro para el reporte
            throw new RuntimeException("El elemento " + target.getName() + " no se hizo visible para el clic.");
        }
    }
}
