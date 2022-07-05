package model.dto;

public class UserCartDTO {
    
    private int ucId;
    private String mId;
    private int pId;
    private int cQuantity;
    
    // 카트보기에서 조인하는 product 테이블 내용. 스프링에서 다른 방법 찾아보기
    private String pName;
    private int price;
    private String thumbnail;
    
    
    public int getUcId() {
        return ucId;
    }
    public void setUcId(int ucId) {
        this.ucId = ucId;
    }
    public String getmId() {
        return mId;
    }
    public void setmId(String mId) {
        this.mId = mId;
    }
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
    public int getcQuantity() {
        return cQuantity;
    }
    public void setcQuantity(int cQuantity) {
        this.cQuantity = cQuantity;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
