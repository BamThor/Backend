package com.sojuthon.sojuthonbackend.repository;

import com.sojuthon.sojuthonbackend.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByPhoneAndPassword(String phone, String password);

    Optional<Member> findByPhone(String phone);
}
