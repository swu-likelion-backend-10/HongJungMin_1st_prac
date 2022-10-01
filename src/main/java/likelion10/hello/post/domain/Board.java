package likelion10.hello.post.domain;

import likelion10.hello.post.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Builder
    public Board(Long id, String title, String contents){
        this.id=id;
        this.title=title;
        this.contents=contents;
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
    }
}