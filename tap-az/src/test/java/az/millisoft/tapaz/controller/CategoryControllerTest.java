package az.millisoft.tapaz.controller;

import az.millisoft.tapaz.entity.Category;
import az.millisoft.tapaz.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    CategoryController controller;

    @Mock
    CategoryService categoryService;

    @Test
    void getAll() {
        List<Category> categories =
                List.of(
                        new Category(1,"NAME1"),
                        new Category(2,"NAME2"),
                        new Category(3,"NAME3"),
                        new Category(4,"NAME4")
                        );

        when(categoryService.getAll()).thenReturn(categories);

        ResponseEntity<List<Category>> response = controller.getAll();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(categories,response.getBody());
    }
}