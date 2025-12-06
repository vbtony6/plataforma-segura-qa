import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
public class PruebaLogin2FATest {

    // ----------------------------------------
    //  Leer OTP generado por pruebas-api
    // ----------------------------------------
    public String leerOTP() {
        try {
            // Ruta relativa correcta entre módulos del proyecto
            Path ruta = Paths.get("../otp/otp-generado.txt").toAbsolutePath();
            byte[] contenido = Files.readAllBytes(ruta);
            return new String(contenido).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // ----------------------------------------
    //  TEST UI Playwright + Allure
    // ----------------------------------------
    @Test
    public void validarOTPCorrecto() {

        String otp = leerOTP();
        System.out.println("OTP leído desde archivo: " + otp);

        // Playwright en modo headless para GitHub Actions
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(true)   // 👈 Obligatorio en GitHub Actions
                            .setArgs(Arrays.asList("--no-sandbox", "--disable-dev-shm-usage"))
            );

            Page page = browser.newPage();

            // ----------------------------------------
            // Cargar el HTML desde target/test-classes
            // ----------------------------------------
            String rutaHtml = Paths.get("target", "test-classes", "html", "otp.html")
                    .toAbsolutePath()
                    .toUri()
                    .toString();

            System.out.println("Ruta HTML cargada: " + rutaHtml);

            page.navigate(rutaHtml);

            // ----------------------------------------
            // Interacciones en UI
            // ----------------------------------------
            page.waitForSelector("#codigo");
            page.fill("#codigo", otp);

            page.locator("button:has-text('Validar Código')").click();

            page.waitForSelector("#resultado");

            // ----------------------------------------
            // 📸 Captura para Allure
            // ----------------------------------------
            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions().setFullPage(true)
            );

            Allure.addAttachment(
                    "Pantalla después de validar OTP",
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    "png"
            );

            System.out.println("🔐 Validación OTP finalizada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error durante la validación del OTP", e);
        }
    }
}