package likelion10.hello.post.service;

import likelion10.hello.post.dto.PersonalDetailDto;
import likelion10.hello.post.repository.PersonalDetailRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonalDetailService {
    private final PersonalDetailRepository personalDetailRepository;

    public PersonalDetailService(PersonalDetailRepository personalDetailRepository){
        this.personalDetailRepository=personalDetailRepository;
    }

    @Transactional
    public Long savePost(PersonalDetailDto personalDetailDto){
        return personalDetailRepository.save(personalDetailDto.toEntity()).getId();
    }
}
