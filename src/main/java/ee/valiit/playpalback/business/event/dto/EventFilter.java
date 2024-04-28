package ee.valiit.playpalback.business.event.dto;

import ee.valiit.playpalback.domain.event.event.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link Event}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventFilter implements Serializable {
    private String status;
    private String stscond;
    private String sortdir;
    private String sortparam;
    private String name;
    private String venue;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalTime starttime;
    private LocalTime endtime;
    private boolean participant;
    private boolean host;
    private Integer minplayers;
    private Integer maxplayers;
    private Integer minage;
    private Integer maxage;
    private Double minfee;
    private Double maxfee;
    private Integer minjoined;
    private Integer maxjoined;
    private Integer countryid;
    private Integer countyid;
    private Integer cityid;
    private Integer skillid;
}