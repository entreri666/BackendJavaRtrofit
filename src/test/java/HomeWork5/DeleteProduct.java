package HomeWork5;

import HomeWork5.Dto.Product;
import HomeWork5.Enums.CategoryType;
import HomeWork5.Utils.PrettyLogger;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeleteProduct extends BaseTest {
    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().fruit())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());
    }

    void getProductsTest() throws IOException {
        Response<ArrayList<Product>> response = productService.getProducts().execute();
        PrettyLogger.DEFAULT.log(response.body().toString());

    }

    @Test
    void deleteProductTest() throws IOException {
            Response<ResponseBody> response = productService.deleteProduct(productId).execute();
            assertThat(response.isSuccessful(), is(true));
    }
}
