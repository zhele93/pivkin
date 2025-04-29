/*
   Упражнение 4.1.
   Преобразование справочной системы из упражнения 3.3 в класс Help.
*/

// Класс для инкапсуляции справочной системы
class Help {
    void helpOn(int what) {
        switch (what) {
            case '1':
                System.out.println("Оператор if:\n");
                System.out.println("if(условие) оператор;");
                System.out.println("else оператор;");
                break;
            case '2':
                System.out.println("Традиционный оператор switch:\n");
                System.out.println("switch(выражение) {");
                System.out.println("  case константа:");
                System.out.println("    последовательность операторов");
                System.out.println("    break;");
                System.out.println("  // ...");
                System.out.println("}");
                break;
            case '3':
                System.out.println("Цикл for:\n");
                System.out.print("for(инициализация; условие; итерация)");
                System.out.println(" оператор;");
                break;
            case '4':
                System.out.println("Цикл while:\n");
                System.out.println("while(условие) оператор;");
                break;
            case '5':
                System.out.println("Цикл do-while:\n");
                System.out.println("do {");
                System.out.println("  оператор;");
                System.out.println("} while (условие);");
                break;
            case '6':
                System.out.println("Оператор break:\n");
                System.out.println("break; или break метка;");
                break;
            case '7':
                System.out.println("Оператор continue:\n");
                System.out.println("continue; или continue метка;");
                break;
            // default можно не добавлять, т.к. isValid() проверяет ввод
        }
        System.out.println();
    }

    void showMenu() {
        System.out.println("Справка по:");
        System.out.println("  1. if");
        System.out.println("  2. switch");
        System.out.println("  3. for");
        System.out.println("  4. while");
        System.out.println("  5. do-while");
        System.out.println("  6. break");
        System.out.println("  7. continue\n");
        System.out.print("Выберите вариант (или q для завершения): ");
    }

    boolean isValid(int ch) {
        // Проверяем, входит ли ch в диапазон '1'-'7' или равно 'q'
        if ((ch >= '1' & ch <= '7') | ch == 'q')
            return true;
        else
            return false;
    }
}

// Класс для демонстрации работы Help
class HelpClassDemo {
    public static void main(String[] args)
            throws java.io.IOException {

        char choice, ignore;
        Help hlpobj = new Help(); // Создаем объект класса Help

        for (;;) {
            do {
                hlpobj.showMenu(); // Показываем меню

                choice = (char) System.in.read();

                // Отбрасываем лишние символы
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');

            } while (!hlpobj.isValid(choice)); // Повторяем, пока ввод не станет допустимым

            if (choice == 'q')
                break; // Выход из цикла, если выбрано 'q'

            System.out.println("\n");

            hlpobj.helpOn(choice); // Показываем справку для выбранного пункта
        }
    }
}