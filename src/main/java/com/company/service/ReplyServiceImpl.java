package com.company.service;

import com.company.domain.Criteria;
import com.company.domain.ReplyVo;
import com.company.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Override
    public int register(ReplyVo reply) {
        log.info("register: " + reply);

        return mapper.insert(reply);
    }

    @Override
    public ReplyVo get(int rno) {
        return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVo reply) {
        return mapper.update(reply);
    }

    @Override
    public int remove(int rno) {
        return mapper.delete(rno);
    }

    @Override
    public List<ReplyVo> getList(Criteria cri, int bno) {
        return mapper.getListWithPaging(cri, bno);
    }
}
