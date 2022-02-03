package helpers;

import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());
    static String user = mobileConfig.user();
    static String key = mobileConfig.key();

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(user, key)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
