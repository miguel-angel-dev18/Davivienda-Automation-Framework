package co.com.davivienda.automation.task;

import io.restassured.filter.session.SessionFilter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultEmployees implements Task {

    private SessionFilter sessionFilter;

    public ConsultEmployees(SessionFilter sessionFilter) {
        this.sessionFilter = sessionFilter;
    }

    public static ConsultEmployees withDetailedFilter(SessionFilter sessionFilter) {
        return instrumented(ConsultEmployees.class, sessionFilter);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/v2/pim/employees")
                        .with(request -> request
                                .filter(sessionFilter)
                                .queryParam("limit", "50")
                                .queryParam("offset", "0")
                                .queryParam("model", "detailed")
                                .header("Accept", "application/json")
                        )
        );
    }
}