package net.youareatman.rest.repositories;

import net.youareatman.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface UserRepository extends CrudRepository<User, String> {



}
