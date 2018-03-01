package com.github.gary.req;

public class MusicUrlReq {
    private String[] ids;
    private int br;
    private String csrf_token;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }

    public String getCsrf_token() {
        return csrf_token;
    }

    public void setCsrf_token(String csrf_token) {
        this.csrf_token = csrf_token;
    }
}
