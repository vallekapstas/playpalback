package ee.valiit.playpalback.domain.location.county;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountyRepository extends JpaRepository<County, Integer> {
    @Query("select c from County c where c.country.id = :countryId and c.status = 'A' order by c.name")
    List<County> findCountiesByCountryId(Integer countyId);

}