package com.example.domain;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @autor A_Nakonechnyi
 * @date 20.06.2016.
 */

@Entity
public class Ad implements Identifiable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Type type;

    public enum Type {
        BUY,
        SELL
    }

    @Column (nullable = false)
    private BigInteger amount;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Currency currency;

    public enum Currency {
        USD,
        EUR
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
}

