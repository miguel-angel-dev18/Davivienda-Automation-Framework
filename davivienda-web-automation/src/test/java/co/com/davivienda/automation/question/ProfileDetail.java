package co.com.davivienda.automation.question;

import co.com.davivienda.automation.models.ProfileData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import static co.com.davivienda.automation.ui.DashboardUI.*;

public class ProfileDetail implements Question<ProfileData> {

    public static ProfileDetail information()
    {
        return new ProfileDetail();
    }

    @Override
    public ProfileData answeredBy(Actor actor) {

        // Extrae el texto del Target

        String profileName = Text.of( LBL_PROFILE_NAME).answeredBy(actor).trim();
        String firstName = Value.of(FIRST_NAME_PROFILE_DETAIL).answeredBy(actor).trim();
        String middleName = Value.of(INPUT_MIDDLE_PROFILE_DETAIL).answeredBy(actor).trim();
        String lastName = Value.of(INPUT_LAST_NAME_PROFILE_DETAIL).answeredBy(actor).trim();
        String employeeId = Value.of( INPUT_CODE_EMPLOYEE_PROFILE_DETAIL).answeredBy(actor).trim();

        return new ProfileData(profileName,firstName,middleName,lastName,employeeId);
    }


}