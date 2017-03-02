package com.varun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by varun on ०२-०३-२०१७.
 */
@RestController
public class RestClientController {




    @RequestMapping(value = {"/friend"}, method = RequestMethod.GET, produces = {"application/json"})
    public Friend consumer(){

        RestTemplate restTemplate = new RestTemplate();
        Friend friend = restTemplate.getForObject("http://localhost:8087/",Friend.class);
        return friend;

    }
}
