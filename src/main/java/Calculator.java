import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* Этот класс выполняет обработку входных данных после заказа. Расчитывает стоимость на каждого
    человека и выводит данные на консоль
     */

    private final int numberOfVisitors;
    private final List<Product> listOfProducts;

    public Calculator(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
        this.listOfProducts = new ArrayList<>();
    }

    public List<Product> getListOfProducts() {
        return this.listOfProducts;
    }

    public int getNumberOfVisitors() {
        return this.numberOfVisitors;
    }

    // Добавляет объект класса Product в listOfProducts
    public void addProductToList(Product product) {
        listOfProducts.add(product);
    }

    @Override
    public String toString() {
        return "Количество посетителей: " + this.numberOfVisitors + "\n" +
        "Список продуктов: " + this.listOfProducts;
    }

    // Расчитывает стоимость по счету на каждого посетителя
    private double calculate() {
        double totalValue = 0;
        for (Product product:listOfProducts) {
            totalValue += product.getValue();
        }
        return totalValue / this.numberOfVisitors;
    }

    // Возвращает слово "Рубль" с правильным окончанием в зависимости от значения
    private String getRightWord(double value) {
        String[] vars = {"рубль", "рубля", "рублей"};
        int valueToInt = (int) value;
        if ((valueToInt / 10) % 10 == 1) {
            return vars[2];
        } else {
            switch (valueToInt % 10) {
                case 1:
                    return vars[0];
                case 2:
                case 3:
                case 4:
                    return vars[1];
                default:
                    return vars[2];
            }
        }
    }

    // Выводит итоговые результаты
    public void printResults() {
        System.out.println("Добавленные товары:");
        for (Product product:listOfProducts) {
            System.out.println(product.getName() + " " + String.format("%.2f", product.getValue()) +
                    " " + getRightWord(product.getValue()));
        }

        double valuePerPerson = this.calculate();

        System.out.println("Итого:");
        System.out.println("Колличество персон: " + this.getNumberOfVisitors());
        System.out.println("Стоимость по чеку на каждую персону составляет по: "
                + String.format("%.2f", valuePerPerson) + " " + getRightWord(valuePerPerson));
    }
}
