package co.com.davivienda.automation.stepdefinitions;

import co.com.davivienda.automation.task.ConsultEmployees;
import co.com.davivienda.automation.task.DoLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.filter.session.SessionFilter;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.lessThan;
import java.util.concurrent.TimeUnit;

public class LoginStepDefinitions {

    private SessionFilter sessionFilter = new SessionFilter();

    @When("intento autenticarme en la API con usuario {string} y clave {string}")
    public void intentarAutenticacion(String usuario, String clave) {

        theActorCalled("Usuario")
                .can(CallAnApi.at("https://opensource-demo.orangehrmlive.com/web/index.php"))
                .attemptsTo(
                        DoLogin.conCredenciales(usuario, clave, sessionFilter)
                );
    }

    @Then("el código de respuesta debe ser {int}")
    public void validarCodigoRespuesta(int codigo) {
        theActorInTheSpotlight().should(
                seeThatResponse("El servidor respondió con el código esperado",
                        response -> response.statusCode(codigo)),
                seeThatResponse("El tiempo de respuesta es óptimo",
                        response -> response.time(lessThan(3000L), TimeUnit.MILLISECONDS))
        );
    }

    @And("consulto la lista de empleados con el filtro detallado")
    public void consultarListaEmpleados() {
        theActorInTheSpotlight().attemptsTo(
                ConsultEmployees.withDetailedFilter(sessionFilter)
        );
    }

    @Then("validar que la lista de empleados cumpla con el esquema definido")
    public void validarEsquemaEmpleados()
    {
        //Captura el código status
        int actualStatusCode = SerenityRest.lastResponse().statusCode();

        if (actualStatusCode == 200) {
            theActorInTheSpotlight().should(
                    seeThatResponse("Validar esquema de empleados",
                            response -> response.body(matchesJsonSchemaInClasspath("schemas/employees.json")))
            );
        } else if (actualStatusCode == 401) {
            theActorInTheSpotlight().should(
                    seeThatResponse("Validar esquema de error",
                            response -> response.body(matchesJsonSchemaInClasspath("schemas/error-schema.json")))
            );
        }
    }
}