package az.millisoft.tapaz.dto;

import az.millisoft.tapaz.entity.Category;
import az.millisoft.tapaz.repository.CategoryRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest (

        @NotBlank
        String name,

        @NotBlank
        String description,
        Double price,

        @NotNull
        CategoryRequest category
){
}
