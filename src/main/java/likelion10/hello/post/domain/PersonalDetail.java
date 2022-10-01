package likelion10.hello.post.domain;

import likelion10.hello.post.dto.PersonalDetailDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PersonalDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String major;

    @Column(nullable = false)
    private String introduction;

    @Builder
    public PersonalDetail(Long id, String name, Integer age, String major, String introduction){
        this.id=id;
        this.name=name;
        this.age=age;
        this.major=major;
        this.introduction=introduction;
    }

    public void update(PersonalDetailDto personalDetailDto){
        this.name = personalDetailDto.getName();
        this.age = personalDetailDto.getAge();
        this.major = personalDetailDto.getMajor();
        this.introduction = personalDetailDto.getIntroduction();

    }

}

