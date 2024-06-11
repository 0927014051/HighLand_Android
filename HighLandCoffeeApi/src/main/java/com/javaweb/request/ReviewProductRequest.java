package com.javaweb.request;

import java.math.BigDecimal;

public class ReviewProductRequest {
    private String product_id;
    private BigDecimal star;
    private String content;
    private String customer_name;

    public ReviewProductRequest(String product_id, BigDecimal star, String content, String customer_name) {
        this.product_id = product_id;
        this.star = star;
        this.content = content;
        this.customer_name = customer_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}
