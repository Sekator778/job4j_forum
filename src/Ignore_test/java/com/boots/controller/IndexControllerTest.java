package com.boots.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.boots.Main;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IndexControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageAddPage() throws Exception {
        this.mockMvc.perform(get("/addPost"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("addPost"));
    }

    @Test
    @WithAnonymousUser
    public void shouldErrorPageMessageAddPage() throws Exception {
        this.mockMvc.perform(get("/addPost"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }
}