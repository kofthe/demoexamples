package mehmetari.modelmapperdemo.repository;

import mehmetari.modelmapperdemo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
