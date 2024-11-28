package org.rabin.product.category;


/*
 * @author : rabin
 */

import jakarta.persistence.*;
import lombok.*;
import org.rabin.product.products.Product;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
     @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;


}
