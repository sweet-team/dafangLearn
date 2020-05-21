package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 酒店信息表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("hotel_info")
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 酒店id
     */
    @TableId(value = "hotel_id", type = IdType.AUTO)
    private Integer hotelId;

    /**
     * 酒店名
     */
    private String hotelName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 网站
     */
    private String website;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
