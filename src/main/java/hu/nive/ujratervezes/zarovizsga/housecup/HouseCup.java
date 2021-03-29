package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {
    private final DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String house) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT sum(points_earned) AS points FROM house_points WHERE house_name = ?")) {

            ps.setString(1, house);
            return getPointsByPreparedStatement(ps);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to house_point table ", sqle);
        }
    }

    private int getPointsByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return (int) rs.getLong("points");
            } else {
                return 0;
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not select from house_point table ", sqle);
        }
    }
}
