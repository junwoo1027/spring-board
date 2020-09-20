package com.company.service;

import com.company.domain.Criteria;
import com.company.domain.ReplyVo;

import java.util.List;

public interface ReplyService {

    public int register(ReplyVo reply);

    public ReplyVo get(int rno);

    public int modify(ReplyVo reply);

    public int remove(int rno);

    public List<ReplyVo> getList(Criteria cri, int bno);
}
