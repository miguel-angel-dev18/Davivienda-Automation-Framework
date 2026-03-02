package co.com.davivienda.automation.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DirectoryUI
{
    public static final Target SEARCH_INPUT = Target.the("employee hints search field")
            .located(By.cssSelector("input[placeholder='Type for hints...']"));

    public static final Target SEARCH_BUTTON = Target.the("search button")
            .located(By.xpath("//button[@type='submit'][contains(normalize-space(), 'Search')]"));

    public static final Target EMPLOYEE_OPTION = Target.the("Employee option {0}")
            .locatedBy("//div[@role='option'][contains(., '{0}')]");
    public static final Target LBL_PROFILE_NAME_DIRECTORY = Target.the("Nombre del perfil en la tarjeta")
            .locatedBy("//p[contains(@class, 'orangehrm-directory-card-header')]");
}
