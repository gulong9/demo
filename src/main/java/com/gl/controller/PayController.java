package com.gl.controller;

import com.gl.entity.PO.PayErrorOrderHandle;
import com.gl.entity.page.PageResult;
import com.gl.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PayController {

    @Autowired
    private IPayService payService;

    @GetMapping("/getlist")
    public ResponseEntity<PageResult<PayErrorOrderHandle>> getList(@RequestParam(value = "page",defaultValue = "1") int pageNo,
                                                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                                                   @RequestParam(value = "key",required = false) String key){
        PageResult<PayErrorOrderHandle> list = payService.getList(pageNo,pageSize,key);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/list")
    public void list(){
        //先不写
    }
}
