package com.example.domain.ad;

import com.example.domain.User;
import com.example.exception.InvalidAdStateTransitionException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @autor A_Nakonechnyi
 * @date 20.06.2016.
 */

@Entity
public class Ad implements LinkableAd {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Type type;

    public enum Type {
        BUY,
        SELL;
    }

    @Column (nullable = false)
    private BigInteger amount;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Currency currency;

    public enum Currency {
        USD,
        EUR;
    }

    @Column (nullable = false)
    private BigDecimal rate;

    @ManyToOne
    @JoinColumn (nullable = false)
    private User user;

    private Location location;

    @Embeddable
    public static class Location {

        @Column (nullable = false)
        private String city;

        private String area;

        public Location() {
    }

        public Location(String city, String area) {
        this.city = city;
        this.area = area;
    }

        /*public String getCity() {
            return city;
        }*/

        public void setCity(String city) {
        this.city = city;
    }

        public void setArea(String area) {
        this.area = area;
    }

    }
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    public enum Status {
        NEW,
        PUBLISHED,
        EXPIRED
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //@Column(nullable = false)
    @Lob
    private LocalDateTime publishedAt;

    private String comment;

    public String getComment() {
    return comment;
}

    public void setComment(String comment) {
    this.comment = comment;
}

    public LocalDateTime getPublishedAt() {

    return publishedAt;
}

    public void setPublishedAt(LocalDateTime publishedAt) {
    this.publishedAt = publishedAt;
}


    @Override
    public Long getId() {
    return id;
}

    public void setId(Long id) {
    this.id = id;
}

    public Type getType() {
    return type;
}

    public void setType(Type type) {
    this.type = type;
}

    public BigInteger getAmount() {
    return amount;
}

    public void setAmount(BigInteger amount) {
    this.amount = amount;
}

    public Currency getCurrency() {
    return currency;
}

    public void setCurrency(Currency currency) {
    this.currency = currency;
}

    public BigDecimal getRate() {
    return rate;
}

    public void setRate(BigDecimal rate) {
    this.rate = rate;

}

    public User getUser() {
    return user;
}


    public void setUser(User user) {
    this.user = user;
}

    public Location getLocation() {
    return location;
}

    public void setLocation(Location location) {
    this.location = location;
}

    public Ad publish() {
        if (status == Status.NEW) {
            publishedAt = LocalDateTime.now();
            status = Status.PUBLISHED;
        } else {
            throw new InvalidAdStateTransitionException("Ad can be published only when it is " + Status.NEW);
        }
        return this;
    }

    public Ad expire() {
        if (status == Status.PUBLISHED) {
            status = Status.EXPIRED;
        } else {
            throw new InvalidAdStateTransitionException("Ad can be finished only when it is " + Status.PUBLISHED);
        }
        return this;
    }

}

