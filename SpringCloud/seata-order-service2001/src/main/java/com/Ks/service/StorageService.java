package com.Ks.service;

import com.Ks.Utils.Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname StorageService
 * @Date 2021/10/31 15:34
 * @Created Ks
 */
@FeignClient("seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    Dto decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}