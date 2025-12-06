package paginas;

import com.microsoft.playwright.Page;

public class PaginaLogin {

    private final Page page;

    // Selectores (en español)
    private final String campoUsuario = "#userName";
    private final String campoClave = "#password";
    private final String botonLogin = "#login";

    public PaginaLogin(Page page) {
        this.page = page;
    }

    // Ir a la página de login
    public void irALogin() {
        page.navigate("https://demoqa.com/login");
    }

    // Ingresar usuario
    public void escribirUsuario(String usuario) {
        page.fill(campoUsuario, usuario);
    }

    // Ingresar clave
    public void escribirClave(String clave) {
        page.fill(campoClave, clave);
    }

    // Clic en iniciar sesión
    public void hacerLogin() {
        page.click(botonLogin);
    }

    // Flujo completo resumido
    public void iniciarSesion(String usuario, String clave) {
        escribirUsuario(usuario);
        escribirClave(clave);
        hacerLogin();
    }
}
