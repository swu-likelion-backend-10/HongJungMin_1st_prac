package likelion10.hello.post.controller;

import likelion10.hello.post.dto.BoardDto;
import likelion10.hello.post.dto.PersonalDetailDto;
import likelion10.hello.post.service.PersonalDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonalDetailController {

    private final PersonalDetailService personalDetailService;

    public PersonalDetailController(PersonalDetailService personalDetailService){
        this.personalDetailService=personalDetailService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<PersonalDetailDto> personalDetailDtoList = personalDetailService.getPersonalDetaillist();
        model.addAttribute("personalDetailList", personalDetailDtoList);

        return "personal_detail/list.html";
    }
    @GetMapping("/post")
    public String write(){
        return "personal_detail/write.html";
    }

    @PostMapping("/post")
    public String write(PersonalDetailDto PersonalDetailDto){
        personalDetailService.savePost(PersonalDetailDto);
        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        PersonalDetailDto personalDetailDto = personalDetailService.getPost(id);

        model.addAttribute("personalDetailDto", personalDetailDto);
        return "personal_detail/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model) {
        PersonalDetailDto personalDetailDto = personalDetailService.getPost(id);

        model.addAttribute("personalDetailDto", personalDetailDto);
        return "personal_detail/update.html";
    }
    @PutMapping("post/edit/{no}")
    public String update(@PathVariable("no") Long id, PersonalDetailDto personalDetailDto) {
        personalDetailService.updatePost(id, personalDetailDto);
        return "redirect:/post/{no}";
    }
    @DeleteMapping("/post/delete/{no}")
    public String delete(@PathVariable("no") Long id ){
        personalDetailService.deletePost(id);
        return "redirect:/";
    }
}

