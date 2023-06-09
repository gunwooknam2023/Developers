package KIOSK;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    List<FoodMenu> burgersMenu = new ArrayList<>(); // 버거 리스트 생성
    List<FoodMenu> frozenCustardMenu = new ArrayList<>(); // 아이스크림 리스트 생성
    List<FoodMenu> drinksMenu = new ArrayList<>(); // 음료 리스트 생성
    List<FoodMenu> beerMenu = new ArrayList<>(); // 맥주 리스트 생성
    List<FoodMenu> waitingOrders = new ArrayList<>(); // 대기중인주문을 저장하는 리스트
    List<FoodMenu> finishedOrders = new ArrayList<>(); // 완료된주문을 저장하는 리스트
    List<Order> manageList = new ArrayList<>();    // 주문서 리스트(관리자가 볼 것)

    // adminMenu adminmenu = new adminMenu();
    Order order = new Order(); // Order클래스의 메서드를 사용하기위한 변수 order 생성
    Scanner sc = new Scanner(System.in);

//    int waitmenu = 0;
//    int completemenu = 0;

    // adminMenu adminmenu = new adminMenu();

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
        System.out.println("7. Order Status | 최근 완료된 주문 현황과 대기 현황을 안내합니다.");
        System.out.println();
        System.out.println("        관리자 모드(0)");
        System.out.println();

        System.out.print("메뉴선택 : ");
        int choice = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        switch (choice) {
            case 0:
                adminMode(); // 관리자모드
                break;
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
            case 7:
                OrderStatus(); // 주문현황 // 주문현황 메서드 출력
                break;
            default:
                System.out.println("1~7번까지의 숫자만 입력가능합니다."); // 1~6번 제외 숫자가 들어왔을때
                break;
        }
    }

    public void adminMode() {
        System.out.print("관리자 비밀번호를 입력하세요 : ");
        String password = sc.nextLine();

        if (password.equals("admin")) {
            System.out.println("비밀번호가 확인되었습니다.");
            while (true) {
                System.out.println();
                System.out.println("1.상품생성      2. 상품삭제      3. 대기주문관리       4. 완료주문관리      0.메뉴판으로 돌아가기");
                System.out.println("사용하실 메뉴를 선택하세요.");
                int adminNum = sc.nextInt();
                sc.nextLine();
                switch (adminNum) {
                    case 1:
                        createFood(); // 상품생성 메서드
                        break;
                    case 2:
                        deleteFood(); // 상품삭제 메서드
                        break;
                    case 3:
                        waitMgmt(); // 대기주문관리 메서드
                        break;
                    case 4:
                        finishedMgtm(); // 완료주문관리 메서드
                        break;
                    case 0:
                        showMainMenu();
                    default:
                        System.out.println("1~4번의 숫자만 입력 가능합니다.");
                        break;
                }
            }
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
            System.out.println("3초뒤 메뉴판으로 이동합니다.");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            showMainMenu();
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
            order.addToBasket(selectedBurger);
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
            order.addToBasket(selectedCustard);
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
            order.addToBasket(selectedDrinks);
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
            order.addToBasket(selectedBeer);
            System.out.println(selectedBeer.getName() + " 가 장바구니에 추가되었습니다.");
            System.out.println();
        } else if (check == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
        } else System.out.println("숫자를 잘못 입력하였습니다.");


        showMainMenu();
    }

    public void showOrderMenu() { // 주문화면(장바구니)
//        if (waitmenu >= 1 && completemenu >= 1) {
//            System.out.println();
//            System.out.println("최근 완료된 주문입니다.\n");
//            if (completemenu > 3) {
//                int i = 0;
//                for (Order o : manageList) {
//                    if (i < 3) {
//                        if (o.finished) {
//                            System.out.println("=============================================");
//                            System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                            printListData(o.getBasket());
//                            System.out.println("-- total : W " + o.totalPrice());
//                            System.out.println("-- 요청사항 : " + o.getRequest());
//                            System.out.println("-- 완료 일시 : " + o.finishedTime);
//                            i++;
//                        }
//                    }
//                }
//            } else {
//                for (Order o : manageList) {
//                    if (o.finished) {
//                        System.out.println("=============================================");
//                        System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                        printListData(o.getBasket());
//                        System.out.println("-- total : W " + o.totalPrice());
//                        System.out.println("-- 요청사항 : " + o.getRequest());
//                        System.out.println("-- 완료 일시 : " + o.finishedTime);
//                    }
//                }
//            }
//            System.out.println();
//
//            System.out.println("대기중인 주문입니다.\n");
//            for (Order o : manageList) {
//                // 완료 x 주문만 골라 출력
//                if (!o.finished) {
//                    System.out.println("=============================================");
//                    System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                    printListData(o.getBasket());
//                    System.out.println("-- 주문 일시 : " + o.orderedTime);
//                }
//            }
//            System.out.println();
//        } else if (waitmenu >= 1 && completemenu < 1) {
//            System.out.println();
//            System.out.println("최근 완료된 주문이 없습니다.\n");
//            System.out.println();
//
//            System.out.println("대기중인 주문입니다.\n");
//            for (Order o : manageList) {
//                // 완료 x 주문만 골라 출력
//                if (!o.finished) {
//                    System.out.println("=============================================");
//                    System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                    printListData(o.getBasket());
//                    System.out.println("-- 주문 일시 : " + o.orderedTime);
//                }
//            }
//            System.out.println();
//        } else if (waitmenu < 1 && completemenu >= 1) {
//            System.out.println();
//            System.out.println("최근 완료된 주문입니다.\n");
//            if (completemenu > 3) {
//                int j = 0;
//                for (Order o : manageList) {
//                    if (j < 3) {
//                        if (o.finished) {
//                            System.out.println("=============================================");
//                            System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                            printListData(o.getBasket());
//                            System.out.println("-- total : W " + o.totalPrice());
//                            System.out.println("-- 요청사항 : " + o.getRequest());
//                            System.out.println("-- 완료 일시 : " + o.finishedTime);
//                            j++;
//                        }
//                    }
//                }
//            } else {
//                for (Order o : manageList) {
//                    if (o.finished) {
//                        System.out.println("=============================================");
//                        System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
//                        printListData(o.getBasket());
//                        System.out.println("-- total : W " + o.totalPrice());
//                        System.out.println("-- 요청사항 : " + o.getRequest());
//                        System.out.println("-- 완료 일시 : " + o.finishedTime);
//                    }
//                }
//            }
//            System.out.println();
//
//            System.out.println("대기중인 주문이 없습니다.\n");
//            System.out.println();
//        }
        if (order.getBasket().isEmpty()) {
            System.out.println();
            System.out.println("장바구니가 비어 있습니다. 주문할 상품을 선택해주세요.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            showMainMenu();
            // 장바구니에 상품이 있으면 아래 실행
        } else {
            System.out.println();
            System.out.println("아래와 같이 주문 하시겠습니까?");
            System.out.println();
            System.out.println("[ Orders ]");

            List<FoodMenu> basket = order.getBasket();

            for (int i = 0; i < basket.size(); i++) {
                FoodMenu menu = basket.get(i);
                System.out.println(menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
            }
            System.out.println();
            System.out.println("[ Total ]");
            System.out.println("W " + order.totalPrice());

            System.out.println("\n1. 주문      2. 메뉴판");
            int checkNumber = sc.nextInt();
            sc.nextLine();

            if (checkNumber == 1) {
                System.out.println("주문 시 요청사항을 입력하시겠습니까?");
                System.out.println("\n1. 네      2. 아니요");
                int checkRequest = sc.nextInt();
                sc.nextLine();

                // 요청 사항 입력
                if (checkRequest == 1) {
                    System.out.println("요청사항을 입력해주세요 (최대 20자):");
                    String getRequest = sc.nextLine();

                    if (getRequest.isEmpty()) {
                        while (true) {
                            System.out.println("요청사항을 입력해주세요.");
                            addMemoAgain();
                            break;
                        }
                    } else if (getRequest.length() <= 20) {
                        System.out.println("요청사항이 정상적으로 전달되었습니다. 감사합니다.");
                        order.setRequest(getRequest); // 지역변수로 사용
                    } else {
                        System.out.println("죄송합니다. 총 20글자 내외로 작성해주시기 바랍니다.");
                        addMemoAgain();
                    }
                } else {
                    for (int i = 0; i < basket.size(); i++) {
                        order.setRequest("");
                        FoodMenu wait = basket.get(i);
                        waitingOrders.add(wait);
                    }
                    orderComplete(basket);
                }

                for (int i = 0; i < basket.size(); i++) {
                    FoodMenu wait = basket.get(i);
                    waitingOrders.add(wait);
                }
                orderComplete(basket); // 1.주문을 선택하면 OrderComplete()메서드를 불러와서 주문이 완료되었음을 알리고 대기번호를 부여후 메뉴판으로 돌아감
            } else if (checkNumber == 2) {
                System.out.println("메뉴판으로 돌아갑니다."); // 2.메뉴판을 선택하면 메뉴판으로 돌아감.
                showMainMenu();
            }
        }
    }

    // 조혜연 추가작성(0607) -- 요청사항을 오기입하는 경우, 재입력을 위한 메소드
    public void addMemoAgain() {
        String getRequest = sc.nextLine();
        order.setRequest(getRequest);
    }

//    // 손민지 추가작성(0607) - 요청사항 입력받기
//    public String getRequest() {
//        System.out.println("요청사항을 입력하세요.(20자 이내)");
//        String request = sc.nextLine();
//        if (request.length() > 20) {
//            System.out.println("요청사항은 총 20자로 제한됩니다.");
//            getRequest();
//        }
//        return request;
//    }

    // 손민지 추가작성(0607) - 성민님 메모에 있던거 가져왔습니다. 나중에 조건대로 수정하면 될 것 같아요.
    public static String setDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd h:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    public void printListData(List<FoodMenu> list) {
        System.out.println("-- 주문 상품 목록 --");
        for (FoodMenu m : list) {
            System.out.println(m.getName() + "   | " + m.getPrice() + " | " + m.getDescription());
        }
        System.out.println();
    }

    // 손민지 추가작성(0607)
    public void orderComplete(List<FoodMenu> basket) { // 주문완료, 대기번호 부여
        int orderNumber = order.getOrderNumber();
        List<FoodMenu> list = new ArrayList<>(basket);
        // 손민지 추가작성(0607) - 관리자가 보는 리스트에 주문 내용 추가
        String request = order.getRequest();
        manageList.add(new Order(orderNumber, list, request, setDate()));

        // order클래스의 getOrderNumber()을 호출해 order()안에 있는 orderNumber의 숫자를 받아서 orderNumber변수에 초기화
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다."); // 대기번호 출력
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
        System.out.println();

        order.clearBasket(); // 주문이 완료되었으니 카트를 초기화 시켜줌
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

 public void OrderStatus() { //주문현황
        
        // 소원님 코드
//        System.out.println();
//        System.out.println("[ 최근에 주문완료된 목록 ]");
//
//        if (finishedOrders.size() >= 4) {
//            System.out.println("4개 이상의 주문이 완료되었습니다.");
//        } else if (finishedOrders.size() == 0) {
//            System.out.print("주문완료된 상품이 없습니다.");
//        } else {
//            for (int i = 0; i < finishedOrders.size(); i++) {
//                FoodMenu finished = finishedOrders.get(i);
//                System.out.println(finished.getName() + "   | " + finished.getPrice() + " | " + finished.getDescription());
//            }
//        }
//        System.out.println();
//        System.out.println("-------------------------");
//        System.out.println("[ 대기 중인 주문목록 ]");
//        if (waitingOrders.size() == 0) {
//            System.out.print("대기 중인 상품이 없습니다.");
//        } else {
//            for (int i = 0; i < waitingOrders.size(); i++) {
//                FoodMenu wait = waitingOrders.get(i);
//                System.out.println(wait.getName() + "   | " + wait.getPrice() + " | " + wait.getDescription());
//            }
//        }
        System.out.println();
        System.out.println("[ 최근에 완료된 주문목록 ]");

        int i = 0;
        for(Order o : manageList){
            if(o.finished){
                System.out.println("=============================================");
                System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
                printListData(o.getBasket());
                System.out.println("-- 주문 일시 : " + o.orderedTime);
                System.out.println("-- 완료 일시 : " + o.finishedTime);
                i++;
            }
            if(i>2){
                break;
            }
        }
        if(i==0){
            System.out.print("주문 완료된 상품이 없습니다.");
        }

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("[ 대기 중인 주문 목록 ]");

        i=0;
        for(Order o : manageList){
            if(!o.finished){
                System.out.println("=============================================");
                System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
                printListData(o.getBasket());
                System.out.println("-- 주문 일시 : " + o.orderedTime);
                i++;
            }
            if(i>2){
                break;
            }
        }
        if(i==0){
            System.out.print("대기 중인 상품이 없습니다.");
        }

        System.out.println("메인 메뉴로 돌아갑니다.");
        showMainMenu();
    }


    public void OrderCancel() { // 주문취소
        System.out.println();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");

        int cancelNum = sc.nextInt(); // 확인할지 취소할지 번호를 받아옴.
        sc.nextLine(); // 개행문자 제거


        if (cancelNum == 1) {
            order.clearBasket(); // 사용자가 1.확인 선택시 order클래스안의 Clearbasket() 메서드를 호출해서 카트를 비워줌
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        } else if (cancelNum == 2) {
            System.out.println("주문을 유지하고 메뉴판으로 돌아갑니다."); // 유지시 메뉴판으로 돌아감


        }
        showMainMenu();
    }

    public void createFood() { // 상품생성 메서드
        System.out.println("추가할 상품의 카테고리를 선택하세요.");
        System.out.print("1. 버거    2. 아이스크림    3. 음료    4. 맥주 : ");
        int categoryNum = sc.nextInt();
        sc.nextLine();

        switch (categoryNum) {
            case 1: // 버거선택
                createBurger();
                break;

            case 2: // 아이스크림 메뉴
                createFrozen();
                break;

            case 3: // 음료 메뉴
                createDrinks();
                break;

            case 4: // 맥주 메뉴
                createBeer();
                break;

            default:
                System.out.println("1~4번의 숫자만 입력 가능합니다.");
        }
        showMainMenu();
    }

    public void createBurger() {
        System.out.println("버거 카테고리를 선택하셨습니다.");
        System.out.print("상품이름을 입력하세요 : ");
        String burgerName = sc.nextLine();

        System.out.print("상품가격을 입력하세요 (단위 : W x.x) : ");
        String burgerPrice = sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String burgerDescription = sc.nextLine();

        System.out.println("\n이름 : " + burgerName + "  가격 : " + burgerPrice + "  설명 : " + burgerDescription);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");
        int bcheckNum = sc.nextInt();
        sc.nextLine();

        if (bcheckNum == 1) {
            System.out.println("메뉴추가를 완료하였습니다. 메뉴판으로 돌아갑니다.\n");
            burgersMenu.add(new FoodMenu(burgerName, burgerPrice, burgerDescription));
        } else if (bcheckNum == 2) {
            System.out.println("메뉴추가를 취소하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else {
            System.out.println("번호를 잘못 입력하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void createFrozen() {
        System.out.println("아이스크림 카테고리를 선택하셨습니다.");
        System.out.print("상품이름을 입력하세요 : ");
        String frozenName = sc.nextLine();

        System.out.print("상품가격을 입력하세요 (단위 : W x.x) : ");
        String frozenPrice = sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String frozenDescription = sc.nextLine();

        System.out.println("\n이름 : " + frozenName + "  가격 : " + frozenPrice + "  설명 : " + frozenDescription);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");
        int fcheckNum = sc.nextInt();
        sc.nextLine();

        if (fcheckNum == 1) {
            System.out.println("메뉴추가를 완료하였습니다. 메뉴판으로 돌아갑니다.\n");
            frozenCustardMenu.add(new FoodMenu(frozenName, frozenPrice, frozenDescription));
        } else if (fcheckNum == 2) {
            System.out.println("메뉴추가를 취소하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else {
            System.out.println("번호를 잘못 입력하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void createDrinks() {
        System.out.println("음료 카테고리를 선택하셨습니다.");
        System.out.print("상품이름을 입력하세요 : ");
        String drinksName = sc.nextLine();

        System.out.print("상품가격을 입력하세요 (단위 : W x.x) : ");
        String drinksPrice = sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String drinksDescription = sc.nextLine();

        System.out.println("\n이름 : " + drinksName + "  가격 : " + drinksPrice + "  설명 : " + drinksDescription);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");
        int dcheckNum = sc.nextInt();
        sc.nextLine();

        if (dcheckNum == 1) {
            System.out.println("메뉴추가를 완료하였습니다. 메뉴판으로 돌아갑니다.\n");
            drinksMenu.add(new FoodMenu(drinksName, drinksPrice, drinksDescription));
        } else if (dcheckNum == 2) {
            System.out.println("메뉴추가를 취소하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else {
            System.out.println("번호를 잘못 입력하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void createBeer() {
        System.out.println("맥주 카테고리를 선택하셨습니다.");
        System.out.print("상품이름을 입력하세요 : ");
        String beerName = sc.nextLine();

        System.out.print("상품가격을 입력하세요 (단위 : W x.x) : ");
        String beerPrice = sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String beerDescription = sc.nextLine();

        System.out.println("\n이름 : " + beerName + "  가격 : " + beerPrice + "  설명 : " + beerDescription);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소       ");
        int beercheckNum = sc.nextInt();
        sc.nextLine();

        if (beercheckNum == 1) {
            System.out.println("메뉴추가를 완료하였습니다. 메뉴판으로 돌아갑니다.\n");
            beerMenu.add(new FoodMenu(beerName, beerPrice, beerDescription));
        } else if (beercheckNum == 2) {
            System.out.println("메뉴추가를 취소하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else {
            System.out.println("번호를 잘못 입력하셨습니다. 메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void deleteFood() { // 상품삭제 메서드
        System.out.println("삭제할 상품의 카테고리를 선택하세요");
        System.out.print("1. 버거    2. 아이스크림    3. 음료    4. 맥주 : ");
        int categoryNum = sc.nextInt();
        sc.nextLine();

        switch (categoryNum) {
            case 1: // 버거 선택
                deleteBurger();
                break;

            case 2: // 아이스크림 선택
                deleteFC();
                break;

            case 3: // 음료 선택
                deleteDrinks();
                break;

            case 4: // 맥주 선택
                deleteBeer();
                break;

            default:
                System.out.println("1~4번의 숫자만 입력 가능합니다.");
        }
    }

    public void deleteBurger() {
        System.out.println("\n버거 카테고리를 선택하셨습니다.\n");

        for (int i = 0; i < burgersMenu.size(); i++) {
            FoodMenu menu = burgersMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("\n삭제할 버거의 이름을 입력하세요 : ");
        String burgerName = sc.nextLine();

        boolean burgersF = false; // 버거가 존재하는지 확인하기 위한 boolean형 변수
        for (int i = 0; i < burgersMenu.size(); i++) {
            FoodMenu burgers = burgersMenu.get(i);
            if (burgers.getName().equals(burgerName)) {
                System.out.print(burgers.getName() + " 를 메뉴에서 삭제시키겠습니까? (1. 삭제        2. 취소) : ");
                int burgersCheck = sc.nextInt();
                sc.nextLine();
                if (burgersCheck == 1) {
                    burgersMenu.remove(i);
                    burgersF = true;
                    break;

                } else if (burgersCheck == 2) {
                    System.out.println("삭제를 취소합니다.");
                    System.out.println("메뉴판으로 이동합니다.\n");
                    showMainMenu();
                }
            }
        }
        if (burgersF == true) { // 버거 제거시
            System.out.println(burgerName + " 이 메뉴에서 삭제되었습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else if (burgersF == false) { // 버거이름이 존재하지 않을때
            System.out.println("존재하지 않는 버거이름을 입력하였습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void deleteFC() {
        System.out.println("\n아이스크림 카테고리를 선택하셨습니다.\n");

        for (int i = 0; i < frozenCustardMenu.size(); i++) {
            FoodMenu menu = frozenCustardMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("\n삭제할 아이스크림의 이름을 입력하세요 : ");
        String frozenCustardName = sc.nextLine();

        boolean frozenCustardF = false;
        for (int i = 0; i < frozenCustardMenu.size(); i++) {
            FoodMenu frozenCustard = frozenCustardMenu.get(i);
            if (frozenCustard.getName().equals(frozenCustardName)) {
                System.out.print(frozenCustard.getName() + " 를 메뉴에서 삭제시키겠습니까? (1. 삭제        2. 취소) : ");
                int frozenCustardCheck = sc.nextInt();
                sc.nextLine();
                if (frozenCustardCheck == 1) {
                    frozenCustardMenu.remove(i);
                    frozenCustardF = true;
                    break;

                } else if (frozenCustardCheck == 2) {
                    System.out.println("삭제를 취소합니다.");
                    System.out.println("메뉴판으로 이동합니다.\n");
                    showMainMenu();
                }

            }
        }

        if (frozenCustardF == true) {
            System.out.println(frozenCustardName + " 이 메뉴에서 삭제되었습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else if (frozenCustardF == false) {
            System.out.println("존재하지 않는 아이스크림 이름을 입력하였습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void deleteDrinks() {
        System.out.println("\n음료 카테고리를 선택하셨습니다.\n");

        for (int i = 0; i < drinksMenu.size(); i++) {
            FoodMenu menu = drinksMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("\n삭제할 음료의 이름을 입력하세요 : ");
        String drinksName = sc.nextLine();

        boolean drinksF = false;
        for (int i = 0; i < drinksMenu.size(); i++) {
            FoodMenu drinks = drinksMenu.get(i);
            if (drinks.getName().equals(drinksName)) {
                System.out.print(drinks.getName() + " 를 메뉴에서 삭제시키겠습니까? (1. 삭제        2. 취소) : ");
                int drinksCheck = sc.nextInt();
                sc.nextLine();
                if (drinksCheck == 1) {
                    drinksMenu.remove(i);
                    drinksF = true;
                    break;

                } else if (drinksCheck == 2) {
                    System.out.println("삭제를 취소합니다.");
                    System.out.println("메뉴판으로 이동합니다.\n");
                    showMainMenu();
                }

            }
        }

        if (drinksF == true) {
            System.out.println(drinksName + " 이 메뉴에서 삭제되었습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else if (drinksF == false) {
            System.out.println("존재하지 않는 음료 이름을 입력하였습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    public void deleteBeer() {
        System.out.println("\n맥주 카테고리를 선택하셨습니다.\n");

        for (int i = 0; i < beerMenu.size(); i++) {
            FoodMenu menu = beerMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getName() + "   | " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.print("\n삭제할 맥주의 이름을 입력하세요 : ");
        String beerName = sc.nextLine();

        boolean beerF = false;
        for (int i = 0; i < beerMenu.size(); i++) {
            FoodMenu beer = beerMenu.get(i);
            if (beer.getName().equals(beerName)) {
                System.out.print(beer.getName() + " 를 메뉴에서 삭제시키겠습니까? (1. 삭제        2. 취소) : ");
                int beerCheck = sc.nextInt();
                sc.nextLine();
                if (beerCheck == 1) {
                    beerMenu.remove(i);
                    beerF = true;
                    break;

                } else if (beerCheck == 2) {
                    System.out.println("삭제를 취소합니다.");
                    System.out.println("메뉴판으로 이동합니다.\n");
                    showMainMenu();
                }

            }
        }

        if (beerF == true) {
            System.out.println(beerName + " 이 메뉴에서 삭제되었습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        } else if (beerF == false) {
            System.out.println("존재하지 않는 맥주 이름을 입력하였습니다.");
            System.out.println("메뉴판으로 돌아갑니다.\n");
            showMainMenu();
        }
    }

    // 손민지 추가작성(0607) - 주문 건 별로 출력하도록 변경
    public void waitMgmt() { // 대기주문관리 메서드
//        List<FoodMenu> waiting = mainMenu.getWaitingOrders();
        System.out.println("대기주문관리를 선택하셨습니다.");
        System.out.println("대기중인 주문입니다.\n");

        // 관리자 리스트에 있는 주문 기록 출력
        for (Order o : manageList) {
            // 완료 x 주문만 골라 출력
            if (!o.finished) {
                System.out.println("=============================================");
                System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
                printListData(o.getBasket());
                System.out.println("-- total : W " + o.totalPrice());
                System.out.println("-- 요청사항 : " + o.getRequest());
                System.out.println("-- 주문 일시 : " + o.orderedTime);
            }
//            for (int i = 0; i < waitingOrders.size(); i++) {
//                FoodMenu wait = waitingOrders.get(i);
//                System.out.println(wait.getName() + "   | " + wait.getPrice() + " | " + wait.getDescription());
//            }

        }

        System.out.print("\n수행할 기능을 입력하세요 (1. 주문완료처리       2. 주문거절) : ");
        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            System.out.println("완료처리 할 주문 번호를 입력해주세요. : ");
            int orderNum = sc.nextInt();

            for (Order o : manageList) {
                if (o.getOrderNumber() == orderNum) {
                    // 주문번호가 orderNum인 주문이 완료 전이라면
                    if (!o.finished) {
                        o.finished = true;
                        o.finishedTime = setDate();

                        for(int i=0; i<waitingOrders.size(); i++) {
                            FoodMenu waits = waitingOrders.get(i);
                            finishedOrders.add(waits);
                        }

                        waitingOrders.clear();
                        System.out.println(o.getOrderNumber() + "번 주문을 완료했습니다. \n관리자 화면으로 돌아갑니다.");
                        break;
                    } else {
                        System.out.println("이미 완료된 주문 번호입니다.");
                        break;
                    }
                }
            }
        } else if (check == 2) {
            System.out.println("거절할 주문 번호를 입력해주세요. : ");
            int orderNum = sc.nextInt();

            System.out.println();
            for (Order o : manageList) {
                if (o.getOrderNumber() == orderNum) {
                    manageList.remove(o);
                    break;
                }
            }
        }
    }

    public void finishedMgtm() { // 완료주문관리 메서드
        System.out.println("완료주문관리를 선택하셨습니다.");
        System.out.println("완료된 주문입니다.\n");

        for (Order o : manageList) {
            if (o.finished) {
                System.out.println("=============================================");
                System.out.println("-- 주문 번호 : " + o.getOrderNumber() + " --");
                printListData(o.getBasket());
                System.out.println("-- total : W " + o.totalPrice());
                System.out.println("-- 요청사항 : " + o.getRequest());
                System.out.println("-- 주문 일시 : " + o.orderedTime);
                System.out.println("-- 완료 일시 : " + o.finishedTime);
            }
        }
//        for (int i = 0; i < finishedOrders.size(); i++) {
//            FoodMenu finished = finishedOrders.get(i);
//            System.out.println(finished.getName() + "   | " + finished.getPrice() + " | " + finished.getDescription());
//        }

        System.out.print("\n수행할 기능을 입력하세요 (1. 완료처리내역 삭제       2. 관리자 화면으로 돌아가기) : ");
        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            System.out.println("완료 내역에서 삭제 할 주문 번호를 입력해주세요. : ");
            int orderNum = sc.nextInt();

            // boolean found;

            for (Order o : manageList) {
                if (o.getOrderNumber() == orderNum) {
                    manageList.remove(o);
                    System.out.println(o.getOrderNumber() + " 번 완료 내역이 삭제되었습니다. ");
                    break;
                } else if (o.getOrderNumber() != orderNum) {
                    System.out.println("완료내역에 존재하지 않는 주문 번호입니다.");
                    break;
                    
                }


//                    if (!o.finished) {
//                        manageList.remove(o);
//                        break;
//                    } else {
//                        System.out.println("완료내역에 존재하지 않는 주문 번호입니다.");
//                        break;
//                    }

            }
        } else if (check == 2) {
            System.out.println("관리자 화면으로 돌아갑니다.");
        }
        return;
    }

}
