package com.mybatisdemo1.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankEntity {
public int BankId;
public String BankName;
public String Region;
public String City;
public String Province;
public Date Opentime;
public Date Endtime;
public boolean Isdelete;
}
