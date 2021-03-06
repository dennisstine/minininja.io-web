package io.minininja.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import io.minininja.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * IndexController tests.
 *
 * Created by Dennis on 4/14/2017.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IndexControllerTest {

    @InjectMocks
    private IndexController controller;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");

        mvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(resolver).build();
    }

    @Test
    public void index() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("fragmentInclude", "fragments/home"))
                .andExpect(forwardedUrl("/index.html"));
    }
}
