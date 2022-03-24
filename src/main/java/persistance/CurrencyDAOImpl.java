/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import bean.RecordBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jpcasati
 */
public class CurrencyDAOImpl implements CurrencyDAO {
    
    private final static String URL = "jdbc:mysql://localhost:3306/CURRENCY?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private final static String USER = "banker";
    private final static String PASSWORD = "finance";
    
    @Override
    public RecordBean find(String currencyCode) throws SQLException {
        
        RecordBean recordBean = null;
        
        String sql = "SELECT * FROM MONEY WHERE CURRENCYCODE=?";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pStatement = connection.prepareStatement(sql); ) {
            
            pStatement.setString(1, currencyCode);
            
            try (ResultSet resultSet = pStatement.executeQuery()) {
                
                while (resultSet.next()) {
                    recordBean = new RecordBean();
                    recordBean.setCurrencyCode(resultSet.getString("CURRENCYCODE"));
                    recordBean.setSellPerCAD(resultSet.getDouble("SELLPERCAD"));
                    recordBean.setBuyPerCAD(resultSet.getDouble("BUYPERCAD"));
                    
                }
            }
        }
        
        return recordBean;
        
    }
    
}
