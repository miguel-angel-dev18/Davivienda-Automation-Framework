package co.com.davivienda.automation.task;

import co.com.davivienda.automation.interactions.ClearField;
import co.com.davivienda.automation.interactions.ClickOn;
import co.com.davivienda.automation.interactions.Write;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import static co.com.davivienda.automation.ui.DashboardUI.*;


public class AddEmployee implements Task
{
    private final String name;
    private final String middle_name;
    private final String last_name;
    private final String code_employee;

    public AddEmployee(String name, String middle_name,String last_name,String code_employee)
    {
        this.name = name;
        this.middle_name = middle_name;
        this.last_name=last_name;
        this.code_employee=code_employee;
    }

    public static AddEmployee withData(String name, String middle_name, String last_name,String code_employee)

    {
        return Tasks.instrumented(AddEmployee.class, name, middle_name, last_name,code_employee);
    }
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo(

                ClickOn.theButton(BTN_ADD),
                Write.theValue(name,INPUT_FIRST_NAME),
                Write.theValue(middle_name,INPUT_MIDDLE_NAME),
                Write.theValue(last_name,INPUT_LAST_NAME),
                ClearField.from(INPUT_EMPLOYEE,code_employee),
                ClickOn.theButton(BTN_SAVE)






        );
    }
}
