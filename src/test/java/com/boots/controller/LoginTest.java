package com.boots.controller;

import com.boots.Main;
import com.boots.entity.Post;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    IndexController controller;

    @Test
    @WithMockUser
    public void savePost() throws Exception {
        this.mockMvc.perform(post("/save")
                .param("name", "Post name")
                .param("description", "some text"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()); // почему тут не редирект ?????
        ArgumentCaptor<Post> argumentCaptor = ArgumentCaptor.forClass(Post.class);
        verify(controller).addPost(argumentCaptor.capture());
    }

    @Test
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

//    @Test
//    @Sql(value = {"/create-user-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    @Sql(value = {"/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//    public void correctLoginTest() throws Exception {
//        this.mockMvc.perform(formLogin().user("Sekator").password("1"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/index"));
//    }
    @Test
    @WithMockUser
    public void editPost() throws Exception {
        this.mockMvc.perform(post("/update")
                .param("name", "Post name")
                .param("description", "some text"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()); // почему тут не редирект ?????
        ArgumentCaptor<Post> argumentCaptor = ArgumentCaptor.forClass(Post.class);
        verify(controller).updatePost(argumentCaptor.capture());
    }
}
