package co.com.davivienda.automation.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.davivienda.automation.ui.DirectoryUI.LBL_PROFILE_NAME_DIRECTORY;

public class DirectoryDetail implements Question<String> {

    public static DirectoryDetail name() {
        return new DirectoryDetail();
    }

    @Override
    public String answeredBy(Actor actor)
    {
        // Obtiene el texto y limpia espacios o saltos de línea
        return Text.of(LBL_PROFILE_NAME_DIRECTORY).answeredBy(actor).trim();
    }
}
