package com.bootcamp.shopping.repository;

import com.bootcamp.shopping.model.Buys;
import com.bootcamp.shopping.model.UserBuysItemsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuysRepo extends JpaRepository<Buys, UserBuysItemsKey> {

}
