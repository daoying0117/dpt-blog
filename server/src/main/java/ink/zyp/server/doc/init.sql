-- 管理员表
create table sys_admin
(
    id          int auto_increment comment '用户id'
        primary key,
    name        varchar(64)   null comment '用户名',
    password    varchar(64)   null comment '密码',
    status      int default 0 null comment '0:未初始化;1:正常,-1禁用',
    nick_name   varchar(64)   null comment '用户昵称',
    head_img    text          null comment '头像图片url',
    error_num   int default 0 null comment '登录错误次数',
    sub_account int default 0 null comment '是否是子账户0: 是1:不是',
    back_img    text          null comment '背景图片',
    motto       text          null comment '座右铭/个性签名',
    email       varchar(64)   null comment '邮箱',
    phone       varchar(32)   null comment '手机号',
    constraint sys_admin_id_uindex
        unique (id)
)
    comment '管理员表';

INSERT INTO dpt.sys_admin (id, name, password, status, nick_name, head_img, error_num, sub_account, back_img, motto, email, phone) VALUES (1, 'daoying', '19fb609f5539ca4579615708e05bed92', 0, '', '', 0, 0, '', '', '3184318099@qq.com', '15046016540');
