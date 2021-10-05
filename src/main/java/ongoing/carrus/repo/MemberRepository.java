package ongoing.carrus.repo;

import ongoing.carrus.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,Integer> {
}
