import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer implements MainMenu, Search, GoodsFilter {
    GoodsStorage warehouse;
    CustomersBasket basket;
    List<Goods> purchases;
    Scanner scanner = new Scanner(System.in);
    boolean session = true;
    List<Goods> filteredList;

    public Customer(GoodsStorage warehouse) {
        basket = new CustomersBasket(warehouse);
        purchases = new ArrayList<>();
        this.warehouse = warehouse;
        filteredList = warehouse.getStock();
    }

    public void purchasing() {
        welcomeScreen();
    }

    @Override
    public void welcomeScreen() {
        while (session) {
            System.out.println("Welcome to shop!\n" +
                    "Please chose one of following actions (enter the number):\n" +
                    "1.Search for products\n" +
                    "2.Check out your basket\n" +
                    "3.Check out your purchases\n" +
                    "4.End");
            String request = scanner.nextLine();
            switch (request) {
                case ("1"):
                    search();
                    break;
                case ("2"):
                    toBasket();
                    break;
                case ("3"):
                    printArr(purchases);
                    welcomeScreen();
                    break;
                case ("4"):
                    session = false;
                    break;
                default:
                    System.out.println("Entered data was not a number, please try again");
                    welcomeScreen();
            }
        }
    }

    @Override
    public void search() {
        while (session) {

            System.out.println("There are some position we can suggest for you:");
            printArr(filteredList);

            System.out.println("Please enter number of position to add to basket or enter one of following actions:\n" +
                    "menu -> Go to main menu\n" +
                    "end -> exit without save\n" +
                    "filter -> add filter");
            String request = scanner.nextLine();

            switch (request) {
                case ("menu"):
                    welcomeScreen();
                    break;
                case ("end"):
                    session = false;
                    break;
                case ("filter"):
                    filter();
                    break;
                default:
                    Integer num = Integer.parseInt(request);
                    if (num > 0 & num <= filteredList.size()) {
                        if (basket.addGoods(filteredList.get(num - 1))) {
                            System.out.println("position added to basket");
                        } else {
                            System.out.println("Unfortunately this position can not be added");
                        }
                    } else {
                        System.out.println("Number is out of range, please enter number of position");
                        search();
                    }

            }
        }
    }

    @Override
    public void filter() {
        while (session) {

            System.out.println("There are some position we can suggest for you:");
            printArr(filteredList);

            System.out.println("Please enter one of following filtration options:\n" +
                    "1. filter by max price\n" +
                    "2. filter by min price\n" +
                    "3. filter by key word\n" +
                    "4. clear all filters\n" +
                    "menu -> Go to main menu\n" +
                    "end -> exit without save");

            String request = scanner.nextLine();
            switch (request) {
                case ("1"):
                    filterByMaxPrice();
                    search();
                    break;
                case ("2"):
                    filterByMinPrice();
                    search();
                    break;
                case ("3"):
                    filterByKeyWord();
                    search();
                    break;
                case ("4"):
                    filteredList = warehouse.getStock();
                    break;
                case ("menu"):
                    welcomeScreen();
                    break;
                case ("end"):
                    session = false;
                    break;
                default:
                    System.out.println("Entered data was incorrect, please try again");
                    filter();
            }
        }
    }

    private void filterByMaxPrice() {
        System.out.println("Please enter max price:");
        int maxPrice = Integer.parseInt(scanner.nextLine());
        filteredList = filteredList.stream()
                .filter(x -> x.getPrice() <= maxPrice)
                .toList();
    }

    private void filterByKeyWord() {
        System.out.println("Please enter min price:");
        String keyWord = scanner.nextLine();
        filteredList = filteredList.stream()
                .filter(x -> x.goodsName.contains(keyWord) | x.getVendor().contains(keyWord))
                .toList();
    }

    private void filterByMinPrice() {
        System.out.println("Please enter min price:");
        int minPrice = Integer.parseInt(scanner.nextLine());
        filteredList = filteredList.stream()
                .filter(x -> x.getPrice() >= minPrice)
                .toList();
    }

    private void toBasket() {
        while (session) {
            System.out.println("Here is your basket:");
            System.out.println();
            printArr(basket.getStock());
            System.out.println();
            System.out.println("Please choose one of following actions:\n" +
                    "1. Apply purchasing\n" +
                    "2. Exit without save");
            String request = scanner.nextLine();
            switch (request) {
                case ("1"):
                    apply();
                    break;
                case ("2"):
                    session = false;
                    break;
                default:
                    System.out.println("Incorrect data, please try again");
                    toBasket();
            }
        }
    }

    private void apply() {
        basket.getStock().forEach(x -> {
            warehouse.pullGoods(x);
            purchases.add(x);
        });
        System.out.println("Congratulations on your purchasing! Thank you for choosing our service! Hope you enjoyed it!");
        welcomeScreen();
    }

    private void printArr(List<?> list) {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();
        list.forEach(System.out::println);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println();
    }


}
