public class Car implements Vehicle {
    private String name;
    private String manufacturer;
    private int fuel;
    // int integer 차이는?
    // long Long 차이는?

    public Car(String name, String manu) {
        this.name = name;
        this.manufacturer = manu;
    }

    // return값이 없을 경우 void
    public void clarkson() {
        System.out.println("Clarkson");
    }

    // String을 반환할게~
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    // 행위 구현부
    public String run(Driver driver) {
        if(driver.canDrive()) {
            return "자동차 시동 겁니다";
        } else {
            return "안됩니다!";
        }
    }
}
