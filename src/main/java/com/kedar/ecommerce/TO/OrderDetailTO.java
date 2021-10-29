package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Product;
import lombok.Builder;

@Builder
public class OrderDetailTO {

    private ProductTO product;

    private Integer quantity;

    private Double discount;

    public ProductTO getProduct() {
        return product;
    }

    public void setProduct(ProductTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}

