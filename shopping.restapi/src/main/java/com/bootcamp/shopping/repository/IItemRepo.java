package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepo extends JpaRepository<Item,Integer> {
}
