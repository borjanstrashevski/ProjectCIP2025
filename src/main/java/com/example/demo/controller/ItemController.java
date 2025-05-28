package com.example.demo.controller;

import com.example.demo.dto.ItemRequest;
import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This controller is for Item endpoints. It handle HTTP request for items.
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService itemService;

    // Constructor for controller. It get ItemService.
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // This endpoint get all items for one auction.
    @GetMapping("/auction/{auctionId}")
    public List<Item> getItemsByAuction(@PathVariable Long auctionId) {
        return itemService.getItemsByAuction(auctionId);
    }

    // This endpoint add new item.
    @PostMapping
    public void addItem(@RequestBody ItemRequest itemRequest) {
        itemService.addItem(itemRequest);
    }

    // This endpoint delete item by id.
    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }
}
