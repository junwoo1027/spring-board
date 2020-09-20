package com.company.controller;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.PageDto;
import com.company.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    private BoardService service;

//    @GetMapping("/list")
//    public void list(Model model) {
//        log.info("list");
//
//        model.addAttribute("list", service.getList());
//    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVo board, RedirectAttributes rttr) {

        log.info("register : " + board);

        service.register(board);

        rttr.addFlashAttribute("result", board.getBno());

        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
        log.info("get and modify");

        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVo board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

        log.info("modify: " + board);

        if(service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }

        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPageNum());

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("remove : " + bno);

        if(service.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }

        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPageNum());

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void listPage(Criteria cri, Model model) {

        log.info("list: " + cri);

        int total = service.getTotal(cri);

        model.addAttribute("list", service.listPage(cri));
        model.addAttribute("pageMaker", new PageDto(cri, total));
    }
}
