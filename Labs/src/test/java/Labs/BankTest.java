package Labs;

import Labs.Lab10.Bank;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class BankTest
{
    private class RandomTransfersThread extends Thread
    {
        private Bank bank;
        private int numOfAccounts;
        public RandomTransfersThread(Bank bank)
        {
            this.bank = bank;
            this.numOfAccounts = bank.getAccounts().length;
            this.start();
        }
        @Override
        public void run()
        {
            Random rand = new Random();
            for (int i = 0; i < 1000000; i++) {
                bank.transfer(rand.nextInt(numOfAccounts),rand.nextInt(numOfAccounts), rand.nextInt(1000));
            }
        }
    }
    @Test
    public void test() throws InterruptedException
    {
        Bank bank = new Bank(100000, 100000);
        final int fullBalance = bank.getFullBalance();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new RandomTransfersThread(bank);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        Assert.assertEquals(fullBalance, bank.getFullBalance());
    }
}
