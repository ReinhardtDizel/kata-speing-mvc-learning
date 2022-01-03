package web.model;

import com.opencsv.bean.CsvBindByName;

public class Car {

    @CsvBindByName(column = "brand")
    private String brand;
    @CsvBindByName(column = "model")
    private String model;
    @CsvBindByName(column = "year")
    private String year;

    public Car() {
    }

    public Car(String serial, String model, String year) {
        this.brand = serial;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String
    toString() {
        return String.format("%s %s %s", brand, model, year);
    }
}
