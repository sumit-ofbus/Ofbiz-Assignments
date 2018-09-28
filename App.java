import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

//Printing sum of 10 natural numbers
class Sum implements Runnable{

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void run()
    {
        int sum = 0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<10; i++) {
            sum = sum + i;
        }
        LOGGER.info("Sum of first 10 numbers is-" + sum);
        Factorial factorial = new Factorial();
        factorial.show();
    }
}

class Factorial implements Runnable{

    public void run() {
        int num=5 , fact=1;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(num > 0)
        {
            fact=fact * num;
            num --;
        }
        LOGGER.info("factorial is " + fact);
        FinOutp finOutp = new FinOutp();
        finOutp.display();
    }
    public void show()
    {
        LOGGER.info("------ Ending Sum --------");
    }
}

class Fibonacci implements Runnable{

    public void run()
    {
        int a=0,b=1,c;
        LOGGER.info("Fibonacci series is:" +a +" "+b+" ");
        for(int i=0; i<5; i++)
        {
            c = a + b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
        FinOutp finOutp = new FinOutp();
        finOutp.show();
    }
}

class FinOutp implements Runnable{

    public void run()
    {
        LOGGER.info("----It ends here-----");
    }

    public void display()
    {
        LOGGER.info("------Ending Factorial----");
    }

    public void show()
    {
        LOGGER.info("-----Ending Fibonacci------");
    }
}

public class App {

    public static void main(String[] args) {

        //Executing First
        Thread m1 = new Thread(new Sum());
        m1.start();
        try {
            m1.join();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //Executing m2 & m3 Together
        Thread m2 = new Thread(new Factorial());
        m2.start();

        Thread m3 = new Thread(new Fibonacci());
        m3.start();

        try {
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            m3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Executing m4 in the end
        Thread m4 = new Thread(new FinOutp());

        m4.start();
    }
}
