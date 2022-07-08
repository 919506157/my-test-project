
create table T_LIVE_ACCOUNT
(
  id             NUMBER(10) not null,
  user_id        NUMBER(10),
  wallet_id      NUMBER(10),
  account_no     VARCHAR2(128),
  account_type   VARCHAR2(2),
  account_status NUMBER(5),
  balance        NUMBER(10,2),
  frozen_balance NUMBER(10,2),
  create_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6)
)
;
comment on table T_LIVE_ACCOUNT
  is '用户主播账户表';
comment on column T_LIVE_ACCOUNT.id
  is 'id';
comment on column T_LIVE_ACCOUNT.user_id
  is '用户id';
comment on column T_LIVE_ACCOUNT.wallet_id
  is 'wallet_id';
comment on column T_LIVE_ACCOUNT.account_no
  is '账户编码';
comment on column T_LIVE_ACCOUNT.account_type
  is '账户类型：C-用户 P-平台';
comment on column T_LIVE_ACCOUNT.account_status
  is '账户状态：1 -正常 2-禁用';
comment on column T_LIVE_ACCOUNT.balance
  is '账户余额';
comment on column T_LIVE_ACCOUNT.frozen_balance
  is '冻结金额';
comment on column T_LIVE_ACCOUNT.create_time
  is '创建时间';
comment on column T_LIVE_ACCOUNT.update_time
  is '修改时间';
alter table T_LIVE_ACCOUNT
  add constraint T_LIVE_ACCOUNT_PK primary key (ID);


create table T_LIVE_ACCOUNT_CHARGE
(
  id                  NUMBER(11) not null,
  account_id          NUMBER(11),
  wallet_id           VARCHAR2(20),
  amount              NUMBER(11,2),
  status              VARCHAR2(2),
  amount_value        NUMBER(11,2),
  last_request_no     VARCHAR2(50),
  channel_order_no    VARCHAR2(50),
  charge_success_time TIMESTAMP(6),
  payment_type        VARCHAR2(20),
  create_time         TIMESTAMP(6),
  update_time         TIMESTAMP(6),
  type                NUMBER(5),
  behavior            NUMBER(5)
)
;
comment on column T_LIVE_ACCOUNT_CHARGE.account_id
  is '用户主播账户表id';
comment on column T_LIVE_ACCOUNT_CHARGE.wallet_id
  is '钱包id';
comment on column T_LIVE_ACCOUNT_CHARGE.amount
  is '充值金额';
comment on column T_LIVE_ACCOUNT_CHARGE.status
  is '充值状态：W-待处理 P-处理中-S-成功 F-失败';
comment on column T_LIVE_ACCOUNT_CHARGE.amount_value
  is '充值金额兑换金币价值';
comment on column T_LIVE_ACCOUNT_CHARGE.last_request_no
  is '最后一次充值请求号';
comment on column T_LIVE_ACCOUNT_CHARGE.channel_order_no
  is '渠道充值流水号';
comment on column T_LIVE_ACCOUNT_CHARGE.charge_success_time
  is '充值成功时间';
comment on column T_LIVE_ACCOUNT_CHARGE.payment_type
  is '支付方式';
comment on column T_LIVE_ACCOUNT_CHARGE.type
  is '1:充值';
comment on column T_LIVE_ACCOUNT_CHARGE.behavior
  is '1:充值金币';
alter table T_LIVE_ACCOUNT_CHARGE
  add constraint T_LIVE_ACCOUNT_CHARGE_PK primary key (ID);


create table T_LIVE_ACCOUNT_FLOW
(
  id             NUMBER(10) not null,
  account_id     NUMBER(10),
  amount         NUMBER(10,2),
  before_balance NUMBER(10,2),
  after_balance  NUMBER(10,2),
  biz_type       VARCHAR2(4),
  biz_code       VARCHAR2(4),
  create_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6),
  account_type   VARCHAR2(2),
  biz_order_id   NUMBER(11)
)
;
comment on table T_LIVE_ACCOUNT_FLOW
  is '账户消费流水';
comment on column T_LIVE_ACCOUNT_FLOW.id
  is 'id';
comment on column T_LIVE_ACCOUNT_FLOW.account_id
  is '账户表id';
comment on column T_LIVE_ACCOUNT_FLOW.amount
  is '发生金额（金币）';
comment on column T_LIVE_ACCOUNT_FLOW.before_balance
  is '发生前账户余额';
comment on column T_LIVE_ACCOUNT_FLOW.after_balance
  is '发生后账户余额';
comment on column T_LIVE_ACCOUNT_FLOW.biz_type
  is '业务类型：I-流入 O-流出';
comment on column T_LIVE_ACCOUNT_FLOW.biz_code
  is '业务场景码 1:送礼 2 充值 3 结算';
comment on column T_LIVE_ACCOUNT_FLOW.create_time
  is '创建时间';
