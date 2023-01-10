## 一、用户数据

### 5450-圈圈用户数

**简要描述：**

- 5450-圈圈用户数

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5450

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                                         |
| :------- | :--- | :--- | ------------------------------------------------------------ |
| circleId | 是   | long | 圈id                                                         |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天                   |
| type     | 否   | int  | 1：总数据数(total)，2：新增(new)，3：活跃(active)，不传三个列表一起返回 |

**返回示例**

``` 
{
    "head":{
        "cmd":5450,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"newCnt": 232,
    		"activeCnt": 32,
    		"total": [
                {
                    "date": "2022-12-12",
                    "val": 23
                }
    		],
    		"newly": [
                {
                    "date": "2022-12-12",
                    "val": 23
                }
    		],
    		"active": [
                {
                    "date": "2022-12-12",
                    "val": 23
                }
    		]
    	}
    }
}
```

**返回参数说明**

| 参数名    | 类型 | 说明                 |
| :-------- | :--- | -------------------- |
| newCnt    | int  | 新增用户数           |
| activeCnt | int  | 活跃用户数           |
| total     | obj  | 总用户数，日期列表   |
| newly       | obj  | 新增用户数，日期列表 |
| active    | obj  | 活跃用户数，日期列表 |



### 5451-圈圈成员统计

**简要描述：**

- 5451-圈圈成员用户画像

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5451

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明 |
| :------- | :--- | :--- | ---- |
| circleId | 是   | long | 圈id |

**返回示例**

``` 
{
    "head":{
        "cmd":5451,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"source": [
    			{
    				"name": "我圈",
    				"val": "23"
    			}
    		]
    		"gender": [
    			{
    				"name": "男",
    				"val": "23"
    			}
    		],
    		"age": [
    			{
    				"name": "八零后",
    				"val": "23"
    			}
    		],
    		"area": [
    			{
                    "name": "江苏",
                    "val": "23"
    			}
    		],
    		"interest": [
    			{
                    "name": "兴趣名1",
                    "val": "23"
    			}
    		]
    	}
    }
}
```

**返回参数说明**

| 参数名   | 类型  | 说明                                   |
| :------- | :---- | -------------------------------------- |
| source   | [obj] | 来源，name对应来源名称，val为百分比    |
| gender   | [obj] | 性别，name对应性别，val为百分比        |
| age      | [obj] | 年龄，name对应年龄段说明 ，val为百分比 |
| area     | [obj] | 地域，name对应地区，val为百分比        |
| interest | [obj] | 兴趣，name对应兴趣名，val为用户数      |



## 二、内容数据

### 5453-内容新增数据

**简要描述：**

- 5453-内容新增数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5453

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                       |
| :------- | :--- | :--- | ------------------------------------------ |
| circleId | 是   | long | 圈id                                       |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5453,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"topicCnt": 232,
    		"addHubCnt": 32,
    		"dynamicCnt":232,
    		"list": [
                {
                    "date": "2022-12-12",
                    "dynamic": 23,
                    "hub": 23,
                    "topic": 23
                },
                {
                    "date": "2022-12-13",
                    "dynamic": 23,
                    "hub": 23,
                    "topic": 23
                }
    		]
    	}
    }
}
```

**返回参数说明**

| 参数名     | 类型   | 说明        |
| :--------- | :----- | ----------- |
| topicCnt   | int    | 新增话题数  |
| addHubCnt  | int    | 新加入hub数 |
| dynamicCnt | int    | 新增动态数  |
| list       | [obj]  |             |
| date       | string | 日期        |
| dynamic    | int    | 动态数      |
| hub        | int    | 加入hub数   |
| topic      | int    | 话题数      |

### 5454-内容浏览互动数据

**简要描述：**

- 5454-内容浏览互动数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5454

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                       |
| :------- | :--- | :--- | ------------------------------------------ |
| circleId | 是   | long | 圈id                                       |
| type     | 是   | int  | 1：动态，2：hub                            |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5454,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": [
            {
                "date": "2022-12-12",
                "browse": 23,
                "collect": 23,
                "up": 23,
                "remark": 43
            },
            {
                "date": "2022-12-13",
                "browse": 23,
                "collect": 23,
                "up": 23,
                "remark": 43
            }
        ]
    }
}
```

**返回参数说明**

| 参数名  | 类型   | 说明   |
| :------ | :----- | ------ |
| date    | string | 日期   |
| browse  | int    | 浏览数 |
| collect | int    | 收藏数 |
| up      | int    | 点赞数 |
| remark  | int    | 评论数 |



