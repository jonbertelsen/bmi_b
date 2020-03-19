package DBAccess;

import FunctionLayer.Info;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoMapper {

    public static List<Info> getAllInfos() throws LoginSampleException {
        List<Info> infoList = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM info";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (infoList == null){
                    infoList = new ArrayList<>();
                }
                int info_id = rs.getInt("info_id");
                String name = rs.getString("name");
                Info info = new Info(info_id, name);
                infoList.add(info);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return infoList;
    }
}
