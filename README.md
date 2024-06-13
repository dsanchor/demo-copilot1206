# API HelloWorld

La API HelloWorld proporciona operaciones para interactuar con textos, permitiendo obtener un saludo, invertir un texto y eliminar las vocales de un texto.

## Endpoints

### Saludo

- **URL**: `/hello`
- **Método**: `GET`
- **Descripción**: Devuelve un saludo simple.
- **Ejemplo de solicitud**:
  ```bash
  curl -X GET http://localhost:8080/hello
  ```
- **Respuesta**:
  ```
  Hello World
  ```

### Invertir Texto

- **URL**: `/reverse`
- **Método**: `GET`
- **Parámetros**:
  - **input** (requerido): Texto a invertir.
- **Descripción**: Invierte el texto proporcionado.
- **Ejemplo de solicitud**:
  ```bash
  curl -X GET 'http://localhost:8080/reverse?input=example'
  ```
- **Respuesta**:
  ```
  elpmaxe
  ```

### Eliminar Vocales

- **URL**: `/noVowels`
- **Método**: `GET`
- **Parámetros**:
  - **input** (requerido): Texto del cual eliminar las vocales.
- **Descripción**: Elimina todas las vocales del texto proporcionado.
- **Ejemplo de solicitud**:
  ```bash
  curl -X GET 'http://localhost:8080/noVowels?input=example'
  ```
- **Respuesta**:
  ```
  xmpl
  ```
## Containarización

### Generación de la imagen

Para generar la imagen de la API HelloWorld, se debe ejecutar el siguiente comando:

```bash
docker build -t helloworld-api .
```

### Ejecución del contenedor

Para ejecutar el contenedor de la API HelloWorld, se debe ejecutar el siguiente comando:

```bash
docker run -d -p 8080:8080 helloworld-api
```