package com.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @autor A_Nakonechnyi
 * @date 09.10.2016.
 */

@Projection(types = Ad.class, name = "minimal")
public interface ProjectedAd {
    Ad.Type getType();

    BigDecimal getAmount();

    String getCurrency();

    String getRate();

    @Value("#{target.user.phoneNumber}")
    String getPhoneNumber();
}
