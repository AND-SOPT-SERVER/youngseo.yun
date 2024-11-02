package week3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final SoptMemberRepository soptMemberRepository;

    public Controller(SoptMemberRepository soptMemberRepository) {
        this.soptMemberRepository = soptMemberRepository;
    }

    @PostMapping("/member")
    void postMember() {
        soptMemberRepository.save(new SoptMemberEntity("영서", 8));
    }

    @GetMapping("/member")
    ResponseEntity<String> getMember() {
        List<SoptMemberEntity> members = soptMemberRepository.findAll();

        return ResponseEntity.ok(members.stream().findFirst().get().toString());
    }

}
