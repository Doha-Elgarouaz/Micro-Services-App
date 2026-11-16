
package net.elgarouaz.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import net.elgarouaz.billingservice.model.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductItem {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private int quantity;

    private double price;

    @ManyToOne
    @JsonBackReference
    private Bill bill;
    @Transient
    private Product product;
}
