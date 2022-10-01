package likelion10.hello.post.controller;

import likelion10.hello.post.dto.BoardDto;
import likelion10.hello.post.dto.PersonalDetailDto;
import likelion10.hello.post.service.BoardService;
import likelion10.hello.post.service.PersonalDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;
    private final PersonalDetailService personalDetailService;

    public BoardController(BoardService boardService, PersonalDetailService personalDetailService){
        this.boardService=boardService;
        this.personalDetailService=personalDetailService;
    }

    @GetMapping("/board")
    public String list(Model model){
        List<BoardDto> boardDtoList = boardService.getBoardlist();
        model.addAttribute("boardList", boardDtoList);

//        List<PersonalDetailDto> personalDetailDtoList = personalDetailService.getPersonalDetaillist();
//        model.addAttribute("personalDetailList", personalDetailDtoList);

        return "board/list.html";
    }

    @GetMapping("board/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("board/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("board/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("board/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model) {
        BoardDto boardDto = boardService.getPost(id);
        model.addAttribute("boardDto", boardDto);
        return "/board/update.html";
    }
    @PutMapping("board/post/edit/{no}")
    public String update(@PathVariable("no") Long id, BoardDto boardDto) {
        boardService.updatePost(id, boardDto);
        return "redirect:/post/{no}";
    }
    @DeleteMapping("board/post/delete/{no}")
    public String delete(@PathVariable("no") Long id ){
        boardService.deletePost(id);
        return "redirect:/";
    }
}
