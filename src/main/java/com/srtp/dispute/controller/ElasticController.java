package com.srtp.dispute.controller;

import com.srtp.dispute.model.DisputeBean;
import com.srtp.dispute.model.DisputeRepository;
import com.srtp.dispute.service.DisputeService;
import com.srtp.dispute.utils.CaseReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class ElasticController {
    @Autowired
    private DisputeService disputeService;

    @Autowired
    @Qualifier("disputeRepository")
    private DisputeRepository disputeRepository;

    @RequestMapping("/es/readAndSave")
    @ResponseBody
    public void readAndSave(){
        CaseReader reader = new CaseReader();
        disputeService.insertList(reader.readDisputeExcel());
    }

    @RequestMapping("/es/findByDisputeName")
    @ResponseBody
    public void findByDisputeName(){
        Pageable pageable =new PageRequest(0, 5);
        System.out.println(disputeRepository.findByDisputeName("周颖与任红润", pageable));
    }
}

