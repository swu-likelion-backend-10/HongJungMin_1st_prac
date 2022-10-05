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

    @GetMapping("/personal_detail/")
    public String list(Model model){
        List<PersonalDetailDto> personalDetailDtoList = personalDetailService.getPersonalDetaillist();
        model.addAttribute("personalDetailList", personalDetailDtoList);

        return "personal_detail/list.html";
    }
    @GetMapping("/personal_detail/post")
    public String write(){
        return "personal_detail/write.html";
    }

    @PostMapping("/personal_detail/post")
    public String write(PersonalDetailDto PersonalDetailDto){
        personalDetailService.savePost(PersonalDetailDto);
        return "redirect:/personal_detail/";
    }

    @GetMapping("/personal_detail/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model) {
        PersonalDetailDto personalDetailDto = personalDetailService.getPost(id);

        model.addAttribute("personalDetailDto", personalDetailDto);
        return "personal_detail/detail.html";
    }

    @GetMapping("/personal_detail/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model) {
        PersonalDetailDto personalDetailDto = personalDetailService.getPost(id);

        model.addAttribute("personalDetailDto", personalDetailDto);
        return "personal_detail/update.html";
    }
    @PutMapping("/personal_detail/post/edit/{no}")
    public String update(@PathVariable("no") Long id, PersonalDetailDto personalDetailDto) {
        personalDetailService.updatePost(id, personalDetailDto);
        return "redirect:/personal_detail/post/{no}";
    }
    @DeleteMapping("/personal_detail/post/delete/{no}")
    public String delete(@PathVariable("no") Long id ){
        personalDetailService.deletePost(id);
        return "redirect:/personal_detail/";
    }
    @GetMapping("/personal_detail/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        List<PersonalDetailDto> personalDetailDtoList = personalDetailService.searchPosts(keyword);
        model.addAttribute("personalDetailList", personalDetailDtoList);

        return "personal_detail/list.html";
    }
}

