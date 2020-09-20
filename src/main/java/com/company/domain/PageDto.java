package com.company.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDto {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total;
    private Criteria cri;

    public PageDto(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;

        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;

        this.startPage = (this.endPage - 10) + 1;

        int realEnd = (int)(Math.ceil((total * 1.0) / cri.getPageNum()));

        if(realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;

        this.next= this.endPage < realEnd;
    }
}