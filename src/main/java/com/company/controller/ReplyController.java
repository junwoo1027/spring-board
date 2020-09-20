package com.company.controller;

import com.company.domain.Criteria;
import com.company.domain.ReplyVo;
import com.company.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/replies")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    private ReplyService service;

    @PostMapping(value = "/new", consumes = "application/json",
    produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVo reply) {
        int insertCount = service.register(reply);

        return insertCount == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/pages/{bno}/{page}",
    produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<ReplyVo>> getList(@PathVariable("page") int page, @PathVariable("bno") int bno) {

        Criteria cri = new Criteria(page, 10);

        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
    }

    @GetMapping(value = "/{rno}",
    produces = {MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<ReplyVo> get(@PathVariable("rno") int rno) {

        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{rno}",
    produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("rno") int rno) {

        return service.remove(rno) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
    value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@RequestBody ReplyVo reply, @PathVariable("rno") int rno) {

        reply.setRno(rno);

        return service.modify(reply) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
