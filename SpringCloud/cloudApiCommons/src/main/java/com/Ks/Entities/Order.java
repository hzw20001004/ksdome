package com.Ks.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Date 2021/10/32 15:17
 * @Created Ks
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 用户 ID
	 */
	private Long userId;

	/**
	 * 产品 ID
	 */
	private Long productId;

	/**
	 * 数量
	 */
	private Integer count;

	/**
	 * 价格
	 */
	private BigDecimal money;

	/**
	 * 订单状态：0：创建中；1：已完结
	 */
	private Integer status;
}