package week3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface SoptMemberRepository extends JpaRepository<SoptMemberEntity, Long> {
}
