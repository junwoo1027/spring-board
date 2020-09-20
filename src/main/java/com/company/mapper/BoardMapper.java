package com.company.mapper;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {

    //@Select("select * from board where bno > 0")
    public List<BoardVo> getList();

    public void insert(BoardVo board);

    public BoardVo read(int bno);

    public int delete(int bno);

    public int update(BoardVo board);

    public List<BoardVo> getListWithPaging(Criteria cri);

    public int getTotalCount(Criteria cri);
}
