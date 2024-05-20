package com.sparta.hh99market.dto;

import com.sparta.hh99market.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
  private int id;
  private String username;
  private String title;
  private String content;
  private int price;

  public ItemResponseDto(Item item) {
    this.id = item.getId();
    this.username = item.getUsername();
    this.title = item.getTitle();
    this.content = item.getContent();
    this.price = item.getPrice();
  }
}
