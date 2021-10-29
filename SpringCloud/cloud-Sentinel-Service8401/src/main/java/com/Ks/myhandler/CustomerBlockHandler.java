package com.Ks.myhandler;

import com.Ks.Utils.Dto;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Classname CustomerBlockHandler
 * @Date 2021/10/29 18:13
 * @Created Ks
 */
public class CustomerBlockHandler {
    public static Dto handlerException(BlockException exception) {
        return new Dto(444, "handlerException------1");
    }

    public static Dto handlerException2(BlockException exception) {
        return new Dto(444,  "handlerException------2");
    }
}
