package com.javaweb.request;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ReviewProductRequest {
    private String product_id;
    private BigDecimal star;
    private String content;
    private String customer_name;
    private Timestamp date;

    public ReviewProductRequest(String product_id, BigDecimal star, String content, String customer_name, Timestamp date) {
        this.product_id = product_id;
        this.star = star;
        this.content = content;
        this.customer_name = customer_name;
        this.date = date;
    }

    public Timestamp  getDate() {
        return date;
    }

    public void setDate(Timestamp  date) {
        this.date = date;
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
