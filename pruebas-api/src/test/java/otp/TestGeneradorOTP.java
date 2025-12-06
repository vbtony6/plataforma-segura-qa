package otp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGeneradorOTP {

    @Test
    public void generarOTPTest() {
        String otp = GeneradorOTP.generarOTP();
        System.out.println("OTP generado desde pruebas-api: " + otp);

        assertNotNull(otp);
        assertEquals(6, otp.length());
    }
}
