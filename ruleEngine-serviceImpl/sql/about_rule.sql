create table rule_snippet (
  id bigint(20) not null auto_increment comment '主键',
  doc_num varchar(20)  comment '编码',
  description varchar(200)  comment '描述',
  script varchar(20)  comment '脚本',
  create_user bigint(20) null default null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_modify_user bigint(20) null default null comment '最后修改人',
  last_modify_time datetime not null comment '最后修改时间',
  version bigint(20) not null default 0 comment '版本控制',
  PRIMARY KEY (`id`)
)
COMMENT='规则片段'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;


create table rule_stage (
  id bigint(20) not null auto_increment comment '主键',
  doc_num varchar(20)  comment '编码',
  description varchar(200)  comment '描述',
  create_user bigint(20) null default null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_modify_user bigint(20) null default null comment '最后修改人',
  last_modify_time datetime not null comment '最后修改时间',
  version bigint(20) not null default 0 comment '版本控制',
  PRIMARY KEY (`id`)
)
COMMENT='stage'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;

create table shop_stage_rel (
  id bigint(20) not null auto_increment comment '主键',
  priority smallint(5) unsigned comment '优先级',
  shop_num varchar(20)  comment '店铺编码',
  stage_num varchar(20)  comment 'stage编码',
  create_user bigint(20) null default null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_modify_user bigint(20) null default null comment '最后修改人',
  last_modify_time datetime not null comment '最后修改时间',
  version bigint(20) not null default 0 comment '版本控制',
  PRIMARY KEY (`id`)
)
COMMENT='stage shop 关系表'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;

create table stage_snippet_rel (
  id bigint(20) not null auto_increment comment '主键',
  priority smallint(5) unsigned comment '优先级',
  snippet_num varchar(20)  comment 'snippet编码',
  stage_num varchar(20)  comment 'stage 编码',
  create_user bigint(20) null default null comment '创建人',
  create_time datetime not null comment '创建时间',
  last_modify_user bigint(20) null default null comment '最后修改人',
  last_modify_time datetime not null comment '最后修改时间',
  version bigint(20) not null default 0 comment '版本控制',
  PRIMARY KEY (`id`)
)
COMMENT='snippet stage 关联关系'
ENGINE=InnoDB
COLLATE='utf8_general_ci'
;