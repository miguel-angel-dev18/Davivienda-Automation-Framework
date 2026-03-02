package co.com.davivienda.automation.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardUI
{
    public static final Target USER_PROFILE_NAME = Target.the("User Profile Name")
            .locatedBy(".oxd-userdropdown-name");
    public static final Target MENU_PIM = Target.the("Boton del menú PIM")
            .locatedBy("//span[text()='PIM']");
    public static final Target BTN_ADD = Target.the("botón añadir empleado")
            .locatedBy("//button[contains(.,'Add')]");
    public static final Target INPUT_FIRST_NAME = Target.the("campo nombre del empleado")
            .located(By.name("firstName"));
    public static final Target FIRST_NAME_PROFILE_DETAIL = Target.the("campo nombre del empleado")
            .located(By.name("firstName"));
    public static final Target INPUT_MIDDLE_NAME = Target.the("campo segundo nombre")
            .located(By.name("middleName"));
    public static final Target INPUT_MIDDLE_PROFILE_DETAIL = Target.the("campo segundo nombre del empleado")
            .located(By.name("middleName"));
    public static final Target INPUT_EMPLOYEE = Target.the("campo ID del empleado")
            .locatedBy("//label[text()='Employee Id']/parent::div/following-sibling::div//input");
    public static final Target INPUT_LAST_NAME = Target.the("campo apellido")
            .located(By.name("lastName"));

    public static final Target INPUT_LAST_NAME_PROFILE_DETAIL = Target.the("campo apellido del empleado")
            .located(By.name("lastName"));
    public static final Target INPUT_CODE_EMPLOYEE_PROFILE_DETAIL = Target.the("campo con etiqueta específica")
            .locatedBy("//div[contains(., 'Employee Id')]/following-sibling::div//input");

    public static final Target BTN_SAVE = Target.the("botón guardar")
            .locatedBy("//button[@type='submit']");

    public static final Target LBL_PROFILE_NAME = Target.the("nombre del perfil en el encabezado")
            .locatedBy("//h6[contains(@class, 'oxd-text--h6') and contains(@class, '--strong')]");

    public static final Target PHOTO_PERFIL = Target.the("foto de perfil del empleado")
            .locatedBy("//img[@class='employee-image'] | //div[@class='orangehrm-edit-employee-image']//img");

    public static final Target PHOTO_PERFIL_DISPLAY = Target.the("imagen de perfil del empleado")
            .locatedBy("//img[contains(@class, 'employee-image')]");

    public static final Target INPUT_PHOTO = Target.the("input real de archivos")
            .locatedBy("//input[@type='file']");

    public static final Target BOTON_SAVE = Target.the("botón para guardar cambios")
            .locatedBy("//button[@type='submit'][contains(., 'Save')]");

    public static final Target TOAST_EXITO = Target.the("notificación verde de éxito")
            .locatedBy("//div[@id='oxd-toaster_1']//div[contains(@class, 'oxd-toast--success')]");

    public static final Target DIRECTORY_MENU_OPTION = Target.the("opción Directory del menú principal")
            .locatedBy("//span[contains(@class, 'oxd-main-menu-item--name') and text()='Directory']");



}
