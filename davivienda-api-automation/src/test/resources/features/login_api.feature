Feature: Autenticación en la API de OrangeHRM

  Scenario: Login exitoso mediante llamadas de red
    When intento autenticarme en la API con usuario "Admin" y clave "admin123"
    Then el código de respuesta debe ser 302
    And  consulto la lista de empleados con el filtro detallado
    Then validar que la lista de empleados cumpla con el esquema definido