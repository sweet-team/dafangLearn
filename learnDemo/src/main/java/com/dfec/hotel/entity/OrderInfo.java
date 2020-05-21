package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 预订方式
     */
    private String orderType;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 房间数
     */
    private Integer numOfRoom;

    /**
     * 预订日期
     */
    private LocalDate orderDate;

    /**
     * 预定天数
     */
    private Integer orderDays;

    /**
     * 订单状态:0-已下单，1-已付款，2-已消费，-1-已取消，-2-被删除
     */
    private Integer orderStatus;

    /**
     * 订单费用
     */
    private Double orderCost;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