## 三、组局数据

### 5455-组局概览数据

**简要描述：**

- 5455-组局概览数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5455

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                                         |
| :------- | :--- | :--- | ------------------------------------------------------------ |
| circleId | 是   | long | 圈id                                                         |
| type     | 否   | int  | 1：场次(session)， 2：浏览(browse)，3：报名(signUp) ，4：收益(profit)，不传都返回 |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天                   |

**返回示例**

``` 
{
    "head":{
        "cmd":5455,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"sessionCnt": 323,
    		"browseCnt": 2323,
    		"signUpCnt": 232,
    		"profitCnt": 232,
            "session": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "browse": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "signUp": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "profit": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ]
        }
    }
}
```

**返回参数说明**

| 参数名     | 类型  | 说明                                |
| :--------- | :---- | ----------------------------------- |
| sessionCnt | int   | 组局场次                            |
| browseCnt  | int   | 浏览次数                            |
| signUpCnt  | int   | 报名数                              |
| profitCnt  | int   | 收益                                |
| session    | [obj] | 场次每日数量，date：日期，val：数量 |
| browse     | [obj] | 浏览每日数量，date：日期，val：数量 |
| signUp     | [obj] | 报名每日数量，date：日期，val：数量 |
| profit     | [obj] | 收益每日数量，date：日期，val：数量 |

### 5456-单个组局概览数据

**简要描述：**

- 5456-单个组局概览数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5456

**请求方式：**

- POST

**参数：**

| 参数名     | 必选 | 类型 | 说明                                                         |
| :--------- | :--- | :--- | ------------------------------------------------------------ |
| circleId   | 是   | long | 圈id                                                         |
| activityId | 是   | long | 组局id                                                       |
| type       | 否   | int  | 1：浏览(browse)，2：报名(signUp) ，3：收益(profit)，不传都返回 |
| days       | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天                   |

**返回示例**

``` 
{
    "head":{
        "cmd":5456,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"newUserRatio": "23.23",
            "oldUserRatio": "76.77",
            "browseUserCnt": 2323,
            "signUpUserCnt": 323,
            "conversionRatio": "39.88",
            "browse": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "signUp": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "profit": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ]
        }
    }
}
```

**返回参数说明**

| 参数名          | 类型   | 说明                                |
| :-------------- | :----- | ----------------------------------- |
| newUserRatio    | string | 新用户占比                          |
| oldUserRatio    | string | 老用户占比                          |
| browseUserCnt   | int    | 浏览用户数                          |
| signUpUserCnt   | int    | 报名用户数                          |
| conversionRatio | string | 报名转化率                          |
| browse          | [obj]  | 浏览每日数量，date：日期，val：数量 |
| signUp          | [obj]  | 报名每日数量，date：日期，val：数量 |
| profit          | [obj]  | 收益每日数量，date：日期，val：数量 |

### 5457-组局分享

**简要描述：**

- 5457-组局分享

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5457

**请求方式：**

- POST

**参数：**

| 参数名     | 必选 | 类型 | 说明                                       |
| :--------- | :--- | :--- | ------------------------------------------ |
| circleId   | 是   | long | 圈id                                       |
| activityId | 是   | long | 组局id                                     |
| days       | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5457,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": [
            {
                "date": "2022-12-12",
                "val": 23
            }
        ]
    }
}
```

**返回参数说明**

| 参数名 | 类型  | 说明                                |
| :----- | :---- | ----------------------------------- |
| data   | [obj] | 浏览每日数量，date：日期，val：数量 |



## 四、好物数据

### 5458-好物实时数据

**简要描述：**

- 5458-好物实时数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5458

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                                         |
| :------- | :--- | :--- | ------------------------------------------------------------ |
| circleId | 是   | long | 圈id                                                         |
| type     | 否   | int  | 1：场次(session)， 2：浏览(browse)，3：报名(signUp) ，4：收益(profit)，不传都返回 |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天                   |

**返回示例**

``` 
{
    "head":{
        "cmd":5458,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"visitorCnt":23,
    		"payUserCnt": 23,
    		"orderCnt": 23,
    		"payTotalAmount": "232.23",
    		"coversion": {
                "browseUserCnt": 2323,
                "payUserCnt": 232,
                "payRatio": "23.23"
    		},
            "visitor": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "payUser": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "order": [
            	{
                    "date": "2022-12-12",
                    "val": 23
                }
            ],
            "payAmount": [
            	{
                    "date": "2022-12-12",
                    "val": "232.30"
                }
            ]
        }
    }
}
```

**返回参数说明**

| 参数名         | 类型   | 说明                                    |
| :------------- | :----- | --------------------------------------- |
| visitorCnt     | int    | 访客总数                                |
| payUserCnt     | int    | 支付用户总数                            |
| orderCnt       | int    | 订单总数                                |
| payTotalAmount | string | 支付总金额                              |
| coversion      | obj    | 转化率obj                               |
| browseUserCnt  | int    | 浏览用户数                              |
| payUserCnt     | int    | 支付用户数                              |
| payRatio       | int    | 支付转化率                              |
| visitor        | [obj]  | 圈店访客每日数量，date：日期，val：数量 |
| payUser        | [obj]  | 支付人数每日数量，date：日期，val：数量 |
| order          | [obj]  | 订单每日数量，date：日期，val：数量     |
| payAmount      | [obj]  | 支付金额每日数量，date：日期，val：数量 |

### 5459-好物回头率

**简要描述：**

- 5459-好物回头率

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5459

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                      |
| :------- | :--- | :--- | ----------------------------------------- |
| circleId | 是   | long | 圈id                                      |
| days     | 否   | int  | 代表天数，取值范围，30，90，180，默认30天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5459,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"newUser": "23.23",
    		"oldUser": "76.77"
    	}
    }
}
```

