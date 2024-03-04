package org.example;


public class Main {
    public static void main(String[] args) {

        TheBolshevichkaFactory theBolshevichkaFactory = getSuitByName("Man");
        Suit suit = theBolshevichkaFactory.createSuit();
        suit.showSuit();
    }

    // Фабричный метод
    public static TheBolshevichkaFactory getSuitByName(String maker) {
        if (maker.equals("Man")) {

            return new ClothingLineForMen();
        } else if (maker.equals("Woman")) {

            return new ClothingLineForWomen();
        }

        return null;
    }

}

// Интерфейс костюмов
interface Suit {
    void showSuit();
}

// Костюм для мужчин
class SuitForMan implements Suit {

    @Override
    public void showSuit() {
        System.out.println("Костюм для мужчин");
    }
}

// Костюм для женщин
class SuitForWomen implements Suit {

    @Override
    public void showSuit() {
        System.out.println("Костюм для женщин");
    }
}

// Фабрика Большевичка
interface TheBolshevichkaFactory {
    Suit createSuit();
}

// Линия по производству мужской одежды
class ClothingLineForMen implements TheBolshevichkaFactory {

    // Фабричный метод
    @Override
    public Suit createSuit() {
        return new SuitForMan();
    }

}

// Линия по производству женской одежды
class ClothingLineForWomen implements TheBolshevichkaFactory {

    // Фабричный метод
    @Override
    public Suit createSuit() {
        return new SuitForWomen();
    }
}