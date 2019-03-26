package com.supeng.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ABusUser {
    private Integer id;

    private String username;

    private String password;

    private String telephone;

    private Integer userType;

    private Integer isDelete;

    private String createTime;

    public ABusUser(String username, String password, String telephone, Integer userType, Integer isDelete, String createTime) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.userType = userType;
        this.isDelete = isDelete;
        this.createTime = createTime;
    }
}