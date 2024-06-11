package com.javaweb.request;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AvgReviewRequest {
    private BigDecimal star;
    private BigInteger count;

    public AvgReviewRequest(BigDecimal star, BigInteger count) {
        this.star = star;
        this.count = count;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
}
