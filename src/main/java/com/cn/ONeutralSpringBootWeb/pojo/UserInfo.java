package com.cn.ONeutralSpringBootWeb.pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 管理员信息
 */
@Data
public class UserInfo {
    private Integer id;
    private String email;
    private String loginPassword;
    private String nickName;
    private String loginRole;
    private Integer status;

    public UserInfo(String email, String loginPassword, String nickName) {
        this.email = email;
        this.loginPassword = loginPassword;
        this.nickName = nickName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getNickName() {
        return nickName;
    }


    public String getLoginRole() {
        return loginRole;
    }

    public void setLoginRole(String loginRole) {
        this.loginRole = loginRole;
    }

    public Integer getStatus() {
        return status;
    }
}
