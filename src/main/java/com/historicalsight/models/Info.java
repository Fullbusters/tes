package com.historicalsight.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Info")
public class Info {

    @Id
    @GeneratedValue
    @Column(name = "Info_Id")
    private Long id;
    @Column(name = "Info")
    private String info;
    @Column(name = "Image")
    private String image;
//    @JsonIgnore
//    @OneToMany(mappedBy = "info",fetch = FetchType.EAGER)
//    private List<HistoricalSight> historicalSights;

    public Info() {
    }

    public Info(String info, String image, List<HistoricalSight> historicalSights) {
        this.info = info;
        this.image = image;
//        this.historicalSights = historicalSights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public List<HistoricalSight> getHistoricalSights() {
//        return historicalSights;
//    }
//
//    public void setHistoricalSights(List<HistoricalSight> historicalSights) {
//        this.historicalSights = historicalSights;
//    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", image='" + image + '\'' +
//                ", historicalSights=" + historicalSights +
                '}';
    }
}
