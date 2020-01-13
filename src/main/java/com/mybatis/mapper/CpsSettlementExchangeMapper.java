package com.mybatis.mapper;

import com.mybatis.entity.CpsSettlementExchange;

public interface CpsSettlementExchangeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CpsSettlementExchange record);

    int insertSelective(CpsSettlementExchange record);

    CpsSettlementExchange selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CpsSettlementExchange record);

    int updateByPrimaryKey(CpsSettlementExchange record);
}