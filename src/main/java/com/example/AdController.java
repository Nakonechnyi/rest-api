package com.example;

import com.example.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @autor A_Nakonechnyi
 * @date 05.07.2016.
 */

@RepositoryRestController
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/ads/{id}/publishing", method = RequestMethod.POST, produces = "application/hal+json")
    @ResponseBody
    public Resource publish(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) {
        return assembler.toFullResource(adService.publish(id));
    }

    @RequestMapping(value = "/ads/{id}/expiretion", method = RequestMethod.POST, produces = "application/hal+json")
    @ResponseBody
    public Resource expire(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) {
        return assembler.toFullResource(adService.expire(id));
    }
}
