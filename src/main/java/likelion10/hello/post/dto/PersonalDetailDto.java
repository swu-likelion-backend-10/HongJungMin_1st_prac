package likelion10.hello.post.dto;

import likelion10.hello.post.domain.PersonalDetail;

public class PersonalDetailDto {

    private Long id;
    private String name;
    private Integer age;
    private String major;
    private String introduction;

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

    public PersonalDetailDto(Long id, String name, Integer age, String major, String introduction){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.introduction=introduction;
    }
}
