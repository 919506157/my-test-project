package com.uns.unspay.mapper;

import com.uns.unspay.entity.CpsDeclarePort;

public interface CpsDeclarePortMapper {
    int deleteByPrimaryKey(String id);

    int insert(CpsDeclarePort record);

    int insertSelective(CpsDeclarePort record);

    CpsDeclarePort selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CpsDeclarePort record);

    int updateByPrimaryKey(CpsDeclarePort record);
}