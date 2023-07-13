package com.nncklient.neonnetcafe.service;

import com.nncklient.neonnetcafe.entity.Klient;

import java.util.List;

public interface KlientService {

    List<Klient> findAll();

    Klient findById(int theId);

    void save(Klient theKlient);

    void deleteById(int theId);
}