comment on column T_LIVE_ACCOUNT_FLOW.update_time
  is '修改时间';
comment on column T_LIVE_ACCOUNT_FLOW.account_type
  is 'U：用户账户  R：直播间账户';
comment on column T_LIVE_ACCOUNT_FLOW.biz_order_id
  is '业务订单id';
alter table T_LIVE_ACCOUNT_FLOW
  add primary key (ID);


create table T_LIVE_CATEGORY
(
  id            NUMBER(11) not null,
  category_code VARCHAR2(20),
  category_name VARCHAR2(128),
  parent_id     NUMBER(11),
  status        NUMBER(5),
  create_time   DATE,
  update_time   DATE,
  display_order NUMBER(5)
)
;
comment on column T_LIVE_CATEGORY.category_code
  is '类别编码';
comment on column T_LIVE_CATEGORY.category_name
  is '类别名称';
comment on column T_LIVE_CATEGORY.parent_id
  is '上级类目ID';
comment on column T_LIVE_CATEGORY.status
  is '状态：1:显示， 2:隐藏';
comment on column T_LIVE_CATEGORY.create_time
  is '创建时间';
comment on column T_LIVE_CATEGORY.update_time
  is '修改时间';
comment on column T_LIVE_CATEGORY.display_order
  is '显示顺序';
alter table T_LIVE_CATEGORY
  add constraint T_LIVE_CATEGORY_PK primary key (ID);


create table T_LIVE_CHAT_ROOM
(
  id             NUMBER(11) not null,
  room_user_id   VARCHAR2(16),
  chat_room_code VARCHAR2(16),
  status         NUMBER(5),
  platform_code  NUMBER(5),
  start_time     TIMESTAMP(6),
  end_time       TIMESTAMP(6),
  max_user       NUMBER(10),
  cur_user       NUMBER(10),
  room_type      NUMBER(5),
  create_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6),
  chat_room_name VARCHAR2(256)
)
;
comment on column T_LIVE_CHAT_ROOM.room_user_id
  is '群主user_id';
comment on column T_LIVE_CHAT_ROOM.chat_room_code
  is '聊天室code';
comment on column T_LIVE_CHAT_ROOM.status
  is '状态：1-开启 2-结束 3-封禁';
comment on column T_LIVE_CHAT_ROOM.platform_code
  is '平台：1-腾讯';
comment on column T_LIVE_CHAT_ROOM.start_time
  is '开始时间';
comment on column T_LIVE_CHAT_ROOM.end_time
  is '结束时间';
comment on column T_LIVE_CHAT_ROOM.max_user
  is '最大人数';
comment on column T_LIVE_CHAT_ROOM.cur_user
  is '当前人数';
comment on column T_LIVE_CHAT_ROOM.room_type
  is '聊天室类型-取腾讯枚举';
comment on column T_LIVE_CHAT_ROOM.create_time
  is '创建时间';
comment on column T_LIVE_CHAT_ROOM.update_time
  is '修改时间';
comment on column T_LIVE_CHAT_ROOM.chat_room_name
  is '聊天室名称';
alter table T_LIVE_CHAT_ROOM
  add primary key (ID);


create table T_LIVE_COMPLAIN
(
  id                   NUMBER(10) not null,
  live_room_id         NUMBER(10),
  complain_category_id NUMBER(10),
  complain_reason      VARCHAR2(200),
  create_time          TIMESTAMP(6),
  update_time          TIMESTAMP(6),
  complain_user_id     NUMBER(10)
)
;
comment on table T_LIVE_COMPLAIN
  is '直播间投诉表';
comment on column T_LIVE_COMPLAIN.id
  is 'id';
comment on column T_LIVE_COMPLAIN.live_room_id
  is '直播间id';
comment on column T_LIVE_COMPLAIN.complain_category_id
  is '投诉类别ID';
comment on column T_LIVE_COMPLAIN.complain_reason
  is '投诉原因';
comment on column T_LIVE_COMPLAIN.complain_user_id
  is '举报人userId';
alter table T_LIVE_COMPLAIN
  add primary key (ID);


create table T_LIVE_COMPLAIN_CATEGORY
(
  id            NUMBER(10) not null,
  category_code VARCHAR2(8),
  category_name VARCHAR2(16),
  status        NUMBER(5),
  create_time   TIMESTAMP(6),
  update_time   TIMESTAMP(6)
)
;
comment on column T_LIVE_COMPLAIN_CATEGORY.id
  is 'id';
comment on column T_LIVE_COMPLAIN_CATEGORY.category_code
  is '类别编码';
comment on column T_LIVE_COMPLAIN_CATEGORY.category_name
  is '类别名称';
comment on column T_LIVE_COMPLAIN_CATEGORY.status
  is '1-生效 2-失效';
