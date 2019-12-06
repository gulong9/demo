package com.gl.service;

import com.gl.entity.PO.PayErrorOrderHandle;
import com.gl.entity.page.PageResult;

public interface IPayService {
    PageResult<PayErrorOrderHandle> getList(int pageNo, int pageSize, String key);
}
