package com.idat.seg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.seg.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
