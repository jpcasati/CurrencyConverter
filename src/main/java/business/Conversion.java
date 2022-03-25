/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import bean.MoneyBean;
import bean.RecordBean;
import java.sql.SQLException;
import persistance.CurrencyDAO;
import persistance.CurrencyDAOImpl;

/**
 *
 * @author jpcasati
 */
public class Conversion {
    
    public MoneyBean buyConversion(MoneyBean moneyBean) {
        
        RecordBean recordBean = null;
        
        CurrencyDAO currencyDAO = new CurrencyDAOImpl();
        
        try {
            recordBean = currencyDAO.find(moneyBean.getCurrencyCode());
        } catch (SQLException e) {
            System.out.println("ERRO DE SQL: " + e.getMessage());
        }
        
        if(recordBean == null) {
            System.out.println("Not found.");
            moneyBean.setConversion(-1);
        } else {
            System.out.println(recordBean);
            moneyBean.setConversion(moneyBean.getAmount() * recordBean.getBuyPerCAD());
        }
        
        return moneyBean;
        
    }
    
    public MoneyBean sellConversion(MoneyBean moneyBean) {
        
        RecordBean recordBean = null;
        
        CurrencyDAO currencyDAO = new CurrencyDAOImpl();
        
        try {
            recordBean = currencyDAO.find(moneyBean.getCurrencyCode());
        } catch (SQLException e) {
            System.out.println("SQL ERROR: " + e.getMessage());
        }
        
        if(recordBean == null) {
            System.out.println("Not found.");
            moneyBean.setConversion(-1);
        } else {
            System.out.println(recordBean);
            moneyBean.setConversion(moneyBean.getAmount() * recordBean.getSellPerCAD());
        }
        
        return moneyBean;
        
    }
    
}
