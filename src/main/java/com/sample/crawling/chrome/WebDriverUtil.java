package com.sample.crawling.chrome;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Configuration
public class WebDriverUtil {
    public static WebDriver webDriver;
    private final String CHROMEDRIVER_EXE = "lib/chromedriver.exe";//다운받은 크롬드라이버 위치
    private ChromeDriverService chromeDriverService;

    @Bean
    public WebDriver getWebDriver(){
        if(webDriver == null){
            try {
                chromeDriverService = new ChromeDriverService.Builder().usingDriverExecutable(new File(CHROMEDRIVER_EXE)).usingAnyFreePort().build();
                chromeDriverService.start();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("headless");//브라우저 창을 띄우지 않는 옵션
                this.webDriver = new ChromeDriver(chromeDriverService, chromeOptions);
            } catch (Exception e){
                log.info(e.getMessage(),e);
                chromeDriverService.stop();
                webDriver.close();
            }
        }
        return webDriver;
    }

}