alter table T_LIVE_COMPLAIN_CATEGORY
  add primary key (ID);


create table T_LIVE_COMPLAIN_IMG
(
  id          NUMBER(10) not null,
  complain_id NUMBER(10),
  img_host    VARCHAR2(100),
  img_url     VARCHAR2(100),
  create_time TIMESTAMP(6)
)
;
comment on column T_LIVE_COMPLAIN_IMG.id
  is 'id';
comment on column T_LIVE_COMPLAIN_IMG.complain_id
  is '投诉表id';
comment on column T_LIVE_COMPLAIN_IMG.img_host
  is '截图url中host';
comment on column T_LIVE_COMPLAIN_IMG.img_url
  is '截图访问url';
comment on column T_LIVE_COMPLAIN_IMG.create_time
  is '创建时间';
alter table T_LIVE_COMPLAIN_IMG
  add primary key (ID);


create table T_LIVE_FROZEN
(
  id                NUMBER(10) not null,
  live_room_id      NUMBER(10),
  frozen_start_time TIMESTAMP(6),
  frozen_end_time   TIMESTAMP(6),
  admin_user_id     NUMBER(10),
  frozen_reason     VARCHAR2(200),
  create_time       TIMESTAMP(6),
  update_time       TIMESTAMP(6),
  status            NUMBER(5),
  live_instance_id  NUMBER(10)
)
;
comment on table T_LIVE_FROZEN
  is '直播间封禁表';
comment on column T_LIVE_FROZEN.id
  is 'id';
comment on column T_LIVE_FROZEN.live_room_id
  is '直播间id';
comment on column T_LIVE_FROZEN.frozen_start_time
  is '封禁开始时间';
comment on column T_LIVE_FROZEN.frozen_end_time
  is '封禁结束时间';
comment on column T_LIVE_FROZEN.admin_user_id
  is '封禁超管user_id';
comment on column T_LIVE_FROZEN.frozen_reason
  is '封禁原因';
comment on column T_LIVE_FROZEN.create_time
  is '创建时间';
comment on column T_LIVE_FROZEN.update_time
  is '修改时间';
comment on column T_LIVE_FROZEN.status
  is '1:正常 2：删除';
comment on column T_LIVE_FROZEN.live_instance_id
  is '直播实例id';
alter table T_LIVE_FROZEN
  add primary key (ID);


create table T_LIVE_GIFT
(
  id             NUMBER(11) not null,
  gift_code      VARCHAR2(20),
  gift_name      VARCHAR2(128),
  pic_url        VARCHAR2(512),
  gift_unit      NUMBER(20,2),
  status         VARCHAR2(2),
  create_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6),
  action_type    NUMBER(5),
  action_time    NUMBER(5,2),
  gift_tag_id    NUMBER(10),
  action_pic_url VARCHAR2(512),
  del_flg        NUMBER(5)
)
;
comment on column T_LIVE_GIFT.gift_code
  is '礼物编码';
comment on column T_LIVE_GIFT.gift_name
  is '礼物名称';
comment on column T_LIVE_GIFT.pic_url
  is '礼物图片地址';
comment on column T_LIVE_GIFT.gift_unit
  is '礼物基本价值';
comment on column T_LIVE_GIFT.status
  is '状态：1正常';
comment on column T_LIVE_GIFT.create_time
  is '创建时间';
comment on column T_LIVE_GIFT.update_time
  is '修改时间';
comment on column T_LIVE_GIFT.action_type
  is '动效类型1：gif，2：SVGA';
comment on column T_LIVE_GIFT.action_time
  is '动效时长，单位秒';
comment on column T_LIVE_GIFT.gift_tag_id
  is '礼物标签表id';
comment on column T_LIVE_GIFT.action_pic_url
  is '动效图片地址';
comment on column T_LIVE_GIFT.del_flg
  is '1：正常 2：删除';
alter table T_LIVE_GIFT
  add constraint T_LIVE_GIFT_PK primary key (ID);


create table T_LIVE_GIFT_ORDER
(
  id                NUMBER(11) not null,
  gift_num          NUMBER(5) not null,
  total_gift_value  NUMBER(18,2),
  total_gift_amount NUMBER(18,2),
  payer_id          NUMBER(11),
  payer_account_id  NUMBER(11),
  payee_id          NUMBER(11),
  payee_account_id  NUMBER(11),
  status            VARCHAR2(2),
  create_time       TIMESTAMP(6),
  update_time       TIMESTAMP(6),
  payee_total_gift  NUMBER(18,2),
  type              NUMBER(5),
  behavior          NUMBER(5)
)
;
comment on column T_LIVE_GIFT_ORDER.gift_num
  is '礼物数量';
comment on column T_LIVE_GIFT_ORDER.total_gift_value
  is '总价值';
comment on column T_LIVE_GIFT_ORDER.total_gift_amount
  is '总价值对应金额';
