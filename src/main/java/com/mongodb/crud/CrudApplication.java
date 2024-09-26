package com.mongodb.crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mongodb.crud.constant.SwaggerConstant.CONTACT_NAME;
import static com.mongodb.crud.constant.SwaggerConstant.CONTACT_URL;
import static com.mongodb.crud.constant.SwaggerConstant.DESCRIPTION;
import static com.mongodb.crud.constant.SwaggerConstant.TITLE;
import static com.mongodb.crud.constant.SwaggerConstant.VERSION;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@OpenAPIDefinition(info = @Info(title = TITLE, version = VERSION, description = DESCRIPTION,
        contact = @Contact(name = CONTACT_NAME, url = CONTACT_URL)
))
public class CrudApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

}
