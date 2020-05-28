package com.ecommerceApp.ecommerceApp.services;

import com.ecommerceApp.ecommerceApp.Repositories.CategoryMetadataFieldRepository;
import com.ecommerceApp.ecommerceApp.Repositories.CategoryRepository;
import com.ecommerceApp.ecommerceApp.dtos.BaseDto;
import com.ecommerceApp.ecommerceApp.dtos.categorydtos.CategoryMetadataFieldDto;
import com.ecommerceApp.ecommerceApp.entities.category.CategoryMetadataField;
import com.ecommerceApp.ecommerceApp.entities.category.CategoryMetadataFieldValues;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMetaDataFieldService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryMetadataFieldRepository categoryFieldRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryRepository categoryRepository;

    CategoryMetadataField toCategoryMetadataField(CategoryMetadataFieldDto categoryMetadataFieldDto) {
        if (categoryMetadataFieldDto == null)
            return null;
        return modelMapper.map(categoryMetadataFieldDto, CategoryMetadataField.class);
    }

    public CategoryMetadataFieldDto toCategoryMetadataFieldDto(CategoryMetadataField field) {
        if (field == null)
            return null;
        return modelMapper.map(field, CategoryMetadataFieldDto.class);
    }

    public ResponseEntity addNewMetadataField(String fieldName) {
        CategoryMetadataField metafield = categoryFieldRepository.findByName(fieldName);

        if (metafield != null) {
            return new ResponseEntity("Invalid Entry, Field Already Exists", HttpStatus.CONFLICT);
        }
        else if(fieldName==null)
            return new ResponseEntity("FieldName cannot be null",HttpStatus.BAD_REQUEST);

        metafield = new CategoryMetadataField();
        metafield.setName(fieldName);
        categoryFieldRepository.save(metafield);
        return new ResponseEntity("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List> getAllMetadataFields(String offset, String size, String sortByField, String order, Long categoryId) {

        Integer pageNo = Integer.parseInt(offset);
        Integer pageSize = Integer.parseInt(size);
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortByField).ascending());


        List<CategoryMetadataField> fields = categoryFieldRepository.findAll(pageable);
        List<CategoryMetadataFieldDto> responseData = new ArrayList<>();

        fields.forEach((field) -> {
            CategoryMetadataFieldDto categoryMetadataFieldDto = toCategoryMetadataFieldDto(field);
            categoryMetadataFieldDto.setValues(null);
            responseData.add(categoryMetadataFieldDto);
        });
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }



}
