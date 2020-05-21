package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 入住退房登记表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "检查入住")
public class CheckIn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 入住id
     */
    @TableId(value = "check_in_id", type = IdType.AUTO)
    private Integer checkInId;

    /**。
     * 订单号
     */
    private Integer orderId;

    /**
     * 房间号
     */
    private String roomNumber;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 入住人数
     */
    private Integer peoCount;

    /**
     * 入住人
     */
    private String persons;

    /**
     * 身份证号
     */
    private String ids;

    /**
     * 入住时间
     */
    private LocalDateTime checkInTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
