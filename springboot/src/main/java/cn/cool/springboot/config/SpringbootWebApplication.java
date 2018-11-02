package cn.cool.springboot.config;

import cn.cool.springboot.controller.ListenerTest;
import cn.cool.springboot.controller.ServletTest;
import cn.cool.springboot.controller.TimeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

public class SpringbootWebApplication<mian> implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //配置Servlet
        servletContext.addServlet("servletTest", new ServletTest()).addMapping("/servletTest");
        //配置过滤器
        servletContext.addFilter("timeFilter", new TimeFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        //配置监听器
        servletContext.addListener(new ListenerTest());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }
}
