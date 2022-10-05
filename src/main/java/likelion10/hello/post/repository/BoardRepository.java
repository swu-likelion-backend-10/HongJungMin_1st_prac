package likelion10.hello.post.repository;

import likelion10.hello.post.domain.Board;
import likelion10.hello.post.domain.PersonalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitleContaining(String keyword);
}
