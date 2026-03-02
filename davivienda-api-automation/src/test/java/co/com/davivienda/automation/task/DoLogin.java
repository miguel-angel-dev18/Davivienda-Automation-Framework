package co.com.davivienda.automation.task;

import io.restassured.filter.session.SessionFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoLogin implements Task {
    private final String user;
    private final String pass;
    private final SessionFilter sessionFilter;

    public DoLogin(String user, String pass,SessionFilter sessionFilter) {
        this.user = user;
        this.pass = pass;
        this.sessionFilter = sessionFilter;
    }

    public static DoLogin conCredenciales(String user, String pass, SessionFilter sessionFilter) {
        return instrumented(DoLogin.class, user, pass,sessionFilter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Carga la página
        actor.attemptsTo(Get.resource("/auth/login"));

        // 2. Extrae para el atributo :token
        String responseBody = SerenityRest.lastResponse().asString();

        // Busca lo que hay entre :token="&quot; y &quot;"
        String token = responseBody.split(":token=\"&quot;")[1].split("&quot;")[0];

        // 3. Post de validación con los headers
        actor.attemptsTo(
                Post.to("/auth/validate")
                        .with(request -> request
                                .filter(sessionFilter)
                                .header("Content-Type", "application/x-www-form-urlencoded")
                                .header("Referer", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
                                .formParam("_token", token)
                                .formParam("username", user)
                                .formParam("password", pass)
                        )
        );
    }
}
