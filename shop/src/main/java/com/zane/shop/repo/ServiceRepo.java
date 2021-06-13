package com.zane.shop.repo;

import com.zane.shop.model.Service;
import com.zane.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {

    List<Service> findByTheme(String theme);

    List<Service> findByTitleLike(String keyword);

    void deleteServiceByServiceId(Long userId);

}
