package ongoing.carrus.rest;

import io.swagger.annotations.ApiOperation;
import ongoing.carrus.entity.Member;
import ongoing.carrus.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/members",produces = MediaType.APPLICATION_JSON_VALUE)
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping
    Iterable<Member> getAllMember(){
        return memberRepository.findAll();

    }
    @GetMapping(value = "/{id}")
    Member getMember(@PathVariable int id){
        return memberRepository.findById(id).orElseThrow();
    }
    @PostMapping
    Member createMember(@RequestBody Member member){
        Member memb = memberRepository.save(member);
        return memb;
    }
    /*
    @PutMapping("/{id}")
    Member editCustomer(@RequestBody Member member,@PathVariable int id) throws Exception{
    Member originalMember = memberRepository.findById(id).orElseThrow();
    member.setDateCreated(originalMember.getDateCreated());
    return memberRepository.save(member);
    }
    */
    @DeleteMapping(value = "/{id}")
    @ApiOperation("Delete the member providing id")
    public void deleteMember(@PathVariable int id){
        memberRepository.deleteById(id);

    }








    @PutMapping(value = "/{id}")
    ResponseEntity<Member> editOrAddMember(@RequestBody Member member,@PathVariable int id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        HttpStatus hs = HttpStatus.CREATED;
        if(optionalMember.isPresent()){
            Member originalMember = optionalMember.get();
            member.setDateCreated(originalMember.getDateCreated());
            member.setDateUpdated(LocalDateTime.now());
            hs = HttpStatus.OK;

        }
        return ResponseEntity.status(hs).body(member);
    }


}
