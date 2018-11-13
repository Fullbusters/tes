package historicalsight.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "City_Id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    private List<HistoricalSight> historicalSights;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Region_Id")
    private Region region;

    public City() {
    }

    public City(String title, List<HistoricalSight> historicalSights, Region region) {
        this.title = title;
        this.historicalSights = historicalSights;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HistoricalSight> getHistoricalSights() {
        return historicalSights;
    }

    public void setHistoricalSights(List<HistoricalSight> historicalSights) {
        this.historicalSights = historicalSights;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", historicalSights=" + historicalSights +
                '}';
    }
}
