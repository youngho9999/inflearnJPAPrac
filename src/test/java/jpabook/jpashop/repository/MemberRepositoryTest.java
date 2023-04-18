package jpabook.jpashop.repository;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jpabook.jpashop.domain.Member;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		Member member = new Member();
		member.setUsername("memberA");
		Long saveId = memberRepository.save(member);
		
		Member findMember = memberRepository.find(saveId);
		
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		Assertions.assertThat(findMember).isEqualTo(member);
	}
	
}
