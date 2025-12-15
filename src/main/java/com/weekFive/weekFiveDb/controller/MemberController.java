package com.weekFive.weekFiveDb.controller;


import com.weekFive.weekFiveDb.model.Member;
import com.weekFive.weekFiveDb.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private  MemberService memberService;


    @PostMapping
    public Member register(@Valid @RequestBody Member member) {
        return memberService.registerMember(member);
    }


    @GetMapping
    public List<Member> getAll() {
        return memberService.getAllMembers();
    }


    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(id, member);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member/User deleted successfully!");
    }

    @GetMapping("/count")
    public ResponseEntity<String> countMembers() {
        long count = memberService.countMembers();
        return ResponseEntity.ok("Total users: " + count);
    }
}