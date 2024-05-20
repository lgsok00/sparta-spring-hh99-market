package com.sparta.hh99market.controller;

import com.sparta.hh99market.dto.ItemRequestDto;
import com.sparta.hh99market.dto.ItemResponseDto;
import com.sparta.hh99market.entity.Item;
import com.sparta.hh99market.service.ItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @PostMapping("/post")
  public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
    return itemService.createItem(requestDto);
  }

  @GetMapping("/post")
  public List<ItemResponseDto> getItems() {
    return itemService.getItems();
  }

  @PutMapping("/post/{id}")
  public int updateItem(@PathVariable int id, @RequestBody ItemRequestDto requestDto) {
    return itemService.updateItem(id, requestDto);
  }

  @DeleteMapping("/post/{id}")
  public int deleteItem(@PathVariable int id) {
    return itemService.deleteItem(id);
  }
}
