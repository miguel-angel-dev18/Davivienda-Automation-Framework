package co.com.davivienda.automation.stepdefinitions;

import co.com.davivienda.automation.interactions.ClickOn;
import co.com.davivienda.automation.interactions.WaitUntilReady;
import co.com.davivienda.automation.question.DirectoryDetail;
import co.com.davivienda.automation.question.ProfileDetail;
import co.com.davivienda.automation.question.TheProfileName;
import co.com.davivienda.automation.question.UploadWasSuccessful;
import co.com.davivienda.automation.task.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static co.com.davivienda.automation.ui.DashboardUI.*;
import static co.com.davivienda.automation.util.getFullName.formatFullName;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;


public class EmpleadoStepDefinitions
{

    @Given("el usuario ingresa a la plataforma OrangeHRM")
    public void accessThePlatform()
    {
        // El actor abre la URL
        theActorCalled("Client").wasAbleTo(
                OpenThePage.orangeHrmPlatform()
        );
    }

    @When("ingresa el usuario {string} y la clave {string}")
    public void enterAccessCredentials(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(
                Login.with(user,pass)
        );
    }

    @Then("debería ver el dashboard para el usuario {string}")
    public void verifyDashboardUser(String expectedUser) {
        // El actor debería ver que el nombre del perfil es igual al esperado
        theActorInTheSpotlight().should(
                seeThat(TheProfileName.is(), equalTo(expectedUser))
        );
    }
    @When("El usuario selecciona {string} opcion del menu lateral")
    public void navigateToPim(String module) {
        theActorInTheSpotlight().attemptsTo(
                // Usamos el locator del span PIM que ya tienes
                ClickOn.theButton(MENU_PIM)
        );
    }

    @Then("El usuario agrega un empleado {string} {string} {string} {string}")
    public void fillEmployeeInformation(String nombre,String segundo_nombre,String apellido, String codigo_empleado) {
        theActorInTheSpotlight().attemptsTo(

                AddEmployee.withData(nombre,segundo_nombre,apellido,codigo_empleado)
        );
    }

    @Then("deberia ver el detalle perfil usuario registrado {string} {string} {string} {string}")
    public void verifyProfileDetail(String name,String secondName,String lastName,String employeeId)
    {
        String expectedFullName = name + " " + lastName;
        // 1. Ejecuta la espera
        theActorInTheSpotlight().attemptsTo(
                WaitUntilReady.target(expectedFullName, LBL_PROFILE_NAME)
               // WaitUntilReady.target(expectedFullName, FIRST_NAME_PROFILE_DETAIL)

        );

        // 2. Luego hace la validación
        theActorInTheSpotlight().should(
                seeThat("El nombre del perfil",
                        act -> ProfileDetail.information().answeredBy(act).getProfileName(),
                        equalTo(expectedFullName)),

                seeThat("el Primer nombre",

                        act -> ProfileDetail.information().answeredBy(act).getFirstName(),
                        equalTo(name)),
                seeThat("el Segundo  nombre",
                        act -> ProfileDetail.information().answeredBy(act).getMiddleName(),
                        equalTo(secondName)),

                seeThat("el Apellido",
                        act -> ProfileDetail.information().answeredBy(act).getLastName(),
                        equalTo(lastName)),

                seeThat("el Id empleado",
                        act -> ProfileDetail.information().answeredBy(act).getEmployeeId(),
                        equalTo(employeeId))

        );

    }
    @When("el usuario sube la foto de perfil")
    public void elUsuarioSubeLaFotoDePerfil()

    {
        theActorInTheSpotlight().attemptsTo(
            new UploadProfilePicture()
    );
    }
    @Then("el usuario valida el exito del cargue de la foto")
    public void elUsuarioValidaElExitoDelCargue() {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de exito en panttalla",
                        UploadWasSuccessful.isVisible(), is(true))

        );
    }
    @When("El usuario selecciona {string} del menu lateral")
    public void navigateToDirectory(String module)
    {
        theActorInTheSpotlight().attemptsTo(
                ClickOn.theButton(DIRECTORY_MENU_OPTION)
        );
    }

    @When("El usuario busca un empleado {string} {string} {string}")
    public void findEmployee(String nombre,String segundo_nombre,String apellido)
    {
        String expectedFullName = formatFullName(nombre, segundo_nombre, apellido);

        theActorInTheSpotlight().attemptsTo(
                SearchEmployee.withName(nombre,expectedFullName)
        );
    }

    @Then("deberia ver al usuario {string} {string} {string} en el directorio")
    public void verifyUserInDirectory(String nombre,String segundo_nombre,String apellido)
    {
        String expectedName = formatFullName(nombre, segundo_nombre, apellido);
        theActorInTheSpotlight().should(
                seeThat("el nombre en la tarjeta del directorio",
                        DirectoryDetail.name(),
                        containsString(expectedName))
        );
    }


}
