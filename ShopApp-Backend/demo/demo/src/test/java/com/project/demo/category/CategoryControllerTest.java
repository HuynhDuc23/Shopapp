package com.project.demo.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demo.dtos.requests.CategoryDTO;
import com.project.demo.models.Category;
import com.project.demo.services.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.ast.tree.expression.CaseSimpleExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc ;
    // tao gia 1 request len server

    @MockBean
    private ICategoryService categoryService ;
    // tao 1 mock object gia

    private CategoryDTO categoryDTORequest ;
    private com.project.demo.dtos.responses.CategoryDTO categoryDTOResponse ;
    private Category category;
    @BeforeEach
    public void initData() {
        categoryDTORequest = new CategoryDTO().builder()
                .name("Sport4").build();
        categoryDTOResponse = new com.project.demo.dtos.responses.CategoryDTO().builder().category("Sport4").build();

        category = new Category().builder().name("Sport4").build();
    }
    @Test
    public void createCategoryTest() throws Exception {
        // GIVEN
        ObjectMapper objectMapper = new ObjectMapper() ;
        String content = objectMapper.writeValueAsString(categoryDTORequest);
        // Mockito
        Mockito.when(categoryService.createCategory(ArgumentMatchers.any())).thenReturn(category);
        // WHEn
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api/v1/categories/post")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Sport4"));
    }
}
