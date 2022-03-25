/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jpcasati
 */
public class RecordBean {
    
    String currencyCode;
    
    double sellPerCAD;
    
    double buyPerCAD;

    @Override
    public String toString() {
        return "RecordBean{" + "currencyCode=" + currencyCode + ", sellPerCAD=" + sellPerCAD + ", buyPerCAD=" + buyPerCAD + '}';
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getSellPerCAD() {
        return sellPerCAD;
    }

    public void setSellPerCAD(double sellPerCAD) {
        this.sellPerCAD = sellPerCAD;
    }

    public double getBuyPerCAD() {
        return buyPerCAD;
    }

    public void setBuyPerCAD(double buyPerCAD) {
        this.buyPerCAD = buyPerCAD;
    }
    
    
}
