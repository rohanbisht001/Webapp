package com.prodapt.springregistration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prodapt.springregistration.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);

	@Query(value = "SELECT c FROM User c WHERE c.userName LIKE '%' || :keyword || '%'"
			+ " OR c.userId LIKE '%' || :keyword || '%'")
	public List<User> search(@Param("keyword") String keyword);

}
