package co.com.davivienda.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Upload;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UploadFileFrom implements Interaction {

    private final String fileName;
    private final Target target;

    public UploadFileFrom(String fileName, Target target) {
        this.fileName = fileName;
        this.target = target;
    }

    public static UploadFileFrom resources(String fileName, Target target) {
        return instrumented(UploadFileFrom.class, fileName, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Define la ruta relativa
        String relativePath = "src/test/resources/images/" + fileName;

        // 2. Crea el objeto Path
        java.nio.file.Path path = java.nio.file.Paths.get(relativePath);

        // 3. Verifica si el archivo existe físicamente
        if (!path.toFile().exists()) {
            throw new RuntimeException("la imagen no está en: " + path.toAbsolutePath());
        }

        actor.attemptsTo(
                // Pasa el objeto 'path' directamente
                Upload.theFile(path).to(target)
        );
    }

}