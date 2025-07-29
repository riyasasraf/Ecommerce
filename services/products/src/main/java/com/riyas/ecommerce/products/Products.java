package com.riyas.ecommerce.products;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Products {

    @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private String description;
  private Double availableQuantity;
  private BigDecimal price;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

}
 