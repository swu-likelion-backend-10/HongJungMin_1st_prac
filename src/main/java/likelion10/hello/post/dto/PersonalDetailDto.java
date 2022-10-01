package likelion10.hello.post.dto;

import likelion10.hello.post.domain.PersonalDetail;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PersonalDetailDto {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    private String introduction;

    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

    public PersonalDetail toEntity(){
        PersonalDetail build = PersonalDetail.builder()
                .id(id)
                .name(name)
                .age(age)
                .major(major)
                .introduction(introduction)
                .build();
        return build;
    }

    @Builder
    public PersonalDetailDto(Long id, String name, Integer age, String major, String introduction, LocalDateTime createdTime, LocalDateTime modifiedTime){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.introduction=introduction;
        this.createdTime=createdTime;
        this.modifiedTime=modifiedTime;
    }
}
