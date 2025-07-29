package com.riyas.ecommerce.products;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Category {
  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "category")
  private List<Products> products;
}
