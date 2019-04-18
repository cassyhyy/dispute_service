package com.srtp.dispute.domain.es;

import java.util.List;

/**
 * 根据关键词查询-入参
 */
public class KeywordQueryDTO {
    private List<String> keyword;
    private Integer page;
    private Integer limit;

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}


