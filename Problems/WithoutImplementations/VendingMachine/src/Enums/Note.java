package Enums;

public enum Note {
    Twenty(20),
    Fifty(50),
    Hundred(100);

    private Integer value;
    Note(Integer value){
        this.value = value;
    }
}
