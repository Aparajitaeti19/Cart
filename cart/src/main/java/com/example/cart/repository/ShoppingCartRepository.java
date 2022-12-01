package com.example.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cart.entity.Cart;
import com.example.cart.entity.User;
import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<Cart,Integer> {
	 List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

	 List<Cart> deleteByUser(User user);
}
