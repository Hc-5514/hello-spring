package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    /**
     * 모든 Test는 순서가 보장되지 않는다.
     * 따라서 모든 Test는 의존관계 없이 메소드 별로 따로 동작하도록 설계해야 한다.
     * 해결 방법: 각 Test 진행 후, afterEach()로 repository를 비워준다.
     */

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
        // Assertions.assertEquals(member, result); // System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // shift + f6 으로 동일한 변수명 rename 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // ctrl + alt + v 으로 return 값 할당 가능
        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}