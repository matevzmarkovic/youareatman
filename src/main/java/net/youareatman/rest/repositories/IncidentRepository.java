package net.youareatman.rest.repositories;

import net.youareatman.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<User, String> {
}
