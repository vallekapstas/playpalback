package ee.valiit.playpalback.domain.location.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c from City c where c.county.id = :countyId and c.status='A' order by c.name")
    List<City> findCitiesByCountyId(Integer countyId);

}