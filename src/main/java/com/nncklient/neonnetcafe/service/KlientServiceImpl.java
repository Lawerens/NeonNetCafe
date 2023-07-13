package com.nncklient.neonnetcafe.service;

import com.nncklient.neonnetcafe.dao.KlientRepository;
import com.nncklient.neonnetcafe.entity.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KlientServiceImpl implements KlientService{

    private KlientRepository klientRepository;

    @Autowired
    public KlientServiceImpl(KlientRepository theKlientRepository){
        klientRepository = theKlientRepository;
    }

    @Override
    public List<Klient> findAll() {
        return klientRepository.findAllByOrderByRezerwacjaAsc();
    }

    @Override
    public Klient findById(int theId) {
        Optional<Klient> result = klientRepository.findById(theId);
        Klient theKlient = null;
        if(result.isPresent()){
            theKlient = result.get();
        }
        else{
            throw new RuntimeException("Did not find klient id - " + theId);
        }
        return theKlient;
    }

    @Override
    public void save(Klient theKlient) {
        klientRepository.save(theKlient);
    }

    @Override
    public void deleteById(int theId) {
        klientRepository.deleteById(theId);
    }
}
