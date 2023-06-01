package KIOSK;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    List<FoodMenu> burgersMenu = new ArrayList<>(); // 버거 리스트 생성
    List<FoodMenu> frozenCustardMenu = new ArrayList<>(); // 아이스크림 리스트 생성
    List<FoodMenu> drinksMenu = new ArrayList<>(); // 음료 리스트 생성
    List<FoodMenu> beerMenu = new ArrayList<>(); // 맥주 리스트 생성
    Order order = new Order(); // Order클래스의 메서드를 사용하기위한 변수 order 생성
    Scanner sc = new Scanner(System.in);

    public MainMenu() { // 각각의 리스트에 이름, 가격, 설명 추가
        burgersMenu.add(new FoodMenu("ShackBurger", "W 6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersMenu.add(new FoodMenu("SmokeShack", "W 8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersMenu.add(new FoodMenu("Shroom Burger", "W 9.4", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));

        frozenCustardMenu.add(new FoodMenu("Shake of the Week", "W 6.5", "특별한 커스터드 플레이버"));
        frozenCustardMenu.add(new FoodMenu("Red Bean Shake", "W 6.5", "신선한 커스터드와 함께 우유와 레드빈이 플레이된 시즈널 쉐이크"));
        frozenCustardMenu.add(new FoodMenu("Floats", "W 5.9", "루트 비어, 퍼플 카우, 크림시클"));

        drinksMenu.add(new FoodMenu("Fresh Brewed Iced Tea", "W 3.4", "직접 유기농 홍차를 우려낸 아이스티"));
        drinksMenu.add(new FoodMenu("Fifty/Fifty", "W 3.5", "레몬에이드와 아이스티의 만남"));
        drinksMenu.add(new FoodMenu("Fountain Soda", "W 2.7", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"));

        beerMenu.add(new FoodMenu("ShackMeister Ale", "W 9.8", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
        beerMenu.add(new FoodMenu("Magpie Brewing Co.", "W 6.8", "Pale Ale, Draft"));
        beerMenu.add(new FoodMenu("The Hand and Malt", "W 6.8", "IPA, Can"));

    }


    public void showMainMenu() {
        System.out.println("\"SHAKESHACK BURGER에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져 만든 버거");
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println();
        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

        System.out.print("메뉴선택 : ");
        int choice = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        switch (choice) {
            case 1:
                showBurgersMenu(); // 버거 메뉴판 출력
                break;
            case 2:
                showFrozenCustardMenu(); // 아이스크림 메뉴판 출력
                break;
            case 3:
                showDrinksMenu(); // 음료 메뉴판 출력
                break;
            case 4:
                showBeerMenu(); // 맥주 메뉴판 출력
                break;
            case 5:
                showOrderMenu(); // 장바구니 메서드 출력
                break;
            case 6:
                OrderCancel(); // 주문취소 메서드 출력
                break;
            default:
                System.out.println("1~6번까지의 숫자만 입력가능합니다."); // 1~6번 제외 숫자가 들어왔을때
                break;
        }
    }


    public void showBurgersMenu() { // 버거관련
        System.out.println();
        System.out.println("[ Burgers Menu ]");
        for (int i = 0; i < burgersMenu.size(); i++) {    // burgerMenu리스트에 있는 size만큼 반복 (size는 3이므로 i=0,1,2)
            FoodMenu menu = burgersMenu.get(i);        // burgerMenu리스트에서 get()을 사용하여 menu안에 버거정보를 대입
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }      // (i+1)을 사용한 이유는 i는 배열의 첫번째값부터 출력하기위해 0을 사용하였는데, 번호는 1번부터
        // 출력해야하니 i+1을 해줘서 1,2,3이 출력되게 만들어줬음.

        System.out.print("상품선택 : ");
        int chooiseBurgers = sc.nextInt(); // 3개의 버거중 추가할 버거 선택
        sc.nextLine(); // 개행문자 제거

        int burgerInfo = chooiseBurgers - 1; // 사용자가 선택한 숫자와 리스트의 번호를 맞추기위해 -1을 해줌

        FoodMenu selectedBurger = burgersMenu.get(burgerInfo);       // FoodMenu형 객체를 만들어서 burgerInfo번째 정보를 대입
        System.out.println("\n" + "\"" + selectedBurger.getName() + "      | " + selectedBurger.getPrice()
                + " | " + selectedBurger.getDescription() + "\"");   // 정보를 사용자에게 출력
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addbasket(selectedBurger);
            System.out.println(selectedBurger.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");

        showMainMenu(); // 모든 기능이 종료되면 MainMenu를 호출해줌
    }


    public void showFrozenCustardMenu() { // 아이스크림 관련
        System.out.println();
        System.out.println("[ Frozen Custard Menu ]");
        for (int i = 0; i < frozenCustardMenu.size(); i++) {
            FoodMenu menu = frozenCustardMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int chooiseFrozenCustard = sc.nextInt();
        sc.nextLine();

        int custardInfo = chooiseFrozenCustard - 1;

        FoodMenu selectedCustard = frozenCustardMenu.get(custardInfo);
        System.out.println("\n" + "\"" + selectedCustard.getName() + "      | " + selectedCustard.getPrice()
                + " | " + selectedCustard.getDescription() + "\"");   // 정보를 사용자에게 출력
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addbasket(selectedCustard);
            System.out.println(selectedCustard.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");

        showMainMenu();
    }


    public void showDrinksMenu() { // 음료 관련
        System.out.println();
        System.out.println("[ Drinks Menu ]");
        for (int i = 0; i < drinksMenu.size(); i++) {
            FoodMenu menu = drinksMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int chooiseDrinks = sc.nextInt();
        sc.nextLine();

        int DrinksInfo = chooiseDrinks - 1;

        FoodMenu selectedDrinks = drinksMenu.get(DrinksInfo);
        System.out.println("\n" + "\"" + selectedDrinks.getName() + "      | " + selectedDrinks.getPrice()
                + " | " + selectedDrinks.getDescription() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addbasket(selectedDrinks);
            System.out.println(selectedDrinks.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");

        showMainMenu();
    }


    public void showBeerMenu() { // 맥주 관련
        System.out.println();
        System.out.println("[ Beer Menu ]");
        for (int i = 0; i < beerMenu.size(); i++) {
            FoodMenu menu = beerMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("상품선택 : ");
        int chooiseBeer = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        int beerInfo = chooiseBeer - 1;

        FoodMenu selectedBeer = beerMenu.get(beerInfo);
        System.out.println("\n" + "\"" + selectedBeer.getName() + "      | " + selectedBeer.getPrice()
                + " | " + selectedBeer.getDescription() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            order.addbasket(selectedBeer);
            System.out.println(selectedBeer.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");


        showMainMenu();
    }


    public void showOrderMenu() { // 주문화면(장바구니)
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        List<FoodMenu> basket = order.getbasket();
        // FoodMenu 리스트형식 basket을 생성. order안에있는 getbasket()을 통해서 basket안의 값을 리턴받아서 대입.

        for (int i = 0; i < basket.size(); i++) { // 넘겨받은 basket의 길이만큼 반복해서 장바구니안의 메뉴를 출력
            FoodMenu menu = basket.get(i); // FoodMenu형식의 menu를 만들어서 basket안에 들어있는 0번째 값부터 가져옴
            System.out.println(menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + order.totalPrice()); // order클래스안의 totalPrice()을 실행시켜 총값을 출력

        System.out.println("\n1. 주문      2. 메뉴판");
        int checkNumber = sc.nextInt(); // 주문할지 메뉴판으로 돌아갈지 선택.
        sc.nextLine(); // 개행문자 제거

        if (checkNumber == 1) {
            OrderComplete(); // 1.주문을 선택하면 OrderComplete()메서드를 불러와서 주문이 완료되었음을 알리고 대기번호를 부여후 메뉴판으로 돌아감

        } else if (checkNumber == 2) {
            System.out.println("메뉴판으로 돌아갑니다."); // 2.메뉴판을 선택하면 메뉴판으로 돌아감.
            showMainMenu();
        }


    }


    public void OrderComplete() { // 주문완료, 대기번호 부여
        int orderNumber = order.getOrderNumber();
        // order클래스의 getOrderNumber()을 호출해 order()안에 있는 orderNumber의 숫자를 받아서 orderNumber변수에 초기화
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다."); // 대기번호 출력
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
        System.out.println();

        order.Clearbasket(); // 주문이 완료되었으니 카트를 초기화 시켜줌
        order.setOrderNumber(orderNumber + 1);
        // 대기번호를 사용하였으니 setOrderNumber 메서드안에 orderNumber +1 을 넘겨주어서
        // order클래스안의 orderNumber를 1증가시켜줌

        try { // 3초간 지연시키려고 Thread의 .sleep 사용 또한 예외처리를 하지않으면 사용불가능하기때문에 try-catch문 사용
            Thread.sleep(3000); // millis단위이기 떄문에 1000millis = 1초 고로 3초간 재움
        } catch (InterruptedException e) { // InterruptedException 예외상황 발생시
            System.out.println(e); // 경고문 e를 출력
        }
        showMainMenu(); // 예외상황발생없이 위의 Thread.sleep(3000)이 try되면 메인메뉴로 돌아감.
    }


    public void OrderCancel() { // 주문취소
        System.out.println();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");

        int cancelNum = sc.nextInt(); // 확인할지 취소할지 번호를 받아옴.
        sc.nextLine(); // 개행문자 제거


        if (cancelNum == 1) {
            order.Clearbasket(); // 사용자가 1.확인 선택시 order클래스안의 Clearbasket() 메서드를 호출해서 카트를 비워줌
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        } else if (cancelNum == 2) {
            System.out.println("주문을 유지하고 메뉴판으로 돌아갑니다."); // 유지시 메뉴판으로 돌아감


        }
        showMainMenu();
    }
}

