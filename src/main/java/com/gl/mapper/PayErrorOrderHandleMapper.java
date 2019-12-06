package com.gl.mapper;

import com.gl.entity.PO.PayErrorOrderHandle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PayErrorOrderHandleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayErrorOrderHandle record);

    PayErrorOrderHandle selectByPrimaryKey(Long id);

    List<PayErrorOrderHandle> selectAll();

    int updateByPrimaryKey(PayErrorOrderHandle record);
}