package cn.siginfo.sig.cps.pattern.userOrder.service.Impl;
import cn.siginfo.sig.common.core.util.R;
import cn.siginfo.sig.cps.dto.ypp.giftCard.GiftCardOrderSumbitDto;
import cn.siginfo.sig.cps.entity.YppCardOrderSumEntity;
import cn.siginfo.sig.cps.entity.card.YppCardPlatformRelationEntity;
import cn.siginfo.sig.cps.entity.coupons.YppCouponsEntity;
import cn.siginfo.sig.cps.entity.coupons.YppUserCouponsEntity;
import cn.siginfo.sig.cps.entity.coupons.YppUserOrderEntity;
import cn.siginfo.sig.cps.mapper.YppCouponsMapper;
import cn.siginfo.sig.cps.mapper.YppUserCouponsMapper;
import cn.siginfo.sig.cps.mapper.YppUserOrderMapper;
import cn.siginfo.sig.cps.pattern.userOrder.factory.YppChannel;
import cn.siginfo.sig.cps.pattern.userOrder.service.UserOrderStrategy;
import cn.siginfo.sig.cps.service.YppCardOrderSumService;
import cn.siginfo.sig.cps.service.YppCouponsService;
import cn.siginfo.sig.cps.utils.RedissonUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesUserOrderStrategyImpl extends CardUserOrderStrategyAbs  {

    private final RedissonUtils redissonUtils;

    @Override
    public String getEnumsType() {
        return YppChannel.YPP_Movies.getCode();
    }

    @Override
    public R payOrder(GiftCardOrderSumbitDto giftCardOrderSumbitDto,Boolean toPay) {
        String txgNo = giftCardOrderSumbitDto.getTxgNo();
        boolean locked = false; //锁状态
        try {
            //加锁，设置锁超时时间（10秒）,等待锁的时间（2秒）
            //一个规则只能存在一个锁
            locked = redissonUtils.tryLock(getEnumsType() + txgNo, 2, 10);
            if (locked) {
                    return R.ok(yppUserCouponsEntity.getId());
                } else {
                    return R.ok(yppUserOrderEntity.getId(), "该券已存在");
                }
            } else {
                return R.ok("订单重复,已拦截");
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
            return R.ok("订单下单失败");
        } finally {
            if (locked) {
                try {
                    this.redissonUtils.unlock(getEnumsType() + txgNo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void cardPriceClean(List<YppCardPlatformRelationEntity> entityList) {

    }
}
