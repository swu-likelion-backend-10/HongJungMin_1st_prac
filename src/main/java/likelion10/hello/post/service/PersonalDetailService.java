package likelion10.hello.post.service;

import likelion10.hello.post.domain.PersonalDetail;
import likelion10.hello.post.dto.PersonalDetailDto;
import likelion10.hello.post.repository.PersonalDetailRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public List<PersonalDetailDto> getPersonalDetaillist() {
        List<PersonalDetail> personalDetails = personalDetailRepository.findAll();
        List<PersonalDetailDto> personalDetailDtoList = new ArrayList<>();

        for(PersonalDetail personalDetail : personalDetails) {
            PersonalDetailDto personalDetailDto = PersonalDetailDto.builder()
                    .id(personalDetail.getId())
                    .name(personalDetail.getName())
                    .age(personalDetail.getAge())
                    .major(personalDetail.getMajor())
                    .introduction(personalDetail.getIntroduction())
                    .createdTime(personalDetail.getCreatedTime())
                    .build();

            personalDetailDtoList.add(personalDetailDto);
        }
        return personalDetailDtoList;
    }

    @Transactional
    public PersonalDetailDto getPost(Long id){
        Optional<PersonalDetail> personalDetailWrapper = personalDetailRepository.findById(id);
        PersonalDetail personalDetail = personalDetailWrapper.get();

        PersonalDetailDto personalDetailDto = PersonalDetailDto.builder()
                .id(personalDetail.getId())
                .name(personalDetail.getName())
                .age(personalDetail.getAge())
                .major(personalDetail.getMajor())
                .introduction(personalDetail.getIntroduction())
                .createdTime(personalDetail.getCreatedTime())
                .modifiedTime(personalDetail.getModifiedTime())
                .build();

        return personalDetailDto;
    }

    @Transactional
    public Long updatePost(Long id, PersonalDetailDto personalDetailDto) {
        PersonalDetail personalDetail = personalDetailRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("해당 인적사항은 존재하지 않습니다. "+id));
        personalDetail.update(personalDetailDto);
        return id;
    }

    @Transactional
    public void deletePost(Long id) {
        personalDetailRepository.deleteById(id);
    }
    @Transactional
    public List<PersonalDetailDto> searchPosts(String keyword){
        List<PersonalDetail> personalDetails = personalDetailRepository.findByNameContaining(keyword);
        List<PersonalDetailDto> personalDetailDtoList = new ArrayList<>();

        if(personalDetails.isEmpty()) {
            return personalDetailDtoList;
        }

        for (PersonalDetail personalDetail : personalDetails){
            personalDetailDtoList.add(this.convertEntityToDto(personalDetail));
        }

        return personalDetailDtoList;
    }

    private PersonalDetailDto convertEntityToDto(PersonalDetail personalDetail){
        return PersonalDetailDto.builder()
                .id(personalDetail.getId())
                .name(personalDetail.getName())
                .age(personalDetail.getAge())
                .major(personalDetail.getMajor())
                .introduction(personalDetail.getIntroduction())
                .createdTime(personalDetail.getCreatedTime())
                .modifiedTime(personalDetail.getModifiedTime())
                .build();
    }

    }
