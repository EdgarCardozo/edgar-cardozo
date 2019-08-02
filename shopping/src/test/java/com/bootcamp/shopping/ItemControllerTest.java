package com.bootcamp.shopping;

import com.bootcamp.shopping.controller.ItemController;
import com.bootcamp.shopping.model.Item;
import com.bootcamp.shopping.repository.ItemRepository;
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
public class ItemControllerTest {

    @Mock
    ItemRepository itemRepository = mock(ItemRepository.class);

    @Test
    public void whenAllItemsAreRequestedThenAListOfItemsAreReturned(){
        ItemController itemController = new ItemController();
        itemController.setItemRepository(itemRepository);
        List<Item> items = new ArrayList<>();
        Item item= new Item(14.5,"Shampoo",14);
        items.add(item);
        when(itemRepository.findAll()).thenReturn(items);
        Assert.assertEquals(items,itemController.getAllItems());
        Mockito.verify(itemRepository).findAll();
    }

    @Test
    public void whenAnSpecificItemIsRequestedThenThatItemIsReturned(){
        ItemController itemController = new ItemController();
        itemController.setItemRepository(itemRepository);
        Item item= new Item(14.5,"Shampoo",14);
        when(itemRepository.findById(14)).thenReturn(item);
        Assert.assertEquals(item,itemController.getItem(14));
        Mockito.verify(itemRepository).findById(14);
    }

    @Test
    public void whenANewItemIsCreatedThenItIsSavedOnDatabase(){
        ItemController itemController = new ItemController();
        itemController.setItemRepository(itemRepository);
        Item item= new Item(14.5,"Shampoo",14);
        when(itemRepository.save(item)).thenReturn(item);
        Assert.assertEquals(item,itemController.addItem(item));
        Mockito.verify(itemRepository).save(item);
    }

    @Test
    public void whenANewItemIsUpdatedThenItemsParamsAreUpdated(){
        ItemController itemController = new ItemController();
        itemController.setItemRepository(itemRepository);
        Item item= new Item(14.5,"Shampoo",14);
        when(itemRepository.findById(14)).thenReturn(item);
        when(itemRepository.save(item)).thenReturn(item);
        Assert.assertEquals(item,itemController.updateItem(14,item));
        Mockito.verify(itemRepository).save(item);
        Mockito.verify(itemRepository).findById(14);
    }

    @Test
    public void whenANewItemIsRequestedToBeDeletedThenItIsEliminatedFromDatabase(){
        ItemController itemController = new ItemController();
        itemController.setItemRepository(itemRepository);
        Item item= new Item(14.5,"Shampoo",14);
        when(itemRepository.findById(14)).thenReturn(item);
        when(itemRepository.delete(item)).thenReturn(true);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        Assert.assertEquals(response,itemController.deleteItem(item.getId()));
        Mockito.verify(itemRepository).findById(14);
        Mockito.verify(itemRepository).delete(item);

    }


}
