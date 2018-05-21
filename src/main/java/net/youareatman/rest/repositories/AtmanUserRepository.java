package net.youareatman.rest.repositories;

import net.youareatman.model.AtmanUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface AtmanUserRepository extends CrudRepository<AtmanUser, String> {



}
