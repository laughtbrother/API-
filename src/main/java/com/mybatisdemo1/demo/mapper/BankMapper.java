package com.mybatisdemo1.demo.mapper;

import com.mybatisdemo1.demo.entity.BankEntity;

import java.util.Date;
import java.util.List;

public interface BankMapper {
    void deleteBankById(int id);
    void registerBank(int BankId, String BankName, String Region, String City, String Province, Date Opentime,Date Endtime);
    List<BankEntity>getBankList();
    BankEntity getBankByid(int bankId);
}
