package com.ilya.coding;

import java.io.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** Problem:
// It's tax season! Given a set of transactions, find out the cost basis for each sell transaction and compute the overall capital gain/loss. The cost basis for a sold equity is the price at which the equity being sold was bought at. The transactions are processed in FIFO order.
// You are provided with a sorted list of tuples, each of which represent a transaction. These tuples are formatted as follows:
// symbol: string
// side: string (buy/sell)
// quantity: int
// price: float

// For each sell, output the following information:
// symbol: string,
// quantity: int
// capital_gain: float
// input

// transactions = [
//     {'symbol': 'FB', 'side': 'buy', 'quantity': 1, 'price': 200.00},
//     {'symbol': 'AAPL', 'side': 'buy', 'quantity': 2, 'price': 100.00},
//     {'symbol': 'FB', 'side': 'sell', 'quantity': 1, 'price': 150.00},
//     {'symbol': 'AAPL', 'side': 'buy', 'quantity': 1, 'price': 150.00},
//     {'symbol': 'AAPL', 'side': 'sell', 'quantity': 1, 'price': 200.00},
//     {'symbol': 'AAPL', 'side': 'buy', 'quantity': 4, 'price': 210.00},
//     {'symbol': 'AAPL', 'side': 'sell', 'quantity': 4, 'price': 220.00},
// ]

// output
// [
//   {'symbol': 'FB', 'quantity': 1, 'capital_gain': -50.00},
//   {'symbol': 'AAPL', 'quantity': 1, 'capital_gain': 100.00},
//   {'symbol': 'AAPL', 'quantity': 1, 'capital_gain': 120.00},
//   {'symbol': 'AAPL', 'quantity': 1, 'capital_gain': 70.00},
//   {'symbol': 'AAPL', 'quantity': 2, 'capital_gain': 20},
// ]

// Input: Queue<Transaction> to process
// Output: List<CapitalGain> to output
// Constraints: chronological order of transactions, no sell before buy
// Options: Store buy transactions in Map< String(symbol), Queue<Transaction>> >,
//          For each sell, lookup symbol, get top transaction, decrement quantity as needed
//          or remove transaction if needed, and move to next one.
//          Add CapitalGain object for each expired transaction and calculate gain/loss
//          given price of purchase and sell.
//          Time: O(n) Space: O(n)
 */


// Main class should be named 'Solution'

public class TransactionsTaxGainLoss {

    public List<CapitalGain> processTransactions(Queue<Transaction> transactions) {
        // error checking
        if (transactions == null && transactions.isEmpty()) {
            return null;
        }

        // init vars
        List<CapitalGain> res = new ArrayList<>();
        Map<String, Queue<Transaction>> transMap = new HashMap<>();

        // process transactions
        while (!transactions.isEmpty()) {
            Transaction trans = transactions.poll();
            // buy transaction
            if (trans.isBuy()) {
                Queue<Transaction> q = transMap.get(trans.symbol);
                if (q == null) {
                    q = new LinkedList();
                    transMap.put(trans.symbol, q);
                }
                q.add(trans);
            } else {
                // sell transaction
                Queue<Transaction> q = transMap.get(trans.symbol);
                int sellQuantity = trans.quantity;
                while (sellQuantity > 0) {
                    if (!q.isEmpty()) {
                        Transaction buyTrans = q.peek();
                        if (buyTrans.quantity >= sellQuantity) {
                            // gen gain/loss
                            CapitalGain capGain = new CapitalGain();
                            capGain.symbol = trans.symbol;
                            capGain.quantity = sellQuantity;
                            buyTrans.quantity -= sellQuantity;
                            capGain.capitalGain = capGain.quantity * (trans.price - buyTrans.price);
                            res.add(capGain);
                            sellQuantity = 0;
                        } else {
                            // gen gain/loss
                            CapitalGain capGain = new CapitalGain();
                            capGain.symbol = trans.symbol;
                            capGain.quantity = buyTrans.quantity;
                            capGain.capitalGain = capGain.quantity * (trans.price - buyTrans.price);
                            res.add(capGain);
                            sellQuantity -= buyTrans.quantity;
                            // done with buy transaction - poll and remove it
                            q.poll();
                        }
                    }
                }
            }
        }

        return res;
    }


    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Transaction> transactionList =
                objectMapper.readValue(new File("modules/main/src/main/resources/transactions.json"),
                        new TypeReference<List<Transaction>>(){});
        Queue<Transaction> q = new LinkedList<>();
        for (Transaction t : transactionList) {
            q.add(t);
        }
        List<CapitalGain> capitalGainList = new TransactionsTaxGainLoss().processTransactions(q);
        ObjectMapper objectMapperOut = new ObjectMapper();
        objectMapperOut.writeValue(new File("modules/main/src/main/resources/transactions-out.json"),
                capitalGainList);
    }
}

class Transaction {
    protected String symbol;
    protected String side;
    protected boolean isBuy;
    protected int quantity;
    protected double price;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public boolean isBuy() {
        return side.equalsIgnoreCase("buy");
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class CapitalGain {
    protected String symbol;
    protected int quantity;
    protected double capitalGain;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCapitalGain() {
        return capitalGain;
    }

    public void setCapitalGain(double capitalGain) {
        this.capitalGain = capitalGain;
    }
}