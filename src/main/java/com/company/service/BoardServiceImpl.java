package com.company.service;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardMapper mapper;

    @Override
    public void register(BoardVo board) {
        log.info("register " + board);

        mapper.insert(board);
    }

    @Override
    public BoardVo get(int bno) {

        log.info("get : " + bno);

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVo board) {

        log.info("modify : " + board);

        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(int bno) {

        log.info("delete : " + bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVo> getList() {

        log.info("getList.....");;

        return mapper.getList();
    }

    @Override
    public List<BoardVo> listPage(Criteria cri) {
        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        return mapper.getTotalCount(cri);
    }
}
