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
 * 预订方式表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * typeId
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 方式
     */
    private String type;

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
