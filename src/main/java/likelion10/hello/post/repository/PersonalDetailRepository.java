package likelion10.hello.post.repository;

import likelion10.hello.post.domain.PersonalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailRepository extends JpaRepository<PersonalDetail, Long> {
}
