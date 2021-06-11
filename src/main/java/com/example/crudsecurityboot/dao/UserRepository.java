package com.example.crudsecurityboot.dao;

import com.example.crudsecurityboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByName(String userName);
}
