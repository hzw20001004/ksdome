package com.Ks.common.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger 配置文件
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Value("${spring.swagger}")
    private boolean enable;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ks.Controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot")
                        .description("SpringBoot H")
                        .version("1.0")
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


