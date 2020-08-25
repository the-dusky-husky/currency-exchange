package com.cal.CurrencyExchangeService;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhisheks on 24-07-2020.
 */
@RestController
public class RequestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment environment;

    @GetMapping(value = "convert")
    public Map<String, String> convert(@RequestParam String currency){

        String port = environment.getProperty("local.server.port");
        int rate =0;
        if (currency.equalsIgnoreCase("dollar"))
            rate=75;
        else if(currency.equalsIgnoreCase("euro"))
            rate= 90;
        else if (currency.equalsIgnoreCase("yen"))
            rate=10;

        Map<String, String> map = new HashMap<>();
        map.put("rate",String.valueOf(rate));
        map.put("port",port);
        logger.info("currency exchange :"+map);
        return map;
    }
}
