package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Filter[] getServletFilters(){
        EncodeHandleFilter encodeHandleFilter=new EncodeHandleFilter();
        encodeHandleFilter.setEncoding("UTF-8");
        encodeHandleFilter.setForceEncoding(true);
        return new Filter[]{encodeHandleFilter};
    };
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MyWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}