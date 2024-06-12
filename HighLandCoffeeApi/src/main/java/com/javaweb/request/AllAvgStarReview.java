package com.javaweb.request;

import java.math.BigDecimal;

public class AllAvgStarReview {

    private String product_id;
    private BigDecimal star;
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
    public AllAvgStarReview(String product_id, BigDecimal star) {
        this.product_id = product_id;
        this.star = star;
    }

    

}