comment on column T_LIVE_GIFT_ORDER.payer_id
  is '付款方';
comment on column T_LIVE_GIFT_ORDER.payer_account_id
  is '付款方账户id';
comment on column T_LIVE_GIFT_ORDER.payee_id
  is '收款方';
comment on column T_LIVE_GIFT_ORDER.payee_account_id
  is '收款方账户id';
comment on column T_LIVE_GIFT_ORDER.status
  is 'W-待处理 P-处理中-S-成功 F-失败';
comment on column T_LIVE_GIFT_ORDER.payee_total_gift
  is '收款方累积礼物价值';
comment on column T_LIVE_GIFT_ORDER.type
  is '类型';
comment on column T_LIVE_GIFT_ORDER.behavior
  is '行为';
alter table T_LIVE_GIFT_ORDER
  add primary key (ID);


create table T_LIVE_GIFT_RELATION
(
  id           NUMBER(11) not null,
  gift_id      NUMBER(11),
  live_room_id NUMBER(11),
  gift_name    VARCHAR2(128),
  gift_unit    NUMBER(20,2),
  pic_url      VARCHAR2(512),
  status       VARCHAR2(2),
  create_time  DATE,
  update_time  DATE
)
;
comment on column T_LIVE_GIFT_RELATION.gift_name
  is '礼物名称';
comment on column T_LIVE_GIFT_RELATION.gift_unit
  is '礼物在直播间价值';
comment on column T_LIVE_GIFT_RELATION.pic_url
  is '礼物在直播间图片地址';
comment on column T_LIVE_GIFT_RELATION.status
  is '状态:1正常';
alter table T_LIVE_GIFT_RELATION
  add constraint T_LIVE_GIFT_RELATION_PK primary key (ID);


create table T_LIVE_GIFT_TAG
(
  id       NUMBER(10) not null,
  tag_name VARCHAR2(10)
)
;
comment on table T_LIVE_GIFT_TAG
  is '礼物标签表';
comment on column T_LIVE_GIFT_TAG.id
  is 'id';
comment on column T_LIVE_GIFT_TAG.tag_name
  is '标签名称';
alter table T_LIVE_GIFT_TAG
  add constraint T_LIVE_GIFT_TAG_PK primary key (ID);


create table T_LIVE_INSTANCE
(
  id                  NUMBER(11) not null,
  live_room_id        NUMBER(10),
  chat_room_id        NUMBER(10),
  status              NUMBER(5),
  live_start_time     TIMESTAMP(6),
  live_end_time       TIMESTAMP(6),
  hot_num             NUMBER(10),
  max_hot_num         NUMBER(10),
  message_num         NUMBER(10),
  user_num            NUMBER(10),
  max_user_num        NUMBER(10),
  gift_num            NUMBER(10),
  max_gift_num        NUMBER(10),
  create_time         TIMESTAMP(6),
  update_time         TIMESTAMP(6),
  total_gift_num      NUMBER(11),
  total_gift_value    NUMBER(18,2),
  room_title          VARCHAR2(512),
  cover_url           VARCHAR2(512),
  is_syn              NUMBER(5),
  sale_price          NUMBER(18,2),
  category_id         NUMBER(11),
  is_bring_goods      NUMBER(5) default 0,
  total_gift_senduser NUMBER(11)
)
;
comment on column T_LIVE_INSTANCE.id
  is '主键id';
comment on column T_LIVE_INSTANCE.live_room_id
  is '直播间表主键id，t_live_room';
comment on column T_LIVE_INSTANCE.chat_room_id
  is '直播间群组表主键id，t_live_chat_room';
comment on column T_LIVE_INSTANCE.status
  is '状态：1-开启 2-结束 3-封禁';
comment on column T_LIVE_INSTANCE.live_start_time
  is '开播时间';
comment on column T_LIVE_INSTANCE.live_end_time
  is '关播时间';
comment on column T_LIVE_INSTANCE.hot_num
  is '热度';
comment on column T_LIVE_INSTANCE.max_hot_num
  is '最高热度';
comment on column T_LIVE_INSTANCE.message_num
  is '聊天数';
comment on column T_LIVE_INSTANCE.user_num
  is '当前聊天室人数';
comment on column T_LIVE_INSTANCE.max_user_num
  is '聊天室最高人数';
comment on column T_LIVE_INSTANCE.gift_num
  is '当前礼物数';
comment on column T_LIVE_INSTANCE.max_gift_num
  is '最总礼物数';
comment on column T_LIVE_INSTANCE.create_time
  is '创建时间';
comment on column T_LIVE_INSTANCE.update_time
  is '修改时间';
comment on column T_LIVE_INSTANCE.total_gift_num
  is '总礼物数';
comment on column T_LIVE_INSTANCE.total_gift_value
  is '总礼物价值';
