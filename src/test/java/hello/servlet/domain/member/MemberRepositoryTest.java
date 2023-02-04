package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() throws Exception {
		//given
		Member member = new Member("hello", 20);

		//when
		Member savedMember = memberRepository.save(member);

		//then
		Member findMember = memberRepository.findById(savedMember.getId());
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	void findAll() throws Exception {
		//given
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);

		memberRepository.save(member1);
		memberRepository.save(member2);

		//when
		List<Member> result = memberRepository.findAll();

		//then
		assertThat(result.size()).isEqualTo(2);
		assertThat(result).contains(member1, member2);
	}

	@Test
	void DirtyChecking() throws Exception {
		//given
		Member member1 = new Member("member1", 20);
		Member member2 = new Member("member2", 30);

		memberRepository.save(member1);
		memberRepository.save(member2);
		//when
		member1.setAge(21);
		member2.setAge(31);

		Member findMember1 = memberRepository.findById(member1.getId());
		Member findMember2 = memberRepository.findById(member2.getId());

		//then
		assertThat(findMember1.getAge()).isEqualTo(21);
		assertThat(findMember2.getAge()).isEqualTo(31);

	}

}
