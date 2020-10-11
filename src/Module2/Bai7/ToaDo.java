package Module2.Bai7;

public class ToaDo {
    private String ten;
    private float x;
    private float y;

    /**
     * @return String return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return float return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return float return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * 
     */
    public ToaDo() {
    }

    /**
     * @param ten
     * @param x
     * @param y
     */
    public ToaDo(String ten, float x, float y) {
        this.ten = ten;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("%s (%.2f, %.2f)", ten, x, y);
    }
}
