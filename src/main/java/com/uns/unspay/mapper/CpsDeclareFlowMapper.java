package com.uns.unspay.mapper;

import com.uns.unspay.entity.CpsDeclareFlow;

public interface CpsDeclareFlowMapper {
    int deleteByPrimaryKey(String id);

    int insert(CpsDeclareFlow record);

    int insertSelective(CpsDeclareFlow record);

    CpsDeclareFlow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CpsDeclareFlow record);

    int updateByPrimaryKey(CpsDeclareFlow record);
}