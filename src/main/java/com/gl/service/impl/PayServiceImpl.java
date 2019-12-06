package com.gl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.entity.PO.PayErrorOrderHandle;
import com.gl.entity.page.PageResult;
import com.gl.mapper.Biz.BizPayErrorOrderHandleMapper;
import com.gl.mapper.PayErrorOrderHandleMapper;
import com.gl.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    private PayErrorOrderHandleMapper payErrorOrderHandleMapper;

    @Autowired
    private BizPayErrorOrderHandleMapper bizPayErrorOrderHandleMapper;

    @Override
    public PageResult<PayErrorOrderHandle> getList(int pageNo, int pageSize, String key) {
        Page<Object> page = PageHelper.startPage(pageNo, pageSize);

        Example example = new Example(PayErrorOrderHandle.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isEmpty(key)){
            criteria.orLike("orderNo",key+"%");
        }
        List<PayErrorOrderHandle> payErrorOrderHandleList = bizPayErrorOrderHandleMapper.selectByExample(example);
        PageInfo<PayErrorOrderHandle> pageInfo = new PageInfo<>(payErrorOrderHandleList);
        PageResult<PayErrorOrderHandle> pageResult = new PageResult<>();
        pageResult.setList(pageInfo.getList());
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }
}
