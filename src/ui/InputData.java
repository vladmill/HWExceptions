package ui;

import exceptions.FIOException;
import exceptions.GenderException;
import exceptions.PhoneNumberException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData {
    private View view;
    private String[] inputArray;

    public InputData(View view) {
        this.view = view;
    }

    private static boolean isAlpha(String s) {
        return s != null && s.chars().allMatch(Character::isLetter);
    }

    public String[] getData() {
        if(checkInput()) {
            return inputArray;
        }
        return null;
    }
    private boolean checkInput() {
        int code = scanner();
        if (code == 1) {
            String temp;
            for (int i = 0; i < inputArray.length; i++) {
                temp = inputArray[i];
                if (i < 3) {
                    if (!isAlpha(temp)) {
                        try {
                            throw new FIOException("Invalid input full name.");
                        } catch (FIOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (i == 3) {
                    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        formatter.parse(temp);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 4) {
                    if (!temp.matches("[0-9]+")) {
                        try {
                            throw new PhoneNumberException("Invalid input phone number.");
                        } catch (PhoneNumberException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if(i==5){
                    if (!temp.equalsIgnoreCase("m") && !temp.equalsIgnoreCase("f")){
                        try {
                            throw new GenderException("Invalid input gender.");
                        } catch (GenderException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else if (code == 54321) {
            System.out.println("Ошибка 54321. Вы ввели БОЛЬШЕ данных чем требуется.\n");
            checkInput();
        } else if (code == 12345) {
            System.out.println("Ошибка 12345. Вы ввели МЕНЬШЕ данных чем требуется.\n");
            checkInput();
        } else if (code == 0) {
            System.out.println("Ошибка 0. Вы ничего не ввели.\n");
            checkInput();
        }
        return true;
    }

    private int scanner() {
        int result = 0;
        String[] arr = null;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите через пробел:%nФамилию Имя Отчество Дату рождения (дд.мм.гггг) Номер телефона (целое число без форматирования) Пол (m / f)%n");
        String str = sc.nextLine();
        if (!str.isEmpty()) {
            arr = str.split(" ");
            int length = arr.length;
            int numData = 6;
            if (length == numData) {
                inputArray = arr;
                result = 1;
            } else if (length > numData) {
                result = 54321;
            } else if (length < numData) {
                result = 12345;
            }
        }
        return result;
    }
}
