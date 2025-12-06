package otp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class GeneradorOTP {

    public static String generarOTP() {
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000);
        String codigo = String.valueOf(numero);

        try {
            // 📌 Ruta del archivo OTP centralizado
            Path ruta = Paths.get("../otp/otp-generado.txt").toAbsolutePath();

            // 📌 Crear carpeta si no existe
            Files.createDirectories(ruta.getParent());

            // 📌 Guardar OTP en archivo compartido
            Files.write(ruta, codigo.getBytes());

            System.out.println("OTP guardado en: " + ruta);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return codigo;
    }
}