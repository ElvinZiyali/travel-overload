package com.example.traveloverload.service;

import com.example.traveloverload.entity.Picture;
import com.example.traveloverload.exception.GeneralException;
import com.example.traveloverload.repo.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService implements CrudService<Picture, Long> {
    @Autowired
    private PictureRepository pictureRepository;


    @Override
    public List<Picture> getAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture getById(Long id) {
        return pictureRepository.findById(id).orElseThrow(() -> new GeneralException("Picture not found"));
    }

    @Override
    public Picture saveOrUpdate(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            pictureRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
