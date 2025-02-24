/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.isBlank()) {
                System.out.println("Input must not be empty! Please enter again!");
            } else {
                return input;
            }
        }
    }

    public static String inputStringInFormat(String[] format) {
        while (true) {
            try {
                String input = inputString();
                for (String str : format) {
                    if (input.equalsIgnoreCase(str)) {
                        return input;
                    }
                }
                throw new IllegalArgumentException("Wrong format! Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputPositiveInteger() {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                if (input > 0) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Input must be positive! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static double inputPositiveDouble() {
        while (true) {
            try {
                double input = Double.parseDouble(inputString());
                if (input > 0) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Input must be positive! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid double format! Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputIntegerInRange(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Input must be in range (" + min + ", " + max + ")! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputInteger() {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            }
        }
    }

    public static int inputIntegerGreaterThanANumber(int n) {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                if (input >= n) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Input must be in range greater or equal than " + n + "! Please enter again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format! Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputBinary() {
        while (true) {
            String input = inputString();
            if (input.matches("[01]+")) {
                return input;
            } else {
                System.out.println("Input must contains 0 and 1! Please enter again!");
            }
        }
    }

    public static String inputHexadecimal() {
        while (true) {
            String input = inputString();
            if (input.matches("[0-9A-Fa-f]+")) {
                return input;
            } else {
                System.out.println("Input must contain 0-9, A-F, or a-f! Please enter again!");
            }
        }
    }

    public static float inputFloat() {
        while (true) {
            try {
                float input = Float.parseFloat(inputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid float format! Please enter again!");
            }
        }
    }

    public static double inputDouble() {
        while (true) {
            try {
                double input = Double.parseDouble(inputString());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Invalid double format! Please enter again!");
            }
        }
    }

    public static String inputOperator() {
        while (true) {
            String input = inputString();
            if (input.matches("^[+\\-*/=^]$")) {
                return input;
            } else {
                System.out.println("Input must contain one of the following characters(+, -, *, /, ^, =)!");
                System.out.println("Please enter again!");
            }
        }
    }

    public static String inputDigitStringWithLength(int n) {
        while (true) {
            try {
                String input = inputString();
                if (input.matches("[0-9]+") && input.length() == n) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Data input is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputAlphabetStringWithBlank() {
        while (true) {
            try {
                String input = inputString();
                if (input.matches("^[a-zA-Z\\s]+$")) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Data input is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputbirthYear() {
        while (true) {
            try {
                int input = Integer.parseInt(inputString());
                LocalDate localDate = LocalDate.now();
                int currentYear = localDate.getYear();
                if (input < currentYear) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Data input is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static String inputStringWithLengthLessThan(int n) {
        while (true) {
            try {
                String input = inputString();
                if (input.length() <= 30) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Data input is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static Date inputDateFormatInFuture() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        while(true) {
            try {
                String input = inputString();
                Date date = sdf.parse(input);
                Date now = new Date();
                if (date.after(now)) {
                    return date;
                } else {
                    System.out.println("Data input is invalid! Date must be in the future!");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format (dd/MM/yyyy)! Please enter again!");
            }
        }
    }
    
    public static boolean checkBeginEndDate(Date begin, Date end) {
        return begin.before(end);
    }
    
    public static Date inputTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mma");
        sdf.setLenient(false);
        while(true) {
            try {
                Date input = sdf.parse(inputString());
                Date now = new Date();
                if (input.after(now) && input.before(date)) {
                    return input;
                } else {
                    System.out.println("Data input is invalid!");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format (dd/MM/yyyy HH:mma)! Please enter again!");
            }
        }
    }
    
    public static String inputDigitString() {
        while (true) {
            try {
                String input = inputString();
                if (input.matches("[0-9]+")) {
                    return input;
                } else {
                    throw new IllegalArgumentException("Data input is invalid!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
