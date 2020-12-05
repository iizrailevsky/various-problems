package com.ilya.coding;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.*;

// Problem:
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
//          For each sell, lookpup symbol, get top transaction, decrement quanitiy as needed
//          or remove transaction if needed, and move to next one.
//          Add CapitalGain object for each expired transasction and calculate gain/loss
//          given price of purchase and sell.
//          Time: O(n) Space: O(n)


// Main class should be named 'Solution'

class TransactionsTaxGainLoss {

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
            if (trans.isBuy) {
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
                            capGain.quantity = buyTrans.quantity - sellQuantity;
                            capGain.capitalGain = trans.price - buyTrans.price;
                            res.add(capGain);
                            sellQuantity = 0;
                        } else {
                            // gen gain/loss
                            CapitalGain capGain = new CapitalGain();
                            capGain.symbol = trans.symbol;
                            capGain.quantity = buyTrans.quantity;
                            capGain.capitalGain = trans.price - buyTrans.price;
                            res.add(capGain);
                            sellQuantity -= buyTrans.quantity;
                        }
                    }
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println("Hello, World");
    }
}

class Transaction {
    protected String symbol;
    protected boolean isBuy;
    protected int quantity;
    protected double price;
}

class CapitalGain {
    protected String symbol;
    protected int quantity;
    protected double capitalGain;
}