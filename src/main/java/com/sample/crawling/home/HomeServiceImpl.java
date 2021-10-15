package com.sample.crawling.home;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService{

    final WebDriver webDriver;
    WebElement webElement;


    @Override
    public Map<String,Object> search(Map<String,Object> params) throws IOException {
        Map<String,Object> map = new HashMap();
        ArrayList<Map<String,String>> arrayList = new ArrayList<>();
        try{
            log.info("search service_{}",params);
            webDriver.get((String) params.get("url"));
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.findElement(By.id("search_query")).click(); //마우스 클릭과 같음
            webDriver.findElement(By.id("search_query")).clear(); //클릭 후 비우기
            webDriver.findElement(By.id("search_query")).sendKeys((String) params.get("searchWords"));
            webDriver.findElement(By.id("search_query")).sendKeys(Keys.ENTER);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> list = webDriver.findElements(By.tagName("img"));
            log.info("list==>{}",list);
            list.forEach(webElement->{
                Map<String,String> elementMap = new HashMap<>();
                elementMap.put("tagName",webElement.getTagName());
                elementMap.put("attribute-src",webElement.getAttribute("src"));
                elementMap.put("attribute-width",webElement.getAttribute("width"));
                elementMap.put("attribute-height",webElement.getAttribute("height"));
                elementMap.put("attribute-alt",webElement.getAttribute("alt"));
                log.info("element {}",elementMap);
                arrayList.add(elementMap);
            });
            map.put("list",arrayList);
//            map.put("pageSource",webDriver.getPageSource());
        }catch (Exception e){
            log.info(e.getMessage(),e);
        }
//            WebElement webElement = driver.findElement(By.tagName("body"));
//            Actions actions = new Actions(driver);
//            actions.moveToElement(webElement, 0, 0).perform();
        return map;
    }
}
