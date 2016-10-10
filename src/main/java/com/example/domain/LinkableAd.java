package com.example.domain;

import org.springframework.hateoas.Identifiable;

/**
 * @autor A_Nakonechnyi
 * @date 10.10.2016.
 */
public interface LinkableAd extends Identifiable<Long> {
    Ad.Status getStatus();
}
