package FundamentalsCourse.objectsAndClasses_6.MoreEx.RawData_02;

public class Tire {
    private double pressure;
    private int age;

    public Tire (double pressure, int age){
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure(){
        return this.pressure;
    }
}