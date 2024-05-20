package com.sparta.hh99market.entity;

import com.sparta.hh99market.dto.ItemRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "username", nullable = false)
  private String username;
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "content", nullable = false, length = 1000)
  private String content;
  @Column(name = "price", nullable = false)
  private int price;

  public Item(ItemRequestDto requestDto) {
    this.username = requestDto.getUsername();
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.price = requestDto.getPrice();
  }

  public void update(ItemRequestDto requestDto) {
    this.username = requestDto.getUsername();
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.price = requestDto.getPrice();
  }
}
