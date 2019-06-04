package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean<SiteMeshFilter> sitemeshFilterRegistrationBean() {
        FilterRegistrationBean<SiteMeshFilter> result = new FilterRegistrationBean(new SiteMeshFilter());
        result.setName("sitemeshFilter");
        result.addUrlPatterns("/*");
        result.setOrder(1);
        return result;
    }

    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecuteFilterFilterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> result = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());
        result.setName("strutsPrepareAndExecuteFilter");
        result.addUrlPatterns("/","/addUserForm.action","/addUser.action","/findUserForm.action","/findUser.action","/listAllUsers.action");
        result.setOrder(2);
        return result;
    }
}
