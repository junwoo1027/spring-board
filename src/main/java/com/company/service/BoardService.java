package com.company.service;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVo board);

    public BoardVo get(int bno);

    public boolean modify(BoardVo board);

    public boolean remove(int bno);

    public List<BoardVo> getList();

    public List<BoardVo> listPage(Criteria cri);

    public int getTotal(Criteria cri);

}
