package com.Ks.controller;

import com.Ks.Utils.Dto;
import com.Ks.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname StorageController
 * @Date 2021/10/31 15:41
 * @Created Ks
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public Dto decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new Dto<>(200,"扣减库存成功！");
    }
}
