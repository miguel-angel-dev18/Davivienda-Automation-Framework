package co.com.davivienda.automation.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.com.davivienda.automation.ui.DashboardUI.TOAST_EXITO;

public class UploadWasSuccessful implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return TOAST_EXITO .resolveFor(actor).isVisible();
    }

    public static UploadWasSuccessful isVisible()
    {
        return new UploadWasSuccessful();
    }
}