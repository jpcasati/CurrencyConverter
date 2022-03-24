/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import bean.RecordBean;
import java.sql.SQLException;

/**
 *
 * @author jpcasati
 */
public interface CurrencyDAO {
    
    
    public RecordBean find(String currencyCode) throws SQLException;

    
}
