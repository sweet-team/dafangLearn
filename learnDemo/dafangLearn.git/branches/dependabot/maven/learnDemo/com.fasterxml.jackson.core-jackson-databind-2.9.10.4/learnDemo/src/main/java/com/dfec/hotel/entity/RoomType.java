package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 房间类型表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "房间类型")
public class RoomType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型ID
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long typeId;

    /**
     * 类型名
     */
    private String roomType;

    /**
     * 房型备注
     */
    @ApiModelProperty(hidden = true)
    private String remark;

    /**
     * 预定价格
     */
    private Double price;

    /**
     * 预定折扣
     */
    @ApiModelProperty(hidden = true)
    private Double discount;

    /**
     * 房间大小:m2
     */
    @ApiModelProperty(hidden = true)
    private Integer area;

    /**
     * 床位
     */
    private Integer bedNum;

    /**
     * 床位大小
     */
    @ApiModelProperty(hidden = true)
    private String bedSize;

    /**
     * 是否有窗：0-无，1-有
     */
    @ApiModelProperty(value = "是否有窗：0-无，1-有")
    private Integer window;

    /**
     * 创建时间
     */
    @ApiModelProperty(hidden = true)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(hidden = true)
    private LocalDateTime updateTime;

}
