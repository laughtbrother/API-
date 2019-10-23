package com.mybatisdemo1.demo.controller;

import com.mybatisdemo1.demo.entity.BankEntity;
import com.mybatisdemo1.demo.entity.BaseEntity;
import com.mybatisdemo1.demo.service.BankService;
import com.mybatisdemo1.demo.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/bank")
@Api(value ="/bank",description = "银行模块",tags ="/bank")
public class BankController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private BankService bankService;

    @ApiOperation(value = "银行删除")
    @RequestMapping(value = "/deleteBankById",method = RequestMethod.POST)
    public BaseEntity deleteBankById(@RequestParam(value = "id",required = true)@ApiParam("银行Id") int id){
        BankEntity bankEntity=bankService.getBankByid(id);
        if(bankEntity==null){
            return new BaseEntity().setCode(201).setMsg("删除银行失败");
        }
        return BaseEntity.success(bankEntity);
    }
    @ApiOperation(value = "银行添加")
    @RequestMapping(value = "/registerBank",method = RequestMethod.POST)
    public BaseEntity registerBank(@RequestParam(value = "BankId", required = true) @ApiParam("银行Id") int BankId,
                                   @RequestParam(value = "BankName", required = true) @ApiParam("银行名称") String BankName,
                                   @RequestParam(value = "Region", required = false) @ApiParam("所属区域") String Region,
                                   @RequestParam(value = "City", required = false) @ApiParam("所属城市") String City,
                                   @RequestParam(value = "Province", required = false) @ApiParam("所属省份") String Province,
                                   @RequestParam(value = "Opentime", required = false, defaultValue = "") @ApiParam("营业开始时间") String Opentime,
                                   @RequestParam(value = "Endtime", required = false, defaultValue = "") @ApiParam("营业结束时间") String Endtime
    ) {
        BankEntity bankEntity = bankService.getBankByid(BankId);
        if (bankEntity != null) {
            return new BaseEntity().setCode(201).setMsg("添加失败");
        }
        bankService.registerBank(BankId, BankName, Region, City, Province, CommonUtil.getDate(Opentime),CommonUtil.getDate(Endtime));
        return BaseEntity.success("添加成功");
    }
    @ApiOperation(value = "获取银行列表")
    @RequestMapping(value = "/getBankList",method = RequestMethod.GET)
    public BaseEntity getBankList() {
        List<BankEntity> bankEntityList = bankService.getBankList();
        return BaseEntity.success(bankEntityList);
    }
    @ApiOperation(value = "根据Id获取银行")
    @RequestMapping(value = "/getBankByid",method = RequestMethod.POST)
    public BaseEntity getBankByid(@RequestParam(value = "bankId",required = true)@ApiParam("银行Id")int bankId){
        BankEntity bankEntity=bankService.getBankByid(bankId);
        if(bankEntity==null)
            return new BaseEntity().setCode(201).setMsg("获取数据失败");
        return  BaseEntity.success(bankEntity);
    }
}
