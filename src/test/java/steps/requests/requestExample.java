package steps.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import utils.Config;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;


    public class requestExample {
        Config config = new Config();
        private static Map<String, String> jsonData = new HashMap<String, String>();

        @Step("Escrever aqui o pressuposto do step ")
        public void requestExample(String source) {

            RequestSpecBuilder resBuilder = new RequestSpecBuilder()
                    .setBaseUri(config.getPropertyValue("/api/login")) //ENDPOINT
                    .setBasePath("/value/door/validation")
                    .addHeader("Source", source)
                    .addHeader("Content-Type","application/json");
            RequestSpecification reqSpec = resBuilder.build();

            jsonData.put("type_id", "valueType");
            jsonData.put("value_secret", "123456789");
            jsonData.put("type_validation", "validationType");
            jsonData.put("email", "manuela.sousa@gmail.com");
            jsonData.put("password","manuelasousa100");


            Response response =
                    given().
                            spec(reqSpec).
                            log().all().
                            when().
                            body(jsonData).
                            post().
                            then().
                            log().all().
                            statusCode(200).
                            extract().response();

        }
}
