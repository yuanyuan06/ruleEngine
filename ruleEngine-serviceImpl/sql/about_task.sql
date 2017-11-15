create table human_task (
        id bigint(20) not null auto_increment comment '主键',
        doc_num varchar(20)  comment '编码',
        name varchar(20)  comment '任务名称',
        orde_id bigint(20)  comment '单据id',
        order_type smallint(20)  comment '单据类型',
        role varchar(20)  comment '所属角色',
        status smallint(20)  comment '状态',
        type smallint(20)  comment '任务类型',
        user bigint(20)  comment '所属用户',
        create_user bigint(20) null default null comment '创建人',
        create_time datetime not null comment '创建时间',
        last_modify_user bigint(20) null default null comment '最后修改人',
        last_modify_time datetime not null comment '最后修改时间',
        version bigint(20) not null default 0 comment '版本控制',
        PRIMARY KEY (`id`)
)
COMMENT='人工任务'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;


create table incident (
        id bigint(20) not null auto_increment comment '主键',
        doc_num varchar(20)  comment '编码',
        inducement varchar(20)  comment '原因',
        name varchar(20)  comment '名称',
        order_item bigint(20)  comment '单据明细',
        task_id bigint(20)  comment '所属任务id',
        create_user bigint(20) null default null comment '创建人',
        create_time datetime not null comment '创建时间',
        last_modify_user bigint(20) null default null comment '最后修改人',
        last_modify_time datetime not null comment '最后修改时间',
        version bigint(20) not null default 0 comment '版本控制',
        PRIMARY KEY (`id`)
)
COMMENT='触发任务事件'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;