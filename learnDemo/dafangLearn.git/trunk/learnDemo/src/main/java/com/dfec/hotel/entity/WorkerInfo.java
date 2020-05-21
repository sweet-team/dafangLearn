package com.dfec.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.dfec.hotel.auth.OAuth2Token;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * <p>
 * 工作人员信息表
 * </p>
 *
 * @author lixue
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description = "员工实体")
public class WorkerInfo  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作员id
     */
    @TableId(value = "worker_id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer workerId;

    /**
     * 角色:worker/admin
     */
    @ApiModelProperty(value = "角色，有admin与ordinary", required = true)
    private String role;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 部门
     */
    @ApiModelProperty(hidden = true)
    private Integer department;

    /**
     * 邮箱地址
     */
    @ApiModelProperty(hidden = true)
    private String email;

    /**
     * 地址
     */
    @ApiModelProperty(hidden = true)
    private String address;

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
