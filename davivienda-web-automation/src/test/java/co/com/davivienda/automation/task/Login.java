package co.com.davivienda.automation.task;

import co.com.davivienda.automation.interactions.ClickOn;
import co.com.davivienda.automation.interactions.Write;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static co.com.davivienda.automation.ui.LoginUi.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login  implements Task
{
    private final String user;
    private final String password;

    public Login(String user, String password)
    {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Aquí  interacción desacoplada
                Write.theValue(user,USERNAME),
                Write.theValue(password,PASSWORD),
                ClickOn.theButton(LOGIN_BUTTON)

        );
    }
    public static Login with(String user, String password)

    {
        return instrumented(Login.class, user, password);
    }

}
