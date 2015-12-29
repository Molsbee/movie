package org.molsbee.movie.config;

import org.molsbee.movie.security.config.SecurityConfig;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SecurityConfig.class, ApplicationConfig.class, DispatcherConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addFilter("openEntity", new OpenEntityManagerInViewFilter());

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST);
        servletContext.getFilterRegistration("openEntity").addMappingForServletNames(dispatcherTypes, false,
                servletContext.getServletRegistration("dispatcher").getName());

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        FilterRegistration.Dynamic filterChain = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        filterChain.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
    }

}
