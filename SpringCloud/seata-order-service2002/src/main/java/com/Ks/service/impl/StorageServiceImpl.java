package com.Ks.service.impl;

import com.Ks.dao.StorageDao;
import com.Ks.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname StorageServiceImpl
 * @Date 2021/10/31 15:44
 * @Created Ks
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("-------> storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        LOGGER.info("-------> storage-service中扣减库存结束");
    }
}
