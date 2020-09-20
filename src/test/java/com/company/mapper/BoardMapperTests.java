package com.company.mapper;

import com.company.domain.BoardVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

//    @Test
//    public void testGetList() {
//        boardMapper.getList().forEach(board -> log.info(board));
//    }

//    @Test
//    public void testInsert() {
//
//        BoardVo board = new BoardVo();
//        board.setTitle("새글");
//        board.setContent("new content");
//        board.setWriter("ohoh");
//
//        boardMapper.insert(board);
//
//        log.info(board);
//
//    }

//    @Test
//    public void testRead() {
//
//        BoardVo boardVo = boardMapper.read(6);
//        log.info(boardVo);
//    }

//    @Test
//    public void testDelete() {
//        log.info("delete count :" + boardMapper.delete(1));
//    }

    @Test
    public void testUpdate() {
        BoardVo boardVo = new BoardVo();
        boardVo.setBno(6);
        boardVo.setTitle("update title");
        boardVo.setContent("update content");
        boardVo.setWriter("update writer");

        int count = boardMapper.update(boardVo);

        log.info(count);
    }
}
