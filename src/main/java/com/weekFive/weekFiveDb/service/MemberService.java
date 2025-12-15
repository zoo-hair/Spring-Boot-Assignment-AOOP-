package com.weekFive.weekFiveDb.service;

import com.weekFive.weekFiveDb.model.Member;
import com.weekFive.weekFiveDb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class MemberService {

    @Autowired
    private  MemberRepository memberRepository;


  //  public MemberService(MemberRepository memberRepository) {
  //      this.memberRepository = memberRepository;
  //  } Initially I used constructor injection instead of field


    public Member registerMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public Member updateMember(Long id, Member memberDetails) {
        Member member = getMemberById(id);
        if (member != null) {
            member.setName(memberDetails.getName());
            member.setEmail(memberDetails.getEmail());
            member.setMembershipDate(memberDetails.getMembershipDate());

            return memberRepository.save(member);
        }
        return null;
    }

    public void deleteMember(long id) {
        memberRepository.deleteAllById(Collections.singleton(id));
    }

    public long countMembers() {
        return memberRepository.count();
    }
}

