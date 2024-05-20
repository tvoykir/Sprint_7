import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class CreateCourierTests extends BaseCourierTests {

    @Test
    @DisplayName("Проверка создания курьера")
    @Description("Проверка создания нового курьера")
    public void createCourier() {
        createCourier(LOGIN, PASSWORD, FIRST_NAME)
                .then()
                .statusCode(201);
    }

    @Test
    @DisplayName("Попытка создания существующего курьера")
    @Description("Попытка создания курьера с уже существующим логином")
    public void doubleLoginCourier() {
        createCourier(LOGIN, PASSWORD, FIRST_NAME)
                .then()
                .statusCode(201);
        createCourier(LOGIN, PASSWORD, FIRST_NAME)
                .then()
                .statusCode(409);
    }

    @Test
    @DisplayName("Попытка создания курьера без \"login\"")
    @Description("Попытка создания курьера без обязательного поля \"login\"")
    public void courierWithoutLogin() {
        createCourier(null, PASSWORD, FIRST_NAME)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Попытка создания курьера без \"password\"")
    @Description("Попытка создания курьера без обязательного поля \"password\"")
    public void createCourierWithoutPassword() {
        createCourier(LOGIN, null, FIRST_NAME)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("Попытка создания курьера без \"firstName\"")
    @Description("Попытка создания курьера без поля \"firstName\"")
    public void createCourierWithoutFirstName() {
        createCourier(LOGIN, PASSWORD, null)
                .then()
                .statusCode(201);
    }
}