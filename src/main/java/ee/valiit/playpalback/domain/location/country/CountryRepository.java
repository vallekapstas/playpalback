package ee.valiit.playpalback.domain.location.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("select c from Country c where c.status = 'A' order by c.name")
    List<Country> findActiveCountries();
}