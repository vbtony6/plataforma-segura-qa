package paginas;

import com.microsoft.playwright.Page;

public class Pagina2FA {

    private final Page page;

    // Selectores ficticios (los ajustamos cuando montemos tu mock de 2FA)
    private final String campoOTP = "#otpCode";
    private final String botonVerificar = "#verify";
    private final String mensajeError = "#otpError";

    public Pagina2FA(Page page) {
        this.page = page;
    }

    public void ingresarCodigo(String codigo) {
        page.fill(campoOTP, codigo);
    }

    public void verificarCodigo() {
        page.click(botonVerificar);
    }

    public boolean errorVisible() {
        return page.isVisible(mensajeError);
    }

    public void enviarCodigo(String codigo) {
        ingresarCodigo(codigo);
        verificarCodigo();
    }
}