comment on column T_LIVE_INSTANCE.room_title
  is '直播间标题';
comment on column T_LIVE_INSTANCE.cover_url
  is '封面url';
comment on column T_LIVE_INSTANCE.is_syn
  is '是否同步录制：1是 0否';
comment on column T_LIVE_INSTANCE.sale_price
  is '下单金额';
comment on column T_LIVE_INSTANCE.category_id
  is '直播类别id';
comment on column T_LIVE_INSTANCE.is_bring_goods
  is '是否带货：0 不带货 1带货';
comment on column T_LIVE_INSTANCE.total_gift_senduser
  is '总送礼人数';
alter table T_LIVE_INSTANCE
  add primary key (ID);


create table T_LIVE_INSTANCE_GIFT
(
  id               NUMBER(11) not null,
  instance_id      NUMBER(10),
  gift_id          NUMBER(10),
  gift_code        NUMBER(10),
  gift_num         NUMBER(10),
  total_gift_value NUMBER(20,2),
  create_time      TIMESTAMP(6),
  update_time      TIMESTAMP(6)
)
;
comment on table T_LIVE_INSTANCE_GIFT
  is '本次直播礼物分类统计';
comment on column T_LIVE_INSTANCE_GIFT.id
  is '主键id';
comment on column T_LIVE_INSTANCE_GIFT.instance_id
  is '直播实例表主键id';
comment on column T_LIVE_INSTANCE_GIFT.gift_id
  is '礼品表主键id';
comment on column T_LIVE_INSTANCE_GIFT.gift_num
  is '送出数';
comment on column T_LIVE_INSTANCE_GIFT.total_gift_value
  is '礼品总价值';
comment on column T_LIVE_INSTANCE_GIFT.create_time
  is '创建时间';
comment on column T_LIVE_INSTANCE_GIFT.update_time
  is '修改时间';
alter table T_LIVE_INSTANCE_GIFT
  add primary key (ID);


create table T_LIVE_INSTANCE_USER_GIFT
(
  id               NUMBER(10) not null,
  instance_id      NUMBER(10),
  user_id          NUMBER(10),
  gift_num         NUMBER(10),
  total_gift_value NUMBER(20,2),
  create_time      TIMESTAMP(6),
  update_time      TIMESTAMP(6)
)
;
comment on table T_LIVE_INSTANCE_USER_GIFT
  is '用户本次直播送礼统计';
comment on column T_LIVE_INSTANCE_USER_GIFT.id
  is '主键id';
comment on column T_LIVE_INSTANCE_USER_GIFT.instance_id
  is '直播实例表主键id';
comment on column T_LIVE_INSTANCE_USER_GIFT.user_id
  is '用户id';
comment on column T_LIVE_INSTANCE_USER_GIFT.gift_num
  is '送出数';
comment on column T_LIVE_INSTANCE_USER_GIFT.total_gift_value
  is '礼物总价值';
comment on column T_LIVE_INSTANCE_USER_GIFT.create_time
  is '创建时间';
comment on column T_LIVE_INSTANCE_USER_GIFT.update_time
  is '修改时间';
alter table T_LIVE_INSTANCE_USER_GIFT
  add primary key (ID);


create table T_LIVE_MODULE
(
  id                   NUMBER(10) not null,
  module_name          VARCHAR2(16),
  module_display_order NUMBER(5),
  live_display_num     NUMBER(5),
  live_min_user        NUMBER(10),
  live_max_user        NUMBER(10),
  banner_url           VARCHAR2(100),
  sort_type            NUMBER(5),
  status               NUMBER(5),
  create_time          TIMESTAMP(6),
  update_time          TIMESTAMP(6),
  del_flg              NUMBER(5)
)
;
comment on table T_LIVE_MODULE
  is '直播模块表';
comment on column T_LIVE_MODULE.id
  is 'id';
comment on column T_LIVE_MODULE.module_name
  is '模块名称';
comment on column T_LIVE_MODULE.module_display_order
  is '模块显示顺序';
comment on column T_LIVE_MODULE.live_display_num
  is '模块显示直播间数量';
comment on column T_LIVE_MODULE.live_min_user
  is '观看人数下限';
comment on column T_LIVE_MODULE.live_max_user
  is '观看人数上限';
comment on column T_LIVE_MODULE.banner_url
  is 'banner图片URL';
comment on column T_LIVE_MODULE.sort_type
  is '直播间排序方式：1-按人数从高到低 2-按开播时间从近到远';
comment on column T_LIVE_MODULE.status
  is '状态：1-正常 2-隐藏)';
comment on column T_LIVE_MODULE.create_time
  is '创建时间';
comment on column T_LIVE_MODULE.update_time
  is '修改时间';
comment on column T_LIVE_MODULE.del_flg
  is '删除标志1：正常 2：删除';
alter table T_LIVE_MODULE
  add primary key (ID);


