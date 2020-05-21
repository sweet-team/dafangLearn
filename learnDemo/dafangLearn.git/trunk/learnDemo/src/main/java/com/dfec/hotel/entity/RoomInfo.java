package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房间信息表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoomInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 房间id
     */
    @TableId(value = "room_id", type = IdType.AUTO)
    private Integer roomId;

    /**
     * 房间号码
     */
    private String roomNumber;

    /**
     * 房间类型ID
     */
    private Integer typeId;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 房间价格
     */
    private Double roomPrice;

    /**
     * 房间折扣
     */
    private Double roomDiscount;

    /**
     * 房间状态:1-可预订，0-已被预订，-1：已入住，-2：不可用
     */
    private Integer roomStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
