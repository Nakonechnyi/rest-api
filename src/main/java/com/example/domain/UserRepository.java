package com.example.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @autor A_Nakonechnyi
 * @date 20.06.2016.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
