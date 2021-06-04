package com.zane.shop.repo;

import com.zane.shop.model.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicturesRepo extends JpaRepository<Pictures, Long> {

}

