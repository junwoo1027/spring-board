package com.company.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

    private int page;
    private int perPageNum;

    public Criteria(int page, int perPageNum) {
        this.page = page;
        this.perPageNum = perPageNum;
    }

    public Criteria() {
        this(1, 10);
    }

    public int getPageStart() {
        return (this.page -1)*perPageNum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        }else {
            this.page = page;
        }
    }

    public int getPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int perPageNum) {
        this.perPageNum = perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", perPageNum=" + perPageNum +
                '}';
    }
}
