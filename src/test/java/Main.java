import org.openqa.selenium.By;


public class Main {


    public static void main(String[] args) throws InterruptedException {
      LoginTest loginTest = new LoginTest();
//
//       loginTest.loginWithValidData();

        CartTest cartTest = new CartTest();
//        cartTest.addToCart();
        wait(3);

        WishListTest wishListTest = new WishListTest();
//        wishListTest.addToWishListTest();

        RegisterTest registerTest = new RegisterTest();
//        registerTest.registerForNewUser();

        loginTest.loginWithValidName();


    }


    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
