package com.example.service;

import com.example.domain.Ad;
import com.example.domain.AdRepository;
import com.example.exception.InvalidAdStateTransitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @autor A_Nakonechnyi
 * @date 10.10.2016.
 */
@Service
@Transactional
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public Ad publish(Long id) throws InvalidAdStateTransitionException {
        return findDoAndSave(id, Ad::publish);
    }

    public Ad expire(Long id) throws InvalidAdStateTransitionException {
        return findDoAndSave(id, Ad::expire);
    }

    private Ad findDoAndSave(Long id, Action action) {
        Ad foundAd = adRepository.findOne(id);
        Ad modifiedAd = action.perform(foundAd);
        return adRepository.save(modifiedAd);
    }

    public Ad findOne(Long id) {
        return adRepository.findOne(id);
    }

    @FunctionalInterface
    private interface Action {

        Ad perform(Ad ad);

    }
}