create table T_LIVE_MODULE_CATEGORY
(
  id          NUMBER(10) not null,
  module_id   NUMBER(10),
  category_id NUMBER(10),
  create_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  status      NUMBER(5)
)
;
comment on table T_LIVE_MODULE_CATEGORY
  is '直播模块分类关联表';
comment on column T_LIVE_MODULE_CATEGORY.id
  is 'id';
comment on column T_LIVE_MODULE_CATEGORY.module_id
  is '直播模块id';
comment on column T_LIVE_MODULE_CATEGORY.category_id
  is '直播类别id';
comment on column T_LIVE_MODULE_CATEGORY.status
  is '1:正常 2：删除';
alter table T_LIVE_MODULE_CATEGORY
  add primary key (ID);


create table T_LIVE_PROPORTION_CONFIG
(
  id          NUMBER(11) not null,
  type        NUMBER(5),
  param       VARCHAR2(512),
  status      NUMBER(5),
  create_time TIMESTAMP(6),
  update_time TIMESTAMP(6)
)
;
comment on column T_LIVE_PROPORTION_CONFIG.type
  is '类型：1 礼物金额比例配置  2 平台主播分成比例';
comment on column T_LIVE_PROPORTION_CONFIG.param
  is '配置';
comment on column T_LIVE_PROPORTION_CONFIG.status
  is '状态：1 正常';
comment on column T_LIVE_PROPORTION_CONFIG.update_time
  is '修改时间';
alter table T_LIVE_PROPORTION_CONFIG
  add constraint T_LIVE_PROPORTION_CONFIG_PK primary key (ID);


create table T_LIVE_RECORD
(
  id                      NUMBER(11) not null,
  live_room_id            NUMBER(11),
  live_room_instance_id   NUMBER(11),
  biz_type                NUMBER(5),
  file_id                 VARCHAR2(128),
  file_name               VARCHAR2(256),
  file_url                VARCHAR2(512),
  file_format             VARCHAR2(20),
  start_time              TIMESTAMP(6),
  end_time                TIMESTAMP(6),
  file_duration           NUMBER(11),
  file_stream_id          VARCHAR2(128),
  file_size               NUMBER(11),
  stream_param            VARCHAR2(512),
  file_download_video_url VARCHAR2(512),
  appid                   VARCHAR2(128),
  expire_time             VARCHAR2(50),
  cover_url               VARCHAR2(512),
  create_time             TIMESTAMP(6),
  update_time             TIMESTAMP(6),
  views_num               NUMBER(11)
)
;
comment on column T_LIVE_RECORD.live_room_id
  is '直播间id';
comment on column T_LIVE_RECORD.live_room_instance_id
  is '直播间实例id';
comment on column T_LIVE_RECORD.biz_type
  is '业务类型：1-直播回放 2-视频编辑 3-短视频';
comment on column T_LIVE_RECORD.file_id
  is '腾讯点播 file_id';
comment on column T_LIVE_RECORD.file_name
  is '文件名';
comment on column T_LIVE_RECORD.file_url
  is '文件观看拉流地址';
comment on column T_LIVE_RECORD.file_format
  is '文件格式';
comment on column T_LIVE_RECORD.start_time
  is '录制文件起始时间戳';
comment on column T_LIVE_RECORD.end_time
  is '录制文件结束时间戳';
comment on column T_LIVE_RECORD.file_duration
  is '录制文件时长';
comment on column T_LIVE_RECORD.file_stream_id
  is '直播流code';
comment on column T_LIVE_RECORD.file_size
  is '文件大小';
comment on column T_LIVE_RECORD.stream_param
  is '直播推流参数';
comment on column T_LIVE_RECORD.file_download_video_url
  is '文件下载地址';
comment on column T_LIVE_RECORD.expire_time
  is '文件过期时间';
comment on column T_LIVE_RECORD.cover_url
  is '封面地址';
comment on column T_LIVE_RECORD.views_num
  is '播放次数';
alter table T_LIVE_RECORD
  add constraint T_LIVE_RECORD_PK primary key (ID);


create table T_LIVE_ROOM
(
  id                   NUMBER(11) not null,
  user_id              NUMBER(11),
  platform_code        NUMBER(5),
  room_code            VARCHAR2(128),
  chat_id              NUMBER(11),
  push_url             VARCHAR2(512),
  pull_url             VARCHAR2(512),
  cover_url            VARCHAR2(512),
  category_id          NUMBER(11),
  status               NUMBER(5),
  last_live_start_time TIMESTAMP(6),
  last_live_end_time   TIMESTAMP(6),
  follow_num           NUMBER(11),
  create_time          DATE,
  update_time          DATE,
  frozen_start_time    TIMESTAMP(6),
  frozen_end_time      TIMESTAMP(6),
  gift_total_num       NUMBER(10),
  gift_total_value     NUMBER(10),
  room_title           VARCHAR2(512),
  is_syn               NUMBER(5),
  stream_push_url      VARCHAR2(512)
)
;
comment on column T_LIVE_ROOM.user_id
  is '直播人ID';
