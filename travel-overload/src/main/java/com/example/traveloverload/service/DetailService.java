package com.example.traveloverload.service;

import com.example.traveloverload.entity.Blog;
import com.example.traveloverload.entity.Detail;
import com.example.traveloverload.exception.GeneralException;
import com.example.traveloverload.repo.BlogRepository;
import com.example.traveloverload.repo.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService implements CrudService<Detail, Long> {
    @Autowired
    private DetailRepository detailRepository;


    @Override
    public List<Detail> getAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail getById(Long id) {
        return detailRepository.findById(id).orElseThrow(() -> new GeneralException("Detail not found"));
    }

    @Override
    public Detail saveOrUpdate(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            detailRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