**返回参数说明**

| 参数名  | 类型   | 说明       |
| :------ | :----- | ---------- |
| newUser | string | 新用户占比 |
| oldUser | string | 老用户占比 |



### 5460-好物收藏数据

**简要描述：**

- 5460-好物收藏数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5460

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                       |
| :------- | :--- | :--- | ------------------------------------------ |
| circleId | 是   | long | 圈id                                       |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5460,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": [
            {
                "date": "2022-12-12",
                "val": 23
            }
        ]
    }
}
```

**返回参数说明**

| 参数名 | 类型  | 说明                                |
| :----- | :---- | ----------------------------------- |
| data   | [obj] | 收藏每日数量，date：日期，val：数量 |



## 五、资金池数据

### 5461-收入构成

**简要描述：**

- 5461-收入构成

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5461

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                      |
| :------- | :--- | :--- | ----------------------------------------- |
| circleId | 是   | long | 圈id                                      |
| days     | 否   | int  | 代表天数，取值范围，30，90，180，默认30天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5461,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": [
    		{
    			"name": "圈内商品",
    			"amount": "323.23",
    			"ratio": "23.87" 
    		}
    	]
    }
}
```

**返回参数说明**

| 参数名 | 类型   | 说明               |
| :----- | :----- | ------------------ |
| name   | string | 收入构成的名称说明 |
| amount | string | 金额               |
| ratio  | string | 百分比             |

### 5462-收支数据

**简要描述：**

- 5462-收支数据

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5462

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明                                       |
| :------- | :--- | :--- | ------------------------------------------ |
| circleId | 是   | long | 圈id                                       |
| days     | 否   | int  | 代表天数，取值范围，7，15，30，60，默认7天 |

**返回示例**

``` 
{
    "head":{
        "cmd":5462,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": [
    		{
    			"date": "2022-12-30",
    			"in": "323.23",
    			"out": "23.87" 
    		}
    	]
    }
}
```

**返回参数说明**

| 参数名 | 类型   | 说明 |
| :----- | :----- | ---- |
| date   | string | 日期 |
| in     | string | 收入 |
| out    | string | 支出 |

### 5463-收入环比

**简要描述：**

- 5463-收入环比

**请求URL：**

- ` http://xx.com/UU/circle `

**CMD：**

- 5463

**请求方式：**

- POST

**参数：**

| 参数名   | 必选 | 类型 | 说明 |
| :------- | :--- | :--- | ---- |
| circleId | 是   | long | 圈id |

**返回示例**

``` 
{
    "head":{
        "cmd":5463,
        "st":0,
        "msg":"成功"
    },
    "body": {
    	"data": {
    		"week": {
    			"current": "100.33",
    			"last": "50.22",
    			"ratio": "+50"
    		},
    		"month": {
    			"current": "50.33",
    			"last": "100.22",
    			"ratio": "-50"
    		}
    	}
    }
}
```

**返回参数说明**

| 参数名  | 类型   | 说明               |
| :------ | :----- | ------------------ |
| week    | obj    | 周                 |
| month   | obj    | 月                 |
| current | string | 本周、本月         |
| last    | string | 上周、上月         |
| ratio   | string | 同比，+上升，-下降 |