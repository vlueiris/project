package Main;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class Utility {

    // --------------------------------------------
    public enum ANSIColor {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        MAGENTA("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String code;

        ANSIColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    // ===================================================================================================================
    public static void showOptionsMenuChooseActions(String promptString, List<String> options,
            List<Runnable> actions) {
        int chosen_index = -2;
        City.showBudgetLine();
        while (chosen_index != -1) {

            System.out.print("\n" + promptString + "\n");

            for (int i = 0; i < options.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + options.get(i));
            }
            System.out.println("\t0. Return or exit");
            System.out.print("\nEnter your choice: ");

            try {
                chosen_index = City.scanner.nextInt();
                chosen_index--;
                if (chosen_index < -1 || chosen_index >= options.size()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                City.printErrorMessage("Invalid choice. Please enter a number.");
                City.scanner.nextLine();
                continue;
            }
            // valid choice made
            if (chosen_index == -1)
                break;
            else
                // an action was chosen
                actions.get(chosen_index).run();
        }
    }

    // ===================================================================================================================
    public static void listProperties(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.print("\n");
        while (clazz != null) {

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                try {
                    Object value = field.get(obj);
                    // System.out.println(field.getName() + " = " + value);
                    System.out.print(
                            Utility.ANSIColor.BLUE.getCode() + "\t" + field.getName() + " = "
                                    + Utility.ANSIColor.WHITE.getCode());

                    if (value instanceof Collection) {
                        System.out.println(Utility.ANSIColor.BLUE.getCode() + "[" + Utility.ANSIColor.WHITE.getCode());
                        for (Object item : (Collection<?>) value) {
                            listProperties(item);
                        }
                        System.out.println(Utility.ANSIColor.BLUE.getCode() + "]" + Utility.ANSIColor.WHITE.getCode());
                    } else {
                        System.out
                                .println(Utility.ANSIColor.BLUE.getCode() + value + Utility.ANSIColor.WHITE.getCode());
                    }

                } catch (IllegalAccessException e) {
                    // handle exception
                }
            }
            clazz = clazz.getSuperclass();

        }
    }

}
