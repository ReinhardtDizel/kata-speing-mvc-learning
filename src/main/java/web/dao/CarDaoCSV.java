package web.dao;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import web.model.Car;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDaoCSV implements CarDao {

    private final List<Car> dao;

    public CarDaoCSV() {
        dao = ResourceCSVReader.getCsvData();
    }

    @Override
    public List<Car> getAllCars() {
        return dao;
    }

    @Override
    public List<Car> getCars(int cars) {
        return cars >= dao.size() ? dao : dao.subList(0, cars);
    }

    private static class ResourceCSVReader {

        private static Optional<List<Car>> csvData;

        static {

            try (FileReader filereader = new FileReader(ResourceUtils.getFile("classpath:cars.csv"));
                 CSVReader csvReader = new CSVReader(filereader)) {
                csvData = Optional.ofNullable(new CsvToBeanBuilder<Car>(csvReader)
                        .withType(Car.class)
                        .build()
                        .parse());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Car> getCsvData() {
            return csvData.orElse(null);
        }
    }
}