comment on column T_LIVE_ROOM.platform_code
  is '直播平台：1-腾讯';
comment on column T_LIVE_ROOM.room_code
  is '直播间code';
comment on column T_LIVE_ROOM.chat_id
  is '对应聊天室id';
comment on column T_LIVE_ROOM.push_url
  is '推流地址';
comment on column T_LIVE_ROOM.pull_url
  is '拉流地址';
comment on column T_LIVE_ROOM.cover_url
  is '封面URL';
comment on column T_LIVE_ROOM.category_id
  is '对应类别ID';
comment on column T_LIVE_ROOM.status
  is '状态：1-开启 2-结束 3-封禁';
comment on column T_LIVE_ROOM.last_live_start_time
  is '上次开播直播时间';
comment on column T_LIVE_ROOM.last_live_end_time
  is '上次直播结束时间';
comment on column T_LIVE_ROOM.follow_num
  is '直播间关注数';
comment on column T_LIVE_ROOM.create_time
  is '创建时间';
comment on column T_LIVE_ROOM.update_time
  is '修改时间';
comment on column T_LIVE_ROOM.frozen_start_time
  is '封禁开始时间';
comment on column T_LIVE_ROOM.frozen_end_time
  is '封禁结束时间';
comment on column T_LIVE_ROOM.gift_total_num
  is '直播间礼物历史总数';
comment on column T_LIVE_ROOM.gift_total_value
  is '直播间礼物历史总价值';
comment on column T_LIVE_ROOM.room_title
  is '直播间标题';
comment on column T_LIVE_ROOM.is_syn
  is '是否同步录制：1是 0否';
comment on column T_LIVE_ROOM.stream_push_url
  is '加速推流地址';
alter table T_LIVE_ROOM
  add constraint T_LIVE_ROOM_PK primary key (ID);


create table T_LIVE_ROOM_ACCOUNT
(
  id                NUMBER(11) not null,
  live_room_id      NUMBER(11),
  user_id           NUMBER(11),
  total_value       NUMBER(11,2),
  wait_settle_value NUMBER(11,2),
  settle_value      NUMBER(11,2),
  status            NUMBER(5),
  create_time       TIMESTAMP(6),
  update_time       TIMESTAMP(6),
  frozen_value      NUMBER(11,2)
)
;
comment on column T_LIVE_ROOM_ACCOUNT.live_room_id
  is '直播间id';
comment on column T_LIVE_ROOM_ACCOUNT.total_value
  is '总打赏价值';
comment on column T_LIVE_ROOM_ACCOUNT.wait_settle_value
  is '待结算价值';
comment on column T_LIVE_ROOM_ACCOUNT.settle_value
  is '总结算价值';
comment on column T_LIVE_ROOM_ACCOUNT.status
  is '账户状态：1正常 2 禁用';
alter table T_LIVE_ROOM_ACCOUNT
  add constraint T_LIVE_ROOM_ACCOUNT_PK primary key (ID);


create table T_LIVE_ROOM_ACCOUNT_SETTLE
(
  id                  NUMBER(11) not null,
  account_id          NUMBER(11),
  wallet_id           NUMBER(11),
  settle_value        NUMBER(11,2),
  settle_amount       NUMBER(11,2),
  platform_value      NUMBER(11,2),
  status              VARCHAR2(2),
  last_request_no     VARCHAR2(50),
  channel_order_no    VARCHAR2(50),
  settle_success_time TIMESTAMP(6),
  create_time         TIMESTAMP(6),
  update_time         TIMESTAMP(6),
  type                NUMBER(5),
  anchor_profit       NUMBER(11,2),
  platform_profit     NUMBER(11,2),
  wait_settle_amount  NUMBER(18,2)
)
;
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.account_id
  is '直播间账户表id';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.wallet_id
  is '钱包id';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.settle_value
  is '结算价值';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.settle_amount
  is '结算金额';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.platform_value
  is '平台分成价值';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.status
  is '结算状态：W-待处理 P-处理中-S-成功 F-失败';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.last_request_no
  is '最后一次请求号';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.channel_order_no
  is '渠道结算流水号';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.settle_success_time
  is '结算成功时间';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.type
  is '1:礼物提现';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.anchor_profit
  is '主播收益';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.platform_profit
  is '平台收益';
comment on column T_LIVE_ROOM_ACCOUNT_SETTLE.wait_settle_amount
  is '主播剩余待结算余额对应金额';
alter table T_LIVE_ROOM_ACCOUNT_SETTLE
  add constraint T_LIVE_ROOM_ACCOUNT_SETTLE_PK primary key (ID);


create table T_LIVE_ROOM_CONFIG
(
  id                NUMBER(10) not null,
  biz_type          NUMBER(5),
  config_type       NUMBER(5),
  biz_id            NUMBER(10),
  config_start_time TIMESTAMP(6),
  config_end_time   TIMESTAMP(6),
  status            NUMBER(5),
  create_time       TIMESTAMP(6),
  update_time       TIMESTAMP(6),
  time_type         NUMBER(5)
)
;
comment on column T_LIVE_ROOM_CONFIG.id
  is 'id';
comment on column T_LIVE_ROOM_CONFIG.biz_type
  is '开播设置|禁播设置,，1：开播，2：禁播';
comment on column T_LIVE_ROOM_CONFIG.config_type
  is '全局|类别|直播间，1：全局，2：类别，3：直播间';
comment on column T_LIVE_ROOM_CONFIG.biz_id
  is '直播间ID或类别ID';
comment on column T_LIVE_ROOM_CONFIG.config_start_time
  is '配置开始时间';
comment on column T_LIVE_ROOM_CONFIG.config_end_time
  is '配置结束时间';
comment on column T_LIVE_ROOM_CONFIG.status
  is '状态1：正常，2：删除';
comment on column T_LIVE_ROOM_CONFIG.create_time
  is '创建时间';
comment on column T_LIVE_ROOM_CONFIG.update_time
  is '修改时间';
comment on column T_LIVE_ROOM_CONFIG.time_type
  is '1：全天，2：自定义';
alter table T_LIVE_ROOM_CONFIG
  add primary key (ID);


create table T_LIVE_STICKER
(
  id             NUMBER(10) not null,
  sticker_name   VARCHAR2(10),
  pic_url        VARCHAR2(512),
  action_type    NUMBER(5),
  action_pic_url VARCHAR2(512),
  action_time    NUMBER(5,2),
  create_time    TIMESTAMP(6),
  update_time    TIMESTAMP(6),
  status         NUMBER(5)
)
;
comment on column T_LIVE_STICKER.id
  is '贴纸id';
comment on column T_LIVE_STICKER.sticker_name
  is '贴纸名称';
comment on column T_LIVE_STICKER.pic_url
  is '贴纸图片地址';
comment on column T_LIVE_STICKER.action_type
  is '动效类型1：gif，2：SVGA';
comment on column T_LIVE_STICKER.action_pic_url
  is '动效图片地址';
comment on column T_LIVE_STICKER.action_time
  is '动效时长，单位秒';
comment on column T_LIVE_STICKER.create_time
  is '创建时间';
comment on column T_LIVE_STICKER.update_time
  is '修改时间';
comment on column T_LIVE_STICKER.status
  is '1:正常 2：删除';
alter table T_LIVE_STICKER
  add primary key (ID);


create table T_LIVE_USER_CHAT_RELATION
(
  id               NUMBER(11) not null,
  live_room_id     NUMBER(11),
  chat_room_id     NUMBER(11),
  user_id          NUMBER(11),
  room_grade       NUMBER(10),
  total_gift_num   NUMBER(11),
  total_gift_value NUMBER(20,2),
  status           NUMBER(2),
  create_time      TIMESTAMP(6),
  update_time      TIMESTAMP(6)
)
;
comment on column T_LIVE_USER_CHAT_RELATION.room_grade
  is '用户在该聊天室等级';
comment on column T_LIVE_USER_CHAT_RELATION.total_gift_num
  is '总送出礼物数';
comment on column T_LIVE_USER_CHAT_RELATION.total_gift_value
  is '礼物总价值';
alter table T_LIVE_USER_CHAT_RELATION
  add constraint T_LIVE_USER_CHAT_RELATION_PK primary key (ID);


create table T_LIVE_VALUE_CONFIG
(
  id            NUMBER(11) not null,
  value_num     NUMBER(11,2),
  value_amount  NUMBER(11,2),
  display_order NUMBER(5),
  status        NUMBER(5),
  create_time   TIMESTAMP(6),
  update_time   TIMESTAMP(6),
  type          NUMBER(5),
  product_id    VARCHAR2(20)
)
;
comment on column T_LIVE_VALUE_CONFIG.value_num
  is '价值数';
comment on column T_LIVE_VALUE_CONFIG.value_amount
  is '对应现金数';
comment on column T_LIVE_VALUE_CONFIG.display_order
  is '显示排序';
comment on column T_LIVE_VALUE_CONFIG.status
  is '状态：1 正常 2 禁用';
comment on column T_LIVE_VALUE_CONFIG.type
  is '1:安卓 2:IOS';
comment on column T_LIVE_VALUE_CONFIG.product_id
  is '产品id';
alter table T_LIVE_VALUE_CONFIG
  add constraint T_LIVE_VALUE_CONFIG_PK primary key (ID);

