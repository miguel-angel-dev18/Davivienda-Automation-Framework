package co.com.davivienda.automation.task;

import co.com.davivienda.automation.interactions.ClickOn;
import co.com.davivienda.automation.interactions.TypeCharByChar;
import co.com.davivienda.automation.interactions.WaitUntilVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static co.com.davivienda.automation.ui.DirectoryUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchEmployee implements Task
{

    private final String employeeName;
    private final String expectedFullName;

    public SearchEmployee(String employeeName,String expectedFullName)
    {
        this.employeeName = employeeName;
        this.expectedFullName=expectedFullName;
    }


    public static SearchEmployee withName(String employeeName , String expectedFullName)
    {
        return instrumented(SearchEmployee.class, employeeName,expectedFullName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntilVisible.the(SEARCH_INPUT),
                TypeCharByChar.theValue(employeeName,SEARCH_INPUT),
                ClickOn.theButton(EMPLOYEE_OPTION.of(expectedFullName)),
                ClickOn.theButton(SEARCH_BUTTON)

        );
    }
}