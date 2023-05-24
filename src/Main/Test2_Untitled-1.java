    // ===================================================================================================================
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    
    public class ObjectChooser {
        public static <T extends Base> T chooseObject(Class<T> derivedClass, List<Terminal> terminals) {
            // Scanner scanner = new Scanner(System.in);
    
            List<T> derivedObjects = new ArrayList<>();
            for (Terminal _terminal : terminals) {
                if (derivedClass.isInstance(_terminal)) {
                    derivedObjects.add(derivedClass.cast(_terminal));
                    System.out.println(
                        "\t" + (derivedObjects.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
                }
            }
            

            if (derivedObjects.size() == 0) {
                System.out.println("The city has no "+derivedClass.getSimpleName()+"s!");
                return;
            }
            int chosen_derivedTerminal_index = -1;

    
            System.out.println("Choose one of the " + derivedClass.getSimpleName() + "s: ");
    
            // for (int i = 0; i < derivedObjects.size(); i++) {
            //     System.out.println((i + 1) + ". " + derivedObjects.get(i));
            // }
    
            // int choice = scanner.nextInt();
            // T chosenObject = derivedObjects.get(choice - 1);
            // return chosenObject;
            while (true) {
                try {
                    chosen_derivedTerminal_index = scanner.nextInt();
                    chosen_derivedTerminal_index--;
                    if (chosen_derivedTerminal_index < 0 || chosen_derivedTerminal_index >= derivedObjects.size()) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    continue;
                }
            }

            return derivedObjects.get(chosen_derivedTerminal_index);
        }
    }
    
    class Base {
        // ...
    }
    
    class Derived1 extends Base {
        // ...
    }
    
    class Derived2 extends Base {
        // ...
    }
    