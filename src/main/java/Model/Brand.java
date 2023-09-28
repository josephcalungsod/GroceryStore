package Model;

public class Brand extends Inventory {
    private int brandId;
    private String brandName;

    public Brand (int brandItemId, String brandName) {
        this.brandId = brandItemId;
        this.brandName = brandName;
    }

    public int getBrandItemId() {
        return brandId;
    }

    public void setBrandItemId(int brandItemId) {
        this.brandId = brandItemId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandItemId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
