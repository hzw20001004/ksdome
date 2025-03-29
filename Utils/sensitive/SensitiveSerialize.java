/*
 *    Copyright (c) 2018-2025, sig All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: sig
 */

package com.ks.Web.handler.sensitive;

import cn.hutool.core.util.DesensitizedUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.diboot.core.service.DictionaryService;
import com.diboot.core.util.ContextHelper;
import com.diboot.core.vo.LabelValue;
import com.diboot.iam.entity.IamRole;
import com.diboot.iam.entity.IamUser;
import com.diboot.iam.entity.SystemConfig;
import com.diboot.iam.mapper.SystemConfigMapper;
import com.diboot.iam.service.IamPositionService;
import com.diboot.iam.service.IamUserRoleService;
import com.diboot.iam.util.IamSecurityUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author sig
 * @date 2019-08-13
 * <p>
 * 脱敏序列化
 */
@NoArgsConstructor
@AllArgsConstructor
@Service
public class SensitiveSerialize extends JsonSerializer<String> implements ContextualSerializer {

	private SensitiveTypeEnum type;

	private Integer prefixNoMaskLen;

	private Integer suffixNoMaskLen;

	private String maskStr;

//	@Autowired
//	private IamUserRoleService iamUserRoleService;

	@Override
	public void serialize(final String origin, final JsonGenerator jsonGenerator,
			final SerializerProvider serializerProvider) throws IOException {
		SystemConfigMapper bean = ContextHelper.getBean(SystemConfigMapper.class);
		SystemConfig shujujiami = bean.selectOne(new LambdaQueryWrapper<SystemConfig>().eq(SystemConfig::getType, "SHUJUJIAMI"));
		if (!shujujiami.getValue().equals("1")){
			jsonGenerator
					.writeString(DesensitizedUtils.desValue(origin, 30, 30, maskStr));
			return;
		}

//		ContextHelper.getBean(.class);
		switch (type) {
			case CHINESE_NAME:
				jsonGenerator.writeString(DesensitizedUtils.chineseName(origin));
				break;
			case ID_CARD:
				jsonGenerator.writeString(DesensitizedUtils.idCardNum(origin));
				break;
			case FIXED_PHONE:
				jsonGenerator.writeString(DesensitizedUtils.fixedPhone(origin));
				break;
			case MOBILE_PHONE:
				jsonGenerator.writeString(DesensitizedUtils.mobilePhone(origin));
				break;
			case ADDRESS:
				jsonGenerator.writeString(DesensitizedUtils.address(origin));
				break;
			case EMAIL:
				jsonGenerator.writeString(DesensitizedUtils.email(origin));
				break;
			case BANK_CARD:
				jsonGenerator.writeString(DesensitizedUtils.bankCard(origin));
				break;
			case PASSWORD:
				jsonGenerator.writeString(DesensitizedUtils.password(origin));
				break;
			case KEY:
				jsonGenerator.writeString(DesensitizedUtils.key(origin));
				break;
			case IPV4:
				jsonGenerator.writeString(DesensitizedUtils.ipv4(origin));
				break;
			case CAR_LICENSE:
				jsonGenerator.writeString(DesensitizedUtil.carLicense(origin));
				break;
			case CUSTOMER:
				jsonGenerator
					.writeString(DesensitizedUtils.desValue(origin, prefixNoMaskLen, suffixNoMaskLen, maskStr));
				break;
			default:
				throw new IllegalArgumentException("Unknow sensitive type enum " + type);
		}
	}

	@Override
	public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider,
			final BeanProperty beanProperty) throws JsonMappingException {
		if (beanProperty != null) {
			if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
				Sensitive sensitive = beanProperty.getAnnotation(Sensitive.class);
				if (sensitive == null) {
					sensitive = beanProperty.getContextAnnotation(Sensitive.class);
				}
				if (sensitive != null) {
					return new SensitiveSerialize(sensitive.type(), sensitive.prefixNoMaskLen(),
							sensitive.suffixNoMaskLen(), sensitive.maskStr());
				}
			}
			return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
		}
		return serializerProvider.findNullValueSerializer(null);
	}

}
