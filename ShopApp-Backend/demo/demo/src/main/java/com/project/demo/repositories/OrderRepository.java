package com.project.demo.repositories;
import com.project.demo.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    // find OrderEntity of user
    public List<OrderEntity> findByUser_Id(Long userId);
}
