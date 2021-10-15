package com.sample.crawling.home;


import java.io.IOException;
import java.util.Map;
import java.util.Set;

public interface HomeService {

    /**
     * 검색서비스
     * @param params
     */
    public Object search(Map<String,Object> params) throws IOException;
}
