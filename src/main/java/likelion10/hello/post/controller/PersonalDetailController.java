package likelion10.hello.post.controller;

import likelion10.hello.post.dto.PersonalDetailDto;
import likelion10.hello.post.service.PersonalDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PersonalDetailController {

    private final PersonalDetailService personalDetailService;

    public PersonalDetailController(PersonalDetailService personalDetailService){
        this.personalDetailService=personalDetailService;
    }

    @GetMapping("/")
    public String write(){
        return "personal_detail/write.html";
    }

    @PostMapping("/post")
    public String write(PersonalDetailDto PersonalDetailDto){
        personalDetailService.savePost(PersonalDetailDto);
        return "redirect:/";
    }
}

