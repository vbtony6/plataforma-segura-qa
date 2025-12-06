Feature: Validar autenticación correcta

Scenario: Inicio de sesión exitoso
    Given url 'https://dummyjson.com/auth/login'
    And request { username: 'kminchelle', password: '0lelplR' }
    When method post
    Then status 200
    And match response.username == 'kminchelle'