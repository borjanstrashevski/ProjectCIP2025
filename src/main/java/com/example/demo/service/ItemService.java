package com.example.demo.service;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// This class is for business logic for Item.
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    // Constructor for service. It get ItemRepository.
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // This method get all items for one auction.
    public List<Item> getItemsByAuction(Long auctionId) {
        return itemRepository.findByAuctionId(auctionId);
    }

    // This method add new item.
    public void addItem(ItemRequest itemRequest) {
        Item item = new Item();
        item.setAuctionId(itemRequest.getAuctionId());
        item.setName(itemRequest.getName());
        item.setDescription(itemRequest.getDescription());
        item.setStartingPrice(itemRequest.getStartingPrice());
        item.setCurrentPrice(itemRequest.getStartingPrice());
        item.setStatus("available");
        itemRepository.save(item);
    }

    // This method delete item by id.
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
