package com.example.ibmhackathon.repo;

import com.example.ibmhackathon.domain.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepo extends CrudRepository<Location, Long> {
    // TODO - Add methods to find by different parameters (e.g. by appointments, by rating, by distance)
}
