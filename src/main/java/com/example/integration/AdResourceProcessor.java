package com.example.integration;

import com.example.AdController;
import com.example.domain.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @autor A_Nakonechnyi
 * @date 10.07.2016.
 */
@Component
public class AdResourceProcessor implements ResourceProcessor<Resource<Ad>> {

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @Override
    public Resource<Ad> process(Resource<Ad> resource) {
        final Ad ad = resource.getContent();
        if (ad.getStatus() == Ad.Status.NEW) {
            resource.add(linkTo(methodOn(AdController.class).publish(ad.getId(), null))
                    .withRel("publishing"));
            // "POST (https://domain:port/contextPath)  /ads/{id}/publishing"
            
            resource.add(entityLinks.linkToSingleResource(ad).withRel("update"));
            resource.add(entityLinks.linkToSingleResource(ad).withRel("deletion"));
        }

        if (ad.getStatus() == Ad.Status.PUBLISHED) {
            resource.add(linkTo(methodOn(AdController.class).expire(ad.getId(), null))
                    .withRel("expiration"));
        }


        return resource;
    }
}
