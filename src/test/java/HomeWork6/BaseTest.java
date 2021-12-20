package HomeWork6;

import HomeWork6.db.dao.ProductsMapper;
import HomeWork6.dto.Product;
import HomeWork6.servise.CategoryService;
import HomeWork6.servise.ProductService;
import HomeWork6.utils.DbUtils;
import HomeWork6.utils.RetrofitUtils;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import retrofit2.Retrofit;

public abstract class BaseTest {
    int productId;
    static ProductsMapper productsMapper;
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
        productsMapper = DbUtils.getProductsMapper();
    }

}
