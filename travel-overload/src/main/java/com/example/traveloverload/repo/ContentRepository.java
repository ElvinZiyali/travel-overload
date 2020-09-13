package com.example.traveloverload.repo;

import com.example.traveloverload.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,Long> {
}
