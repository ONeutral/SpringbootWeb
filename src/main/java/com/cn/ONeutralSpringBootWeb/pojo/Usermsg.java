package com.cn.ONeutralSpringBootWeb.pojo;

public class Usermsg {
    private Integer id;
    private String username;
    private String userUrl;
    public Usermsg(String username, Integer id, String userUrl) {
        this.username = username;
        this.id=id;
        this.userUrl=userUrl;
    }
}
