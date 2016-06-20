package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @autor A_Nakonechnyi
 * @date 20.06.2016.
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return phoneNumber != null ? phoneNumber.equals(user.phoneNumber) : user.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
