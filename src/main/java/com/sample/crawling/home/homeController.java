package com.sample.crawling.home;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/call")
public class homeController {

    private final HomeService homeService;

    @PostMapping("/search")
    public Object search(@RequestBody @JsonSerialize Map<String,Object> params) throws IOException {
        return homeService.search(params);
    }
}
