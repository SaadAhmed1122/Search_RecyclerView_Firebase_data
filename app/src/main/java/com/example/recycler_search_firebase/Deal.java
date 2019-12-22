package com.example.recycler_search_firebase;

public class Deal {
    private String pro_name;
    private String pro_desc;

    public Deal() {
    }

    public Deal(String pro_name, String pro_desc) {
        this.pro_name = pro_name;
        this.pro_desc = pro_desc;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_desc() {
        return pro_desc;
    }

    public void setPro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }


}
