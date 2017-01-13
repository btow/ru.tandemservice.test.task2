import java.io.IOException;
import java.util.List;
import java.util.Stack;

/**
 * <h1>Задание №2</h1>
 * Реализуйте интерфейс {@link IElementNumberAssigner}.
 * <p>
 * <p>Помимо качества кода, мы будем обращать внимание на оптимальность предложенного алгоритма по времени работы
 * с учетом скорости выполнения операции присвоения номера:
 * большим плюсом (хотя это и не обязательно) будет оценка числа операций, доказательство оптимальности
 * или указание области, в которой алгоритм будет оптимальным.</p>
 */
public class Task2Impl implements IElementNumberAssigner {

    // ваша реализация должна работать, как singleton. даже при использовании из нескольких потоков.
    public static final IElementNumberAssigner INSTANCE = new Task2Impl();

    @Override
    public void assignNumbers(final List<IElement> elements) {
        /** напишите здесь свою реализацию. Мы ждем от вас хорошо структурированного,
         *  документированного и понятного кода, работающего за разумное время.
         */

        synchronized (Task2Impl.class) {
            int elementsSize = elements.size(),
                 lookupValue = elementsSize;

            // количество итераций цикла O(n)
            for (int elementsInsex = 0; elementsInsex < elementsSize; elementsInsex++) {
                IElement element = elements.get(elementsInsex);
                int elementsNumber = element.getNumber();

                try {

                    boolean firstIteration = true;

                    /** количество итераций цикла:
                     * в лучшем случае O(1);
                     * в худшем случае O(n-1).
                     */
                    while (elementsNumber != elementsInsex) {

                        if (firstIteration) {
                            element.setupNumber(lookupValue);
                            firstIteration = false;
                        } else {
                            element = elements.get(elementsNumber);
                            lookupValue = element.getNumber();
                            element.setupNumber(elementsNumber);
                            elementsNumber = lookupValue;
                        }
                    }

                    if (!firstIteration) {
                        element = elements.get(elementsInsex);
                        element.setupNumber(elementsInsex);
                        lookupValue = elementsSize;
                    }

                } catch (Error e) {
                    e = new Error("Перенумерация цепочки с элемента номер " + elementsInsex + " не удалась!");
                }

            }

        }

    }

}