package KIOSK;

public class FoodMenu{
    private String name; // 상품이름
    private String price; //상품가격
    private String description; //상품설명

    public FoodMenu(String name, String price, String description) { // 이름, 가격, 설명을 넘겨받아 위의 private String 변수에 대입
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    } // 가지고있는 이름 리턴

    public String getPrice() {
        return price;
    } // 가지고있는 가격 리턴

    public String getDescription() {
        return description;
    } // 가지고있는 설명 리턴
}


