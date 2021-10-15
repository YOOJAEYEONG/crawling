package com.sample.crawling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@SpringBootTest
class CrawlingApplicationTests {

    @BeforeTestClass
    public void setBefore(){
        System.out.println("==Before==");
    }

    @Test
    void contextLoads() {
        System.out.println("==testClass==");
    }

}
