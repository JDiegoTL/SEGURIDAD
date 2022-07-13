package com.idat.seg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.seg.model.Motor;
@Repository
public interface MotorRepository extends JpaRepository<Motor, Integer> {

}
