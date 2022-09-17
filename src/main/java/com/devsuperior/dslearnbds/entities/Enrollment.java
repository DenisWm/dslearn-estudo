package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.pk.EnrollmentPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private EnrollmentPK id = new EnrollmentPK();
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refund;
    private boolean available;
    private boolean onlyUpdate;

    public Enrollment() {
    }

    public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refund, boolean available, boolean onlyUpdate) {
        this.id.setUser(user);
        this.id.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refund = refund;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent(){
       return id.getUser();
    }

    public void setStudent(User user){
        this.id.setUser(user);
    }

    public Offer getOffer(){
        return id.getOffer();
    }

    public void setOffer(Offer offer){
        this.id.setOffer(offer);
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefund() {
        return refund;
    }

    public void setRefund(Instant refund) {
        this.refund = refund;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }
}
