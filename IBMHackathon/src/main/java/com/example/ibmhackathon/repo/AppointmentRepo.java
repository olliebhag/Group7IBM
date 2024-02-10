package com.example.ibmhackathon.repo;

import com.example.ibmhackathon.domain.Appointment;
import com.example.ibmhackathon.domain.Location;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepo extends CrudRepository<Appointment, Long> {
    public Appointment findByPickUp(Location pickUp);
    // TODO - Add methods to find by different parameters (e.g. by driver, by date, by passengers)
}
