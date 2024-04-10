package ee.valiit.playpalback.domain.location.location;

import ee.valiit.playpalback.domain.location.city.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "playpal")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Size(max = 10)
    @NotNull
    @Column(name = "post_code", nullable = false, length = 10)
    private String postCode;

    @NotNull
    @Column(name = "street", nullable = false, length = Integer.MAX_VALUE)
    private String street;

    @Column(name = "longtitude", precision = 8, scale = 6)
    private BigDecimal longtitude;

    @Column(name = "latitude", precision = 8, scale = 6)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

}