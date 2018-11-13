package historicalsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Region")
public class Region {

    @Id
    @GeneratedValue
    @Column(name = "Region_id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "region",fetch = FetchType.EAGER)
    private List<City> city;

    public Region() {
    }

    public Region(String title, List<City> city) {
        this.title = title;
        this.city = city;
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

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city=" + city +
                '}';
    }
}
