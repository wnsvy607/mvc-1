package hello.servlet.web.springmvc.v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import hello.servlet.domain.member.Member;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashmap, AtomicLong 사용 고려
 */
@Repository
public class BeanMemberRepository {
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;

	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	public Member findById(Long id) {
		return store.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

	public void clearStore() {
		store.clear();
	}

}
