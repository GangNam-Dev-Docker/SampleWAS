package sample.gangnamdev.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberRepository repository;

    @Autowired
    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/members", method = RequestMethod.GET)
    public List<Member> getAll() {
        return repository.findAll();
    }

    @RequestMapping(path = "/members/{id}", method = RequestMethod.GET)
    public Member get(@RequestParam long id) {
        return repository.findOne(id);
    }

    @RequestMapping(path = "/members", method = RequestMethod.POST)
    public Long create(@RequestBody MemberRequest request) {
        Member member = new Member();
        member.setFullname(request.getFullname());
        member.setPhone(request.getPhone());
        member.setEmail(request.getEmail());

        member = repository.save(member);
        if(member != null) {
            return member.getId();
        } else {
            return 0L;
        }
    }

    @RequestMapping(path = "/members/{id}", method = RequestMethod.PUT)
    public Member update(@RequestParam long id, @RequestBody MemberRequest request) {
        Member member = repository.findOne(id);
        if(member != null) {
            member.setFullname(request.getFullname());
            member.setPhone(request.getPhone());
            member.setEmail(request.getEmail());
            member = repository.save(member);
        }

        return member;
    }

    @RequestMapping(path = "/members/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam long id) {
        repository.delete(id);
    }
}
