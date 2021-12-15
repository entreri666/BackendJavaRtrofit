package HomeWork5;

import HomeWork5.Dto.Product;
import HomeWork5.Service.CategoryService;
import HomeWork5.Service.ProductService;
import HomeWork5.Utils.RetrofitUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;

public abstract class BaseTest {
    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }

}
