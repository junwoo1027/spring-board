package com.company.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVo {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;

}
