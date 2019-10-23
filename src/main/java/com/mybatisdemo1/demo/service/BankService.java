package com.mybatisdemo1.demo.service;

import com.mybatisdemo1.demo.entity.BankEntity;
import com.mybatisdemo1.demo.mapper.BankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankMapper bankMapper;
    public void deleteBankById(int id){
        bankMapper.deleteBankById(id);
    }
    public void registerBank(int BankId, String BankName, String Region, String City, String Province, Date Opentime, Date Endtime){
        bankMapper.registerBank(BankId,BankName,Region,City,Province,Opentime,Endtime);
    }
    public List<BankEntity> getBankList(){
        return bankMapper.getBankList();
    }
    public BankEntity getBankByid(int bankId){
        return bankMapper.getBankByid(bankId);
    }
}
