package com.nncklient.neonnetcafe.dao;

import com.nncklient.neonnetcafe.entity.Klient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KlientRepository extends JpaRepository<Klient, Integer> {
    public List<Klient> findAllByOrderByRezerwacjaAsc();
}
