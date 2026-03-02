package co.com.davivienda.automation.question;

import co.com.davivienda.automation.ui.DashboardUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheProfileName implements Question<String>
{
    @Override
    public String answeredBy(Actor actor)
    {
        // Esta es la forma desacoplada de obtener el texto del elemento
       return Text.of(DashboardUI.USER_PROFILE_NAME).answeredBy(actor);

    }

    public static TheProfileName is()
    {
        return new TheProfileName();
    }
}
