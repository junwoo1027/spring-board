package com.company.service;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.config.RootConfig.class})
@Log4j
public class BoardServiceTests {

    @Setter(onMethod_ = @Autowired)
    private BoardService service;

//    @Test
//    public void testExist() {
//        log.info(service);
//        assertNotNull(service);
//    }

    @Test
    public void testRegister() {

        BoardVo board = new BoardVo();
        board.setTitle("제제목목");
        board.setContent("conconc");
        board.setWriter("wriwri");

        service.register(board);

        log.info("new board bno : " + board.getBno());
    }

    @Test
    public void testGetList() {

        service.getList().forEach(boardVo -> log.info(boardVo));
    }

    @Test
    public void testGet() {

        log.info(service.get(6));
    }

    @Test
    public void testUpdate() {

        BoardVo boardVo = service.get(6);

        if(boardVo == null) {
            return;
        }

        boardVo.setTitle("title updateddㅌ");
        boardVo.setContent("content updateddㅌㅌㅌ");

        log.info("result : " + service.modify(boardVo));
    }

    @Test
    public void testDelete() {
        log.info("result : " + service.remove(7));
    }

    @Test
    public void listPageTest() throws Exception {
        Criteria cri = new Criteria();
        cri.setPage(1);
        cri.setPerPageNum(10);
        //List<BoardVo> boards = service.listPage(cri);
        service.listPage(cri).forEach(boardVo -> log.info(boardVo));

    }
}
