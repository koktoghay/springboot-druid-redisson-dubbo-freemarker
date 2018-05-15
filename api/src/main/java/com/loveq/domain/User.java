package com.loveq.domain;

import com.loveq.domain.vo.CommonVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class User extends CommonVO implements Serializable {

    private static final long serialVersionUID = 2611327958778726973L;

    /**
     *
     */
    private Integer id;

    /**
     * 用户号
     */
    @Length(max = 64)
    private String userNo;

    /**
     * 传给第三方的外部用户号,唯一
     */
    @Length(max = 128)
    private String autoCheckNo;

    /**
     * 密码的盐
     */
    @Length(max = 256)
    private String ecCode;

    /**
     * 用户手机,用于用户登录场景
     */
    @Length(max = 11)
    private String mobile;

    /**
     * 密码
     */
    @Length(max = 32)
    private String password;

    /**
     * 用户注册时间
     */
    private Date createTime;

    /**
     * 用户状态:@Enum(UserStatus:1,normal,正常;2,login_locked,登陆锁定;3,order_locked,下单锁定;4,deleted,删除)
     */
    private UserStatus status;

    /**
     * 锁定原因
     */
    @Length(max = 300)
    private String lockReason;

    /**
     * A/B测试资源等级
     */
    @Length(max = 20)
    private String abLevel;

    /**
     * 头像
     */
    @Length(max = 256)
    private String headIco;

    /**
     * 用户昵称
     */
    @Length(max = 1000)
    private String nickname;

    /**
     * 用户性别:@Enum(Sex:1,male,男;2,female,女)
     */
    private Sex sex;

    /**
     * 恋爱状态:@Enum(UserLoveState:1,single,单身狗;2,non_single,已脱单)
     */
    private UserLoveState loveState;

    /**
     * 最喜欢吃的零食
     */
    @Length(max = 32)
    private String favoriteSnacks;

    /**
     * 用户加V认证信息描述
     */
    @Length(max = 20)
    private String plusvCertificationInfo;

    /**
     * Email,用于用户登录
     */
    @Length(max = 50)
    private String email;

    /**
     * 学校ID
     */
    private Integer areaId;

    /**
     * 推荐人id
     */
    private Integer recommendUserId;

    /**
     * 推荐返现总额
     */
    private BigDecimal recommendBalance;

    /**
     * 账户id
     */
    private Integer accountId;

    /**
     * @Boolean:是否切加密新算法标志
     */
    private Boolean upgradeFlag;

    /**
     * 上次登陆时间(最后一次登陆时间)
     */
    private Date lastLoginTime;
}
