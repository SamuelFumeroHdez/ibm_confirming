# IBM-Confirming

### Cómo ejecutar el programa
    Se ejecuta con el sigueinte comando: `java -jar ibm_confirming.jar [id_cliente]`. 
    Actualmente, en el código, la clase `Conexion` contiene la configuración para conectarse a la BBDD MySQL mediante JDBC. Probablemente será necesario cambiar los parámetros de dicha configuración para que pueda funcionar en la máquina de cada usuario.

### Generación del informe
    El informe generado en base a la consulta en BBDD se genera en la misma ubicación donde se ejecuta el programa.

### Dependencias
    Para este proyecto se ha incluido la dependencia de MySQL Connector para la conexión con la BBDD de MySQL en local
