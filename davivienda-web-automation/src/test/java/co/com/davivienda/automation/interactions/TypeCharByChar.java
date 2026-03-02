package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TypeCharByChar implements Interaction
{

    private final String text;
    private final Target target;

    public TypeCharByChar(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    public static TypeCharByChar theValue(String text, Target target) {
        return instrumented(TypeCharByChar.class, text, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement element = target.resolveFor(actor);

        for (char letter : text.toCharArray())
        {
            element.sendKeys(String.valueOf(letter));
            // Un pequeño delay opcional para que la web procese cada letra
            try
             {
                   Thread.sleep(150);
              } catch (InterruptedException e)
                   {
                       Thread.currentThread().interrupt();
                   }
        }
    }
}