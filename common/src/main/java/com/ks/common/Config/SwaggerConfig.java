package com.ks.common.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger 配置文件
 */

//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ks.Controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("KS")
//                .description("ks")
//                .build();
//    }
// implements WebMvcConfigurer {@Override
//public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("**/swagger-ui.html")
//            .addResourceLocations("classpath:/META-INF/resources/");
//    registry.addResourceHandler("/webjars*")
//            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//}



@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ks.Controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot整合Swagger")
                        .description("SpringBoot整合Swagger，详细信息......")
                        .version("9.0")
                        .contact(new Contact("啊啊啊啊","blog.csdn.net","aaa@gmail.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build());
    }
}
    /**
     * Rest风格用户的增删改查接口
     * Swagger2 注解整理
     * ====================================================
     * Api：修饰整个类，描述Controller的作用
     * ApiOperation：描述一个类的一个方法，或者说一个接口
     * ApiParam：单个参数描述
     * ApiModel：用对象来接收参数
     * ApiProperty：用对象接收参数时，描述对象的一个字段
     * ApiResponse：HTTP响应其中1个描述
     * ApiResponses：HTTP响应整体描述
     * ApiIgnore：使用该注解忽略这个API
     * ApiError ：发生错误返回的信息
     * ApiImplicitParam：一个请求参数
     * ApiImplicitParams：多个请求参数
     * ====================================================
     */

