package Labs.Lab10;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bank
{
    private Account[] accounts;
    public Bank(int numOfAccounts, int maxInitialSum)
    {
        Random rand = new Random();
        accounts = new Account[numOfAccounts];
        for (int i = 0; i < numOfAccounts; i++) {
            accounts[i] = new Account();
            accounts[i].add(rand.nextInt(maxInitialSum));
        }
    }

    public Account[] getAccounts() {
        return accounts;
    }

    //thread-safe
    public boolean transfer(Account to, Account from, int amount)
    {
        if(from.withdraw(amount))
        {
            to.add(amount);
            return true;
        }
        return false;
    }
    //thread-safe
    public boolean transfer(int to, int from, int amount)
    {
        if(accounts[from].withdraw(amount))
        {
            accounts[to].add(amount);
            return true;
        }
        return false;
    }
    public int getFullBalance()
    {
        return Arrays.stream(accounts).mapToInt(Account::getBalance).sum();
    }
}
