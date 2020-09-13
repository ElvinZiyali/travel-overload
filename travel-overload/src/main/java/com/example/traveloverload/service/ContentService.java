package com.example.traveloverload.service;

import com.example.traveloverload.entity.Content;
import com.example.traveloverload.exception.GeneralException;
import com.example.traveloverload.repo.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService implements CrudService<Content,Long> {
    @Autowired
    private ContentRepository contentRepository;


    @Override
    public List<Content> getAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content getById(Long id) {
        return contentRepository.findById(id).orElseThrow(()-> new GeneralException("Content not found"));
    }

    @Override
    public Content saveOrUpdate(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public boolean deleteById(Long id) {
        try{
            contentRepository.deleteById(id);
            return true;
        }catch (Exception ignored){
            return false;
        }
    }
}
