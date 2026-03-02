package co.com.davivienda.automation.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginUi
{
    public static final Target USERNAME = Target.the("username field")
            .located(By.cssSelector("input[name='username']"));
    public static final Target PASSWORD = Target.the("password field")
            .located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.cssSelector("button[type='submit']"));
}
