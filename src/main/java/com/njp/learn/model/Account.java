package com.njp.learn.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by niejinping on 2016/7/30.
 */
@Data
public class Account implements Serializable {
    static final long serialVersionUID = 42L;
    private String name;
}
