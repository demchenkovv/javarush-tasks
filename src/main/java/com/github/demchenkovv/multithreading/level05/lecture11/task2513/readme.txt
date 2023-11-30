Если вы хотите сделать, чтобы проверка действительно выполнялась после каждой транзакции, необходимо сделать следующее:

1. В методе moveMoney после вызова setBalance (и после первого, и после второго) вставьте:
try {
     Solution.class.wait();
     } catch (InterruptedException e) {
     e.printStackTrace();
     }

2. В методе main в анонимном классе controlThread обернем код synchronized блоком и добавим notify();
synchronized (Solution.class) {
    accounts.stream().filter(a -> a.balanceChanged).forEach(Account::checkBalance);
    Solution.class.notify
  }

Комментарии к коду: yield() нам не помогает, так как это «рекомендация планировщику о том, что текущий поток готов предоставить текущее использование процессора. Планировщик волен игнорировать эту подсказку» (источник: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html#yield()).
Для четкого вывода потребуются методы wait() и notify().
Метод wait() - заставляет текущий поток ждать, пока он не будет пробужден, обычно путем получения уведомления (notified) или прерывания (interrupted).
Метод notify() - пробуждает один поток, который ожидает на мониторе этого объекта.
Solution.class.wait() позволяет потоку уйти в waitSet в состояние WAITING. Выйти из WAITING можно путем вызова метода notify() (это делает как раз наш проверяльщик).
Так как moveMoney у нас static synchronized, то монитор этого метода - класс Solution, а не экземпляр.
Также можно сделать через статический метод sleep() класса Thread, но тогда вам сидеть и ждать + опять никаких гарантий (хотя при достаточно большом времени в sleep`e работает как надо).
