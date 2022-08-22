package com.example.member.controller;

import com.example.member.dto.MultiResponseDto;
import com.example.member.entity.Locations;
import com.example.member.entity.Member;
import com.example.member.entity.Types;
import com.example.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //앞에서 둘 다 있는 경우가 걸러지니까
    //뒤에는 둘다 없거나 둘 중 하나가 무조건 있는 경우겠져 > 정수님의 소중한 말씀.. 메모
    @GetMapping
    public ResponseEntity getMembers(@RequestParam(required = false,defaultValue = "1") int page, @RequestParam(required = false,defaultValue = "10") int size, @RequestParam(required = false)  Long type, @RequestParam(required = false) Long location){
        System.out.println("page = " + page);
        System.out.println("size = " + size);
        System.out.println("type = " + type);
        System.out.println("location = " + location);
        Pageable pageable = PageRequest.of(page-1,size,Sort.by("id").descending());
        Page<Member> members=null;
        if(type != null && location != null){ //둘다있을때
            members= memberRepository.findAllByLocationsAndTypes(new Locations(location,null),new Types(type,null),pageable);
        }else if(type !=null){ // type만 있을때
            members= memberRepository.findAllByTypes(new Types(type,null),pageable);
        }else if(location !=null){ //location만 있을때
            members= memberRepository.findAllByLocations(new Locations(location,null),pageable);
        }else{// 둘다 없을때
            members= memberRepository.findAll(pageable);
        }
        return new ResponseEntity(new MultiResponseDto<Member>(members.getContent(),members), HttpStatus.OK);
    }

}
