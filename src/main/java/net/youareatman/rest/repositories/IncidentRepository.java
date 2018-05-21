package net.youareatman.rest.repositories;

import net.youareatman.model.AtmanUser;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<AtmanUser, String> {
}
