package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("control")
@ComponentScan("service")
@ComponentScan("dao")
public class MyWebConfig extends WebMvcConfigurerAdapter {
/*    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }*/
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginStateInterceptor());
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
        //registry.enableContentNegotiation(new MappingJackson2JsonView());
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/home").setViewName("main");
        super.addViewControllers(registry);
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();//对静态资源的请求转发到容器缺省的servlet,而不使用 DispatcherServlet
    }

}
