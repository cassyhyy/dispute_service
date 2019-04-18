package com.srtp.dispute.controller;

import com.srtp.dispute.domain.text.KeywordInContentDTO;
import com.srtp.dispute.model.Constants;
import com.srtp.dispute.model.Response;
import com.srtp.dispute.utils.ResponseBuilder;
import com.srtp.dispute.utils.textProcessor;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value = "/text")
public class TextController {
    // 关键词获取
    @RequestMapping(value = "/getKeyword", method = RequestMethod.POST)
    public Response getKeyword(@RequestBody KeywordInContentDTO param){
        String content = param.getContent();
        List<String> keyword = textProcessor.getKeyword(content, 10);

        return ResponseBuilder.build(true, keyword);
    }
}

