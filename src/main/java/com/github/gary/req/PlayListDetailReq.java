package com.github.gary.req;

public class PlayListDetailReq {
    private String id;
    private int offset;
    private boolean total;
    private int limit;
    private int n;
    private String csrf_token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getCsrf_token() {
        return csrf_token;
    }

    public void setCsrf_token(String csrf_token) {
        this.csrf_token = csrf_token;
    }
}
