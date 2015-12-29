package org.molsbee.movie.security;

import org.molsbee.movie.config.ApplicationConfig;
import org.molsbee.movie.security.config.SecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = { ApplicationConfig.class, SecurityConfig.class })
@WebAppConfiguration
@ActiveProfiles("local")
public class BasicAuthTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(springSecurityFilterChain)
                .build();
    }

    @Test
    public void movieResource_validCredentials() throws Exception {
        // act
        mvc.perform(get("/api/movie/title/{movieTitle}", "Halo")
                .with(httpBasic("william.molsbee", "testing")))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void homeResource_RedirectToLogin() throws Exception {
        // act
        mvc.perform(get("/"))
//                .with(httpBasic("william.molsbee", "testing")))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }


}
