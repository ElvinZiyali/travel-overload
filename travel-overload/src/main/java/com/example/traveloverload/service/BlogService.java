package com.example.traveloverload.service;

import com.example.traveloverload.entity.Blog;
import com.example.traveloverload.exception.GeneralException;
import com.example.traveloverload.repo.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements CrudService<Blog, Long> {
    @Autowired
    private BlogRepository blogRepository;


    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new GeneralException("Blog not found"));
    }

    @Override
    public Blog saveOrUpdate(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            blogRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
