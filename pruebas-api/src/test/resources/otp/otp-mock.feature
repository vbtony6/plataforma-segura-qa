Feature: Mock OTP dinámico

Scenario: Generar OTP
    * def otp = "123456"
    * def response = { otp: #(otp) }
    * print response