import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class ListOrdersTests extends BaseTest {

    @Test
    @DisplayName("Проверка списка заказов")
    @Description("Проверка списка заказов курьера")
    public void getListOrders() {
        Response response = getOrders();
        response.then().assertThat()
                .body("orders", notNullValue())
                .and().body("orders.size()", greaterThan(0))
                .and().statusCode(200);
    }
}
