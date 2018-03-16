package com.hospital.models;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Comments")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name="Comment_Id")
    private Long commentId;
    @Column(name="Creation_Date")
    private Date creationDate;
    @Column(name="Comment")
    private String commentContent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Comment() {
    }

    public Comment(Date creationDate, String commentContent, Patient patient) {
        this.creationDate = creationDate;
        this.commentContent = commentContent;
        this.patient = patient;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}
