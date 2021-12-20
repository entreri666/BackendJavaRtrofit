package HomeWork6;

import HomeWork6.dto.Product;
import HomeWork6.enums.CategoryType;
import HomeWork6.utils.DbUtils;
import HomeWork6.utils.PrettyLogger;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DeleteProduct extends BaseTest {

    @BeforeEach
    void setUp() throws IOException {
        product = new Product()
                .withTitle(faker.food().fruit())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());

        Integer countProductsBefore = DbUtils.countProducts(productsMapper);
        Response<Product> response = productService.createProduct(product).execute();
        Integer countProductsAfter = DbUtils.countProducts(productsMapper);
        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
        assertThat(response.body().getCategoryTitle(), equalTo(product.getCategoryTitle()));
        productId = response.body().getId();

    }

    @Test
    void deleteProductTest() throws IOException {
        Response<ResponseBody> response = productService.deleteProduct(productId).execute();
        assertThat(response.isSuccessful(), is(true));
    }
}
