package com.zane.shop.repo;

import com.zane.shop.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {

    List<Service> findByTheme(String theme);
    List<Service> findByTitleLike(String keyword);

}
