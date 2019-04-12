package com.srtp.dispute.service;

import com.srtp.dispute.model.DisputeBean;
import com.srtp.dispute.model.DisputeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("disputeService")
public class DisputeService{
    @Autowired
    @Qualifier("disputeRepository")
    private DisputeRepository disputeRepository;

    public void insertList(List<DisputeBean> list) {
        disputeRepository.saveAll(list);
    }
}

