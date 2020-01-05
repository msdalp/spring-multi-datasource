package io.msdalp;

import io.msdalp.dsone.Blog;
import io.msdalp.dsone.BlogRepository;
import io.msdalp.dstwo.Log;
import io.msdalp.dstwo.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    @Autowired

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        final LogRepository logRepository  = context.getBean(LogRepository.class);
        final Log log = new Log();
        log.setMessage("Test");
        logRepository.save(log);
        final BlogRepository blogRepository = context.getBean(BlogRepository.class);
        final Blog blog = new Blog();
        blog.setTitle("new article");
        blogRepository.save(blog);
    }
}