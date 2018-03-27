package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.OrderInfo;

@Repository
public interface OrderInfoInterface extends CrudRepository<OrderInfo, Long> {

}
