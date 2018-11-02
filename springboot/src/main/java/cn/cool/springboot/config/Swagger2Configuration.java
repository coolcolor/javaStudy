package cn.cool.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket accessToken() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")   //定义组
                .select()   //选择那些路径和 api 会生成 document
                .apis(RequestHandlerSelectors.basePackage("cn.cool.springboot.controller"))  //拦截路径
                .paths(PathSelectors.regex("/*/.*"))  //拦截的接口路径
                .build()  //创建
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot之web")
                .description("内容描述")
                .termsOfServiceUrl("https://www.baidu.com")
                .contact(new Contact("Cool", "www.baidu.com", "156449189@qq.com"))
                .version("1.0")
                .build();
    }
}
