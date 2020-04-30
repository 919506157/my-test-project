package com.uns.unspay.mapper;

import com.uns.unspay.entity.CpsDeclareDetail;

public interface CpsDeclareDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(CpsDeclareDetail record);

    int insertSelective(CpsDeclareDetail record);

    CpsDeclareDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CpsDeclareDetail record);

    int updateByPrimaryKey(CpsDeclareDetail record);
}