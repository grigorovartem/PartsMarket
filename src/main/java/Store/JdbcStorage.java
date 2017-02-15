package Store;

import Entity.PartCache;
import Entity.SparePart;
import Filtration.Filterable;
import Service.ProductStorage;
import Service.Settings;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class JdbcStorage implements Storage {

    private Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            Class.forName(settings.value("jdbc.driver_class"));
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"),
                    settings.value("jdbc.username"), settings.value("jdbc.password"));
            System.out.println("Connected");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Storage add(SparePart sparePart, int count) {
        try {
            final PreparedStatement statement = this.connection.prepareStatement("insert into public.\"products\"\n" +
                    "(name, price, brand, quantity) values(?, ?, ?, ?)");
            statement.setString(1, sparePart.getName());
            statement.setBigDecimal(2, sparePart.getPrice());
            statement.setString(3, sparePart.getBrand().name());
            statement.setInt(4, count);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public Storage filter(Filterable<SparePart> condition) {
//        ProductStorage filteredStorage = PartCache.inctance();
//        filteredStorage.clear();
//        try {
//            final PreparedStatement statement = this.connection.prepareStatement("select from public.\"products\"\n" +
//                    "(name, price, brand, quantity) values(?, ?, ?, ?)");
//            while (statement.) {
//                if (condition.verify(entry.getKey())) {
//                    filteredStorage.add(entry.getKey(), entry.getValue());
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
            return null;
        }
}
