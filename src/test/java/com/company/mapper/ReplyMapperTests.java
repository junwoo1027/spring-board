package com.company.mapper;

import com.company.domain.Criteria;
import com.company.domain.ReplyVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {

    private int[] bnoArr = {112, 111, 110, 109, 108};

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Test
    public void testMapper() {
        log.info(mapper);
    }


    @Test
    public void testCreate() {
        IntStream.rangeClosed(1, 10).forEach(i -> {

            ReplyVo reply = new ReplyVo();

            reply.setBno(bnoArr[i%5]);
            reply.setReply("test" + i);
            reply.setReplyer("replyer" + i);

            mapper.insert(reply);
        });
    }

    @Test
    public void testRead() {

        int tRno = 2;

        ReplyVo reply = mapper.read(tRno);

        log.info(reply);
    }

    @Test
    public void testDelete() {
        int tRno = 1;
        mapper.delete(tRno);
    }

    @Test
    public void testUpdate() {
        int rno = 2;

        ReplyVo reply = mapper.read(rno);

        reply.setReply("update reply");

        int count = mapper.update(reply);

        log.info("update count: " + count);
    }

    @Test
    public void testList() {
        Criteria cri = new Criteria();

        List<ReplyVo> replies = mapper.getListWithPaging(cri, bnoArr[2]);

        replies.forEach(reply -> log.info(reply));
    }
}
