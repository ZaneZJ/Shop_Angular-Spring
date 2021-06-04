package com.zane.shop.repo;

import com.zane.shop.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepo extends JpaRepository<Text, Long> {

}
