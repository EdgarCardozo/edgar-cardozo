package com.bootcamp.shopping;

import com.bootcamp.shopping.controller.CartController;
import com.bootcamp.shopping.model.Cart;
import com.bootcamp.shopping.repository.CartRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CartControllerTest {
	@Mock
	CartRepository cartRepository = mock(CartRepository.class);

	@Test//Si le mando el mock al controlador me dice nullPointerException
	//Si no le mando me compara cualquier cosa en el assert
	public void whenAllCartsAreRequestedThenAListOfAllCartsIsReturned() {
		CartController cartController = new CartController();
		cartController.setCartRepository(cartRepository);
		List<Cart> carts = new ArrayList<>();
		Cart cart= new Cart(12, 12.5, "Cash", false, null);
		carts.add(cart);
		when(cartRepository.findAll()).thenReturn(carts);
		Assert.assertEquals(carts,cartController.getAllCarts());
		Mockito.verify(cartRepository).findAll();
	}

	@Test
	public void whenAnSpecificCartIsRequestedThenThatCartIsReturned(){
		CartController cartController = new CartController();
		cartController.setCartRepository(cartRepository);
		Cart cart= new Cart(12, 12.5, "Cash", false, null);
		long id = 12;
		when(cartRepository.findById(id)).thenReturn(cart);
		Assert.assertEquals(cart.getIdCart(),cartController.getCartById(id).getIdCart());
		Mockito.verify(cartRepository).findById(id);
	}

	@Test
	public void whenANewCartIsCreatedThenItIsSavedOnDatabase(){
		CartController cartController = new CartController();
		Cart cart= new Cart(12, 12.5, "Cash", false, null);
		cartController.setCartRepository(cartRepository);
		when(cartRepository.save(cart)).thenReturn(cart);
		Assert.assertEquals(cart,cartController.createCart(cart));
		Mockito.verify(cartRepository).save(cart);
	}

	@Test
	public void whenAnExistingCartIsUpdatedThenTheCartParamsAreUpdated(){
		CartController cartController = new CartController();
		Cart cart= new Cart(12, 12.5, "Cash", false, null);
		cartController.setCartRepository(cartRepository);
		when(cartRepository.save(cart)).thenReturn(cart);
		Assert.assertEquals(cart,cartController.updateCart(12,cart));
		Mockito.verify(cartRepository).save(cart);
	}

	@Test
	public void whenAnExistingCartIsRequestedToBeDeletedThenItIsEliminatedFromDatabase(){
		CartController cartController = new CartController();
		Cart cart= new Cart(12, 12.5, "Cash", false, null);
		cart.setIdCart(12);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",true);
		cartController.setCartRepository(cartRepository);
		when(cartRepository.delete(cart)).thenReturn(true);
		Assert.assertEquals(response,cartController.deleteCart(cart.getIdCart()));
		Mockito.verify(cartRepository).delete(cart);
		Mockito.verify(cartRepository).findById(cart.getIdCart());

	}

}
