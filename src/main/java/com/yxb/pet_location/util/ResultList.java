package com.yxb.pet_location.util;

import lombok.Data;

/**
 * @author yxb
 * @create 2021-08-17 22:56
 */

@Data
public class ResultList {
        private int code;
        private String msg;
        private long count;
        private Object data;
}
