package com.uns.unspay.mapper;

import com.uns.unspay.entity.CpsDeclareOrder;

public interface CpsDeclareOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(CpsDeclareOrder record);

    int insertSelective(CpsDeclareOrder record);

    CpsDeclareOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CpsDeclareOrder record);

    int updateByPrimaryKey(CpsDeclareOrder record);
}