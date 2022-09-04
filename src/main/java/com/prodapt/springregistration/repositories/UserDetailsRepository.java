package com.prodapt.springregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.springregistration.entities.User;
import com.prodapt.springregistration.entities.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
	User findByFirstName(String firstName);

}
