package com.web.service;

import java.util.HashMap;
import java.util.Map;


public class RegisterService {
    public Map<String,Object> getData(){
        Map<String,Object> map = new HashMap<>();
        map.put("header",new HeaderService().getHeaderData());
        map.put("footer",new FooterService().getFooterData());
        return map;
    }
}
