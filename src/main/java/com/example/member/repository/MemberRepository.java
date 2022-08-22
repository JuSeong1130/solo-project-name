package com.example.member.repository;

import com.example.member.entity.Locations;
import com.example.member.entity.Member;
import com.example.member.entity.Types;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Page<Member> findAllByCompanyName(String companyName, PageRequest pageRequest);
    Page<Member> findAllByLocations(Locations locations, Pageable pageable);
    Page<Member> findAllByTypes(Types types, Pageable pageable);
    Page<Member> findAllByLocationsAndTypes(Locations locations,Types types, Pageable pageable);
}
