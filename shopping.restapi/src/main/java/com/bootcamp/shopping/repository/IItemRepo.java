package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findByName(String name);
    List<Item> findByCategory(String category);
}
