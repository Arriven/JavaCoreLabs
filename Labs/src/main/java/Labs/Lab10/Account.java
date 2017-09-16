package Labs.Lab10;

import java.util.concurrent.atomic.AtomicInteger;

public class Account
{
    private AtomicInteger balance;
    public Account()
    {
        this.balance = new AtomicInteger(0);
    }
    //thread-safe
    public void add(int amount)
    {
        this.balance.addAndGet(amount);
    }
    //thread-safe
    public boolean withdraw(int amount)
    {
        synchronized (balance)
        {
            int i = balance.get();
            if(i>=amount)
            {
                balance.addAndGet(-amount);
                return true;
            }
        }
        return false;
    }
    //not thread-safe
    public int getBalance()
    {
        return balance.get();
    }
}
