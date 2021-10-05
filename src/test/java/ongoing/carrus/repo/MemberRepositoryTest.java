package ongoing.carrus.repo;

import ongoing.carrus.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
    Member member = new Member("Krishna", "Khanal", "Ringertoften 6 2tv", "Copenhagen", "2400", "71552802", "k@gmail.com", false, 0, 10.0);

    @Test
    public void testCount() {
        memberRepository.save(member);
        long result = memberRepository.count();
        assertEquals(1, result);
    }
    @Test
    public void testCreate(){
        assertNotNull(memberRepository.findById(1));
    }
}