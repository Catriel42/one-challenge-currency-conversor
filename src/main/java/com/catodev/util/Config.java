package com.catodev.util;

import com.catodev.App;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    String apiKey;

    public String configApiKey(){
        try (
                InputStream input = App.class.getClassLoader().getResourceAsStream("config.properties")
        ) {

            Properties prop = new Properties();

            if (input == null) {
                System.err.println("Error: No se pudo encontrar el archivo 'config.properties' en el classpath.");
            }

            // Cargar el archivo de propiedades
            prop.load(input);

            // Obtener el valor de la propiedad 'api.key'
            apiKey = prop.getProperty("api.key");

        } catch (Exception e) {
            System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
        }

        return apiKey;
    }

}
