package Enums;

public enum Coin {
    One(1),
    Five(5),
    Ten(10);

    private Integer value;
    Coin(Integer value){
        this.value = value;
    }
}
