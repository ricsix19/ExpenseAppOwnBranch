package ExpenseBackBone.Runner;

import ExpenseBackBone.Assets.Basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Üdvözöllek, kérlek add meg az összeget amivel szeretnél dolgozni: ");
        Scanner sc = new Scanner(System.in); //bekerem az osszeget usertol
        int money = sc.nextInt(); //kezdo money
        Basics startingMoney = new Basics(money);

        while(true) {
            Scanner choices = new Scanner(System.in); //ezzel kerem a valasztasi lehetosegeket

            System.out.println("Kérlek válassz az opciók közül: ");
            System.out.println("1. Pénzed kiiratása.");
            System.out.println("2. Meglévő összegedhez hozzáadás.");
            System.out.println("3. Kilépés");
            System.out.print("Kérlek add meg mit szeretnél választani: ");

            int choice = choices.nextInt(); //ez a switch-hez tartozik
            choices.nextLine();
            Scanner changeMoney = new Scanner(System.in); //ez a Scanner pedig a money addhoz tartozik.

            switch (choice){
                case 1:
                    System.out.println();
                    startingMoney.displayMoney();
                    break;
                case 2:
                    System.out.print("Kérlek add meg az összeget amit hozzá szeretnél adni meglévő összegedhez: ");
                    int updatedMoney = changeMoney.nextInt();
                    changeMoney.nextLine();
                    startingMoney.addMoneyToExisting(updatedMoney);
                    break;
                case 3:
                    System.out.println("Viszlát!");
                    choices.close();
                    //itt valamiert ha lefuttatod kiiratja a defaultot is amire nem tudok rajonni
                default:
                    System.out.println("Invalid num.");
                    return;
            }
        }
    }
}
