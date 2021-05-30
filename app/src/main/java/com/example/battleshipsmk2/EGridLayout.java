package com.example.battleshipsmk2;

public enum EGridLayout {

    CUSTOM(10,10),
    CLASSIC(10,10),
    DOUBLE_SIZE(20,20),
    LANDSCAPE(10,5),
    PORTRAIT(5,10)
    ;
    private int numOfColumns;
    private int numOfRows;

    EGridLayout(int numOfColumns, int numOfRows){
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
    }

    public int getNumOfColumns() {
        return numOfColumns;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public static void setCustomGridSize(int numOfColumns, int numOfRows) {
        //TODO Test this and game settings
        EGridLayout.CUSTOM.numOfColumns = numOfColumns;
        EGridLayout.CUSTOM.numOfRows = numOfRows;
    }
}
