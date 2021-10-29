package com.kedar.ecommerce.TO;

import com.kedar.ecommerce.domain.Supplier;
import lombok.Builder;

import java.util.Date;
import java.util.List;


@Builder
public class ProductTO {

    private String name;

    private Double price;

    private Double weight;

    private String description;

    private Date createDate;

    private Integer stock;

    private List<SupplierTO> suppliers;

    private Supplier.SupplierType category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<SupplierTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierTO> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier.SupplierType getCategory() {
        return category;
    }

    public void setCategory(Supplier.SupplierType category) {
        this.category = category;
    }
}
