package com.srtp.dispute.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 接口关系：
 * ElasticsearchRepository --> ElasticsearchCrudRepository --> PagingAndSortingRepository --> CrudRepository
 */
public interface DisputeRepository extends ElasticsearchRepository<DisputeBean, String> {
    Page<DisputeBean> findByDisputeName(String disputeName, Pageable pageable);
}
