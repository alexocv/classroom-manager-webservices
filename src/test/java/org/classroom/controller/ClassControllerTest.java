package org.classroom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.classroom.service.ClassService;
import org.classroom.service.dto.ClassesDTO;
import org.classroom.service.exceptions.ResourceNotFoundException;
import org.classroom.service.exceptions.handlers.ControllerErrorAdvice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ClassControllerTest {

    private MockMvc mvc;
    @Mock
    private ClassService service;
    @InjectMocks
    private ClassController controller;
    private JacksonTester<ClassesDTO> jsonClassesDto;

    @Before
    public void setup() {

        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ControllerErrorAdvice()).build();
    }

    @Test
    public void getByExistingID() throws Exception {
        given(service.read(12)).willReturn(new ClassesDTO(12L, "Math", "MatchClass", null));
        MockHttpServletResponse response = mvc.perform(get("/class/12").accept(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                .isEqualTo(jsonClassesDto.write(new ClassesDTO(12L, "Math", "MatchClass", null)).getJson());
    }

    @Test
    public void noResourceFound() throws Exception {

        willThrow(new ResourceNotFoundException("Class not found")).given(service).read(123);

        MockHttpServletResponse response = mvc.perform(get("/class/123").accept(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void getAllClasses() throws Exception {

        given(service.list()).willReturn(Collections.singletonList(new ClassesDTO(12L, "Math", "MatchClass", null)));
        MockHttpServletResponse response = mvc.perform(get("/class/").accept(MediaType.APPLICATION_JSON)).andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                .isEqualTo("[{\"id\":12,\"title\":\"Math\",\"description\":\"MatchClass\",\"students\":null}]");
    }

}
