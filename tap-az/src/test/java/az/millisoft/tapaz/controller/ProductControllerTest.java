package az.millisoft.tapaz.controller;

import az.millisoft.tapaz.entity.Category;
import az.millisoft.tapaz.entity.Product;
import az.millisoft.tapaz.exception.ProductNotFound;
import az.millisoft.tapaz.exception.UserNotFound;
import az.millisoft.tapaz.service.ProductService;
import io.jsonwebtoken.JwsHeader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController controller;

    @Mock
    ProductService service;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        Integer ID = Integer.MIN_VALUE;
        Double PRICE = Double.MAX_VALUE;
        String NAME = "NAME1";
        Integer CATEGORY_ID = Integer.MIN_VALUE;
        String DESCRIPTION = "description1";
        LocalDate ADDED_DATE = LocalDate.now();

        Product product =
                Product.builder()
                        .id(ID)
                        .price(PRICE)
                        .name(NAME)
                        .category(new Category(CATEGORY_ID,null))
                        .description(DESCRIPTION)
                        .addedDate(ADDED_DATE)
                        .build();

        when(service.getById(ID)).thenReturn(product);

        ResponseEntity<Product> response = controller.getById(ID);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(product,response.getBody());

    }

    @Test
    void getById_WILL_THROW_NOT_FOUND_EXCEPTION(){

        Integer ID = Integer.MAX_VALUE;

        doThrow(ProductNotFound.class).when(service).getById(ID);

        assertThrows(ProductNotFound.class,() -> controller.getById(ID));

    }

    @Test
    void add() {
    }
}