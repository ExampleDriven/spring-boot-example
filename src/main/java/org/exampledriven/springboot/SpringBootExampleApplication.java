package org.exampledriven.springboot;

import org.crsh.plugin.PluginContext;
import org.crsh.plugin.WebPluginLifeCycle;
import org.crsh.web.servlet.CRaSHConnector;
import org.crsh.web.servlet.WebPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

@SpringBootApplication
@EnableWebMvc
@Configuration
@ServletComponentScan(basePackageClasses = {CRaSHConnector.class, WebPluginLifeCycle.class, SpringBootExampleApplication.CrashWebPluginLifeCycle.class})
public class SpringBootExampleApplication extends WebMvcAutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

    @Bean
    public CRaSHConnector cRaSHConnector() {
        return new CRaSHConnector();
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public CrashWebPluginLifeCycle webPluginLifeCycle() {
        return new CrashWebPluginLifeCycle();
    }

//    @WebListener
    public class CrashWebPluginLifeCycle implements ServletContextInitializer {

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {

            WebPluginLifeCycle webPluginLifeCycle = new WebPluginLifeCycle();
            webPluginLifeCycle.contextInitialized(new ServletContextAttributeEvent(servletContext, "", ""));

            PluginContext context = WebPluginLifeCycle.getPluginContext("");
            if (context != null) {
                context.setProperty(WebPlugin.ENABLED, true);
            }

        }

    }

}
