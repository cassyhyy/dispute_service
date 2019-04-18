package com.srtp.dispute.controller;

import com.srtp.dispute.domain.es.CaseInputDTO;
import com.srtp.dispute.domain.es.KeywordQueryDTO;
import com.srtp.dispute.domain.es.TitleQueryDTO;
import com.srtp.dispute.model.DisputeBean;
import com.srtp.dispute.model.DisputeRepository;
import com.srtp.dispute.model.Response;
import com.srtp.dispute.service.DisputeService;
import com.srtp.dispute.utils.CaseReader;
import com.srtp.dispute.utils.ResponseBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/es")
public class ElasticController {
    @Autowired
    private DisputeService disputeService;

    @Autowired
    @Qualifier("disputeRepository")
    private DisputeRepository disputeRepository;

     // 读取excel文件并插入到es中
    @RequestMapping("/readAndSave")
    @ResponseBody
    public void readAndSave(){
        CaseReader reader = new CaseReader();
        disputeService.insertList(reader.readDisputeExcel());
    }

    // 根据关键词查询
    @RequestMapping(value = "/searchByKeyword", method = RequestMethod.POST)
    public Response searchByKeyword(@RequestBody KeywordQueryDTO param){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 针对每个关键词添加查询
        List<String> word = param.getKeyword();
        for(String w: word) {
            queryBuilder.withQuery(QueryBuilders.multiMatchQuery(w, "district", "disputeName", "evaluation", "fierceDegree", "disputeDegree", "disputeOrigin", "disputeType", "disputeArea", "disputeLocation", "briefInfo", "disputeResolution", "institution", "staffName", "agreement", "disputeTag"));
        }
        // 分页
        int page = param.getPage();
        int limit = param.getLimit();
        queryBuilder.withPageable(PageRequest.of(page,limit));
        // 搜索，获取结果
        Page<DisputeBean> items = this.disputeRepository.search(queryBuilder.build());
        long total = items.getTotalElements();
        Map<String,Object> respMap = new HashMap<String,Object>(){{
            put("total", total);
            put("list", items.getContent());
        }};
        return ResponseBuilder.build(true, respMap);
    }

    // 通过案件名搜索
    @RequestMapping(value = "/searchByTitle", method = RequestMethod.POST)
    public Response searchByTitle(@RequestBody TitleQueryDTO param){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 获取入参-标题
        String title = param.getTitle();
        queryBuilder.withQuery(QueryBuilders.termQuery("disputeName", title));
        // 分页
        int page = param.getPage();
        int limit = param.getLimit();
        queryBuilder.withPageable(PageRequest.of(page,limit));
        // 搜索，获取结果
        Page<DisputeBean> items = this.disputeRepository.search(queryBuilder.build());
        System.out.println("标题搜索："+items.getContent());
        long total = items.getTotalElements();
        Map<String,Object> respMap = new HashMap<String,Object>(){{
            put("total", total);
            put("list", items.getContent());
        }};
        return ResponseBuilder.build(true, respMap);
    }

    // 录入案件
    @RequestMapping(value = "/inputCase", method = RequestMethod.POST)
    public Response inputCase(@RequestBody CaseInputDTO param){
//        this.disputeService.insert(new DisputeBean(param));
        return ResponseBuilder.build(true, null);
    }
}

