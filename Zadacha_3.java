package DZ_4;
// 3. В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Zadacha_3 {

    public static Scanner scan = new Scanner(System.in, encoding());
    public static Logger logger = Logger.getLogger(Zadacha_3.class.getName());

    public static String encoding() {
        String encoding = System.getProperty("console.encoding", "cp866");
        return encoding;
    }

    public static int step = 0;

    public static void main(String[] args) {
        calculator(true);
    }

    public static void calculator(boolean startCalculator) {
        try {
            FileHandler fh = new FileHandler("./DZ_4/Zadacha_3.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stack<Float> res = new Stack<>();
        while (startCalculator) {
            float firstNum;
            if (res.size() == 0) {
                System.out.print("Введите 1 число: ");
                firstNum = scan.nextFloat();
            } else {
                System.out.println("Первое число: " + res.get(step - 1));
                firstNum = res.get(step - 1);
            }
            System.out.print("Выберите действие ( / * - + ): ");
            String action = scan.next();

            System.out.print("Введите 2 число: ");
            float secondNum = scan.nextFloat();

            switch (action) {
                case "/":
                    if (secondNum == 0)
                        System.out.println("На ноль делить нельзя!");
                    else {
                        res.add(firstNum / secondNum);
                    }
                    break;
                case "*":
                    res.add(firstNum * secondNum);
                    break;
                case "-":
                    res.add(firstNum - secondNum);
                    break;
                case "+":
                    res.add(firstNum + secondNum);
                    break;
                default:
                    System.out.println("Вы ввели  не правильное действие!");
                    break;
            }
            logger.info(beautyShowNum(firstNum) + " " + action + " " + beautyShowNum(secondNum) + " = "
                    + beautyShowNum(res.get(step)));

            System.out.println(beautyShowNum(firstNum) + " " + action + " " + beautyShowNum(secondNum) + " = "
                    + beautyShowNum(res.get(step)));

            System.out.println("Текущее значение = " + beautyShowNum(res.get(step)));
            System.out.println(
                    "Выберите дейстиве:\n\"end\" - чтобы закончить\n\"next\" - чтобы продолжить\n\"back\" - вернуть прошлое значение");
            boolean choiseAction = true;
            while (choiseAction) {
                String job = scan.next();
                if (job.equals("end")) {
                    startCalculator = false;
                    step = 0;
                    choiseAction = false;
                } else if (job.equals("next")) {
                    step++;
                    choiseAction = false;
                } else if (job.equals("back")) {
                    res.remove(step);
                    choiseAction = false;
                } else {
                    System.out.println("Не правильный ввод команды!");
                }
            }
        }
    }

    public static String beautyShowNum(float d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
}