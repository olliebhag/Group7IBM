package com.example.ibmhackathon.repo;

import com.example.ibmhackathon.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    // TODO - Add methods to find by different parameters (e.g. by appointments, by rating)
    public User findByIsMaleNot (boolean isMale);
}
