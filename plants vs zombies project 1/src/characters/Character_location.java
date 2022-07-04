package characters;

public class Character_location {

    private String column;
    private int row;

    public Character_location(String column, int row) {
        this.column = column;
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
