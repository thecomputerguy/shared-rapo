package com.varun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by varun on ०२-०३-२०१७.
 */
@RestController
public class MyFirstMicroservice {

    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    @ResponseBody
    public Friend giveMeSome(){
        Friend fr = new Friend();
        fr.setName("sumit0000");
        fr.setAge(25);
        return fr;
    }
}
