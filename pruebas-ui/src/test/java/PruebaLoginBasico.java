import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import paginas.PaginaLogin;

public class PruebaLoginBasico {

    @Test
    public void validarLoginBasico() {

        try (Playwright playwright = Playwright.create()) {
            Browser navegador = playwright.chromium().launch();
            Page pagina = navegador.newPage();

            // Usar el POM
            PaginaLogin login = new PaginaLogin(pagina);

            login.irALogin();
            login.iniciarSesion("usuarioDemo", "passwordDemo");

            // Validamos que carga la página de login (o página siguiente si decides)
            Assertions.assertEquals("DEMOQA", pagina.title());
        }
    }
}