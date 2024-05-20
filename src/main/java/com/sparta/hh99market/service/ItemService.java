package com.sparta.hh99market.service;

import com.sparta.hh99market.dto.ItemRequestDto;
import com.sparta.hh99market.dto.ItemResponseDto;
import com.sparta.hh99market.entity.Item;
import com.sparta.hh99market.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public ItemResponseDto createItem(ItemRequestDto requestDto) {
    Item item = new Item(requestDto);

    Item saveItem = itemRepository.save(item);

    ItemResponseDto itemResponseDto = new ItemResponseDto(saveItem);

    return itemResponseDto;
  }

  public List<ItemResponseDto> getItems() {
    return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
  }

  @Transactional
  public int updateItem(int id, ItemRequestDto requestDto) {
    Item item = findItem(id);

    item.update(requestDto);

    return id;
  }

  public int deleteItem(int id) {
    Item item = findItem(id);

    itemRepository.delete(item);

    return id;
  }

  private Item findItem(int id) {
    return itemRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("선택한 상품이 존재하지 않습니다.")
    );
  }
}
