package historicalsight.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "HistoricalSight")
public class HistoricalSight {

    @Id
    @GeneratedValue
    @Column(name = "HistoricalSight_Id")
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Address")
    private String address;
    @Column(name = "Info")
    private String info;
    @Column(name = "Image")
    private String image;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "City_Id")
    private City city;

    public HistoricalSight() {
    }

    public HistoricalSight(String title, String address, String info, String image, City city) {
        this.title = title;
        this.address = address;
        this.info = info;
        this.image = image;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
