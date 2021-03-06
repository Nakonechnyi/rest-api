package com.example.domain.ad;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @autor A_Nakonechnyi
 * @date 20.06.2016.
 */


public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {

    @Query("select ad from Ad ad where ad.status = 'PUBLISHED'")
    //@RestResource("published")
    Page<Ad> findPublished(Pageable pageable);
}
