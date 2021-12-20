package HomeWork6;


import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoryTest extends BaseTest {

    @Test
    void getCategoryByIdTest() throws IOException {
        Integer id = HomeWork6.enums.CategoryType.FOOD.getId();
        Response<HomeWork6.dto.Category> response = categoryService
                .getCategory(id)
                .execute();
        assertThat(response.body().getTitle(), equalTo(HomeWork6.enums.CategoryType.FOOD.getTitle()));
        assertThat(response.body().getId(), equalTo(id));
    }
}
