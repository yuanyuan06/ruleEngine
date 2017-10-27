############### table create sql generate start #################

create table ${tableName} (
        id bigint(20) not null auto_increment comment '主键',
    <#list attrs as attr>
        ${attr.field} ${attr.type} ${attr.extend}  comment '注释',
    </#list>
        create_user bigint(20) null default null comment '创建人',
        create_time datetime not null comment '创建时间',
        last_modify_user bigint(20) null default null comment '最后修改人',
        last_modify_time datetime not null comment '最后修改时间',
        version bigint(20) not null default 0 comment '版本控制',
        PRIMARY KEY (`id`)
)
COMMENT='注释'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;

############### table create sql generate end   #################