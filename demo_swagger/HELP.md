Springboot2.6.0不兼容swagger3.0.0问题

1.springboot版本

<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.6.0</version>
</parent>
2.springfox版本 

      <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-boot-starter</artifactId>
        <version>3.0.0</version>
      </dependency>

原因分析：

spring5支持PathMatchConfigurer导致

启动报错解决方案1：

重写

springfox.documentation.spring.web.WebMvcPatternsRequestConditionWrapper

springfox.documentation.spring.web.WebMvcRequestHandler
