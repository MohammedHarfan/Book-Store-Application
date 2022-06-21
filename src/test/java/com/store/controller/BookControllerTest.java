package com.store.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.model.Book;
import com.store.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookController bookController;

    @Autowired
    private BookService bookService;

    @Test
    public void saveBooks() throws Exception {
        Book book = new Book(1L,"Lies of truth", "simple book", "van der sar", 1.00, LocalDateTime.now());

        String jsonString = objectMapper.writeValueAsString(book);
        mvc.perform(post("/book")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                        .andExpect(status().isCreated())
                        .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void getAllBooks() throws Exception {
        mvc.perform(get("/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteBooks() throws Exception {
        String jsonString = "11";
        mvc.perform(delete("/book/delete/11")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
    }
}