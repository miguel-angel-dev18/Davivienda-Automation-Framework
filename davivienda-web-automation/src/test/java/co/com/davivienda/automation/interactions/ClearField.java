package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClearField implements Interaction {
    private final Target target;
    private final String value;

    public ClearField(Target target,String value) {
        this.target = target;
        this.value=value;
    }

    public static ClearField from(Target target,String value) {
        return instrumented(ClearField.class, target,value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Dar foco y seleccionar todo usando una cadena de teclas
                Enter.theValue(Keys.CONTROL + "a").into(target),

                // 2. Borrar lo seleccionado
                Hit.the(Keys.BACK_SPACE).into(target),

                // 3. Ingresar el valor real
                Enter.theValue(value).into(target)
        );
    }
}