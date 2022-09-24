package likelion10.hello.post.controller;

import likelion10.hello.post.dto.BoardDto;
import likelion10.hello.post.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @GetMapping("/list")
    public String list(){
        return "board/list.html";
    }

    @GetMapping("/post_")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post_")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
