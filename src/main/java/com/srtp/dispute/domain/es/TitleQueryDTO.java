package com.srtp.dispute.domain.es;

/**
 * 通过案件名搜索-入参
 */
public class TitleQueryDTO {
    private String title;
    private Integer page;
    private Integer limit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
