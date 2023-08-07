package az.millisoft.tapaz.controller;

import az.millisoft.tapaz.dto.ProductPageResponse;
import az.millisoft.tapaz.dto.ProductRequest;
import az.millisoft.tapaz.entity.Product;
import az.millisoft.tapaz.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ProductPageResponse getAll(@RequestParam("page") Integer page,
                                      @RequestParam("count") Integer count) {

        return service.getAll(page, count);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/category/{categoryId}")
    public ProductPageResponse getAll(
            @PathVariable("categoryId") Integer categoryId,
            @RequestParam("page") Integer page,
            @RequestParam("count") Integer count) {

        return service.getByCategoryId(categoryId,page, count);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid ProductRequest productRequest) {
        service.save(productRequest);
    }

}
