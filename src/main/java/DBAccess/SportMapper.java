package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of SportMapper is to select and update category texts for dropdowns
 @author jon
 @version 0.9
 */

public class SportMapper {

    /**
     * Selects a list of sport categories from the DB
     * @return A arraylist of Sportelements with name and id
     * @throws LoginSampleException
     * @author jon
     * @version 0.9
     */
    public static List<Sport> getAllSports() throws LoginSampleException {
        List<Sport> sportList = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM sport";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            System.out.println("Før while");
            while (rs.next()) {

                if (sportList == null){
                    sportList = new ArrayList<>();
                    System.out.println("Laver sport arrayliste i mapper");
                }
                int sport_id = rs.getInt("sport_id");
                String name = rs.getString("name");
                System.out.println("name: " + name);
                Sport sport = new Sport(sport_id, name);
                sportList.add(sport);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return sportList;
    }

    /**
     * Updates a sport category in the database
     * @param sport_id (should exist in the DB already)
     * @param name (updated name for category)
     * @throws LoginSampleException
     */
    public static void updateSport(int sport_id, String name) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE sport SET name = ? WHERE sport_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setInt(2, sport_id);
            int result = ps.executeUpdate();
            } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Removed a sport category form DB. Cannot remove if the is a
     * dependent foreign key in the bmi_entry table
     * @param sport_id
     * @throws LoginSampleException
     */
    public static void deleteSport(int sport_id) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            System.out.println("Nu her i deleteSport : " + sport_id);
            String SQL = "DELETE FROM sport WHERE sport_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, sport_id);
            int result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            if (ex.getMessage().startsWith("Cannot delete or update a parent row")){
                throw new LoginSampleException("Du kan ikke fjerne en sportskategori som allerede er anvendt i databasen");
            } else {
                throw new LoginSampleException(ex.getMessage());
            }
        }
    }
}
