// Абстрактный суперкласс Game — верхний уровень иерархии
abstract class Game {
    private String title;   // Название игры
    private int rating;     // Рейтинг игры

    // Стандартный конструктор
    Game() {
        title = "none";     // По умолчанию название "неизвестно"
        rating = 0;            // Рейтинг 0
    }

    // Параметризированный конструктор
    Game(String t, int r) {
        title = t;             // Установка названия
        rating = r;            // Установка рейтинга
    }

    // Копирующий конструктор
    Game(Game ob) {
        title = ob.title;      // Копирование названия
        rating = ob.rating;    // Копирование рейтинга
    }

    // Метод доступа к названию
    String getTitle() {
        return title;
    }

    // Метод доступа к рейтингу
    int getRating() {
        return rating;
    }

    // Метод для показа общей информации
    void showInfo() {
        System.out.println("Название: " + title + ", Рейтинг: " + rating);
    }

    // Абстрактный метод, который реализуют подклассы
    abstract String genre(); // Возвращает жанр игры
}

// Подкласс RPG — средний уровень иерархии (тип RPG)
class RPG extends Game {
    private String difficulty; // Параметр RPG (уровень сложности)

    // Конструктор без параметров
    RPG() {
        super();                // Вызов конструктора суперкласса
        difficulty = "EASY";    // Уровень сложности по умолчанию
    }

    // Конструктор с параметрами
    RPG(String t, int r, String d) {
        super(t, r);            // Вызов конструктора суперкласса
        difficulty = d;         // Установка уровня сложности
    }

    // Копирующий конструктор
    RPG(RPG ob) {
        super(ob);              // Копирование параметров суперкласса
        difficulty = ob.difficulty; // Копирование сложности
    }

    // Метод доступа к уровню сложности
    String getDifficulty() {
        return difficulty;
    }

    // Метод для показа уровня сложности
    void showDifficulty() {
        System.out.println("Сложность: " + difficulty);
    }

    // Реализация абстрактного метода genre()
    String genre() {
        return "RPG";
    }
}

// Подкласс  — тип Roguelike
class Roguelike extends Game {
    private int levelCount;     // Количество уровней

    // Конструктор без параметров
    Roguelike() {
        super();                // Вызов конструктора суперкласса
        levelCount = 0;         // Уровни по умолчанию
    }

    // Конструктор с параметрами
    Roguelike(String t, int r, int l) {
        super(t, r);            // Вызов конструктора суперкласса
        levelCount = l;         // Установка количества уровней
    }

    // Копирующий конструктор
    Roguelike(Roguelike ob) {
        super(ob);              // Копирование параметров суперкласса
        levelCount = ob.levelCount; // Копирование уровня
    }

    // Метод доступа к количеству уровней
    int getLevelCount() {
        return levelCount;
    }

    // Метод для показа количества уровней
    void showLevels() {
        System.out.println("Количество уровней: " + levelCount);
    }

    // Реализация абстрактного метода genre()
    String genre() {
        return "Roguelike";
    }
}

// Главный класс для демонстрации иерархии
class AbsGame {
    public static void main(String[] args) {
        // Создание массива из 4 игр
        Game[] games = new Game[4];

        // Инициализация игр
        games[0] = new RPG("Lies of P", 85, "50/50");    
        games[1] = new Roguelike("Enter the Gungeon", 90, 50);           
        games[2] = new RPG("Dark Souls", 75, "HARD");           
        games[3] = new Roguelike("Darkest Dungeon", 88, 100);        

        // Перебор всех игр в массиве
        for (int i = 0; i < games.length; i++) {
            System.out.println("Жанр: " + games[i].genre());     // Показ жанра
            games[i].showInfo();                                 // Показ общей информации

            // Проверка типа и вывод специфичной информации
            if (games[i] instanceof RPG) {
                ((RPG)games[i]).showDifficulty();             // Для RPG: показать сложность
            } else if (games[i] instanceof Roguelike) {
                ((Roguelike)games[i]).showLevels();                 // Для Roguelike: показать уровни
            }

            System.out.println(); // Пустая строка между объектами
        }
    }
}
