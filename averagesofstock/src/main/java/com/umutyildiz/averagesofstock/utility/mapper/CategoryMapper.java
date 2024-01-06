package com.umutyildiz.averagesofstock.utility.mapper;

import com.umutyildiz.averagesofstock.entity.Category;
import com.umutyildiz.averagesofstock.utility.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
//MapStruct doesn't work with lombok getter and setter
    CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "name", source = "category.name")
    CategoryDto entityToDto(Category category);
}
