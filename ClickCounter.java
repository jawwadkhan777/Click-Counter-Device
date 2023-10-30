package Projects;

import java.util.Scanner;

abstract class Device {
    private int counter;
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    protected void pushButton() {
        System.out.println("Count-up--> " + ++counter);
    }
    protected void resetButton() {
        counter = 0;
        System.out.println("Counter-reset--> "+counter);
    }
    protected void closeButton() {
        System.out.println("-------Counter close-------");
    }
}
public class ClickCounter extends Device {
    ClickCounter() {
        this.setCounter(0);
        instruction();
        inputButton();
    }
    void instruction() {
        System.out.print("INSTRUCTIONS:\n\tIt is a Clicker-Counter device. to increment the counter press 1," +
                "\n\tto reset the counter press 0 and for closing the counter press -1." +
                "\n\tPress enter to start the counter: ");
    }
    void inputButton() {
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        System.out.println("___________________________________________________________________");
        System.out.println("Counter-set--> "+ getCounter());
        while (true) {
            System.out.print("Press button: ");
            int button = scan.nextInt();
            switch (button) {
                case 1:
                    pushButton();
                    break;
                case 0:
                    resetButton();
                    break;
                case -1:
                    closeButton();
                    scan.close();
                    return;
                default:
                    System.out.print("Invalid press, ");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        new ClickCounter();
    }
}
