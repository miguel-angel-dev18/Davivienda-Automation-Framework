Feature:Registro y verificación  del empleado en el directorio

  Scenario Outline: Flujo completo desde creación en PIM hasta búsqueda en Directorio
    Given el usuario ingresa a la plataforma OrangeHRM
    When ingresa el usuario "<usuario>" y la clave "<clave>"
    Then debería ver el dashboard para el usuario "<nombre_perfil>"
    And  El usuario selecciona "PIM" opcion del menu lateral
    Then El usuario agrega un empleado "<nombre>" "<segundo_nombre>" "<apellido>" "<codigo_empleado>"
    Then deberia ver el detalle perfil usuario registrado "<nombre>" "<segundo_nombre>" "<apellido>" "<codigo_empleado>"
    When el usuario sube la foto de perfil
    Then el usuario valida el exito del cargue de la foto
    And  El usuario selecciona "Directory" del menu lateral
    When El usuario busca un empleado "<nombre>" "<segundo_nombre>" "<apellido>"
    Then deberia ver al usuario "<nombre>" "<segundo_nombre>" "<apellido>" en el directorio

    Examples:
      | usuario | clave | nombre_perfil | nombre |segundo_nombre| apellido|codigo_empleado |
      | Admin   | admin123 |hello1 Test12name| test   |  software    | davivienda| 0012 |
