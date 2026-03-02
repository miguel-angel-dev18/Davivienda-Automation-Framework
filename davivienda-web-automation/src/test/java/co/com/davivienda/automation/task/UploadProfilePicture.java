package co.com.davivienda.automation.task;

import co.com.davivienda.automation.interactions.ClickOn;
import co.com.davivienda.automation.interactions.ClickOnNonButton;
import co.com.davivienda.automation.interactions.UploadFileFrom;
import co.com.davivienda.automation.interactions.WaitUntilVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static co.com.davivienda.automation.ui.DashboardUI.*;

public class UploadProfilePicture implements Task
{
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnNonButton.element(PHOTO_PERFIL),
                WaitUntilVisible.the(PHOTO_PERFIL_DISPLAY),
                UploadFileFrom.resources("perfil-de-naruto.jpg", INPUT_PHOTO),
                ClickOn.theButton(BOTON_SAVE)


        );
    }
}