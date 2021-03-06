package com.demo.mood.springboot.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public interface OrderService {
    void createOrder();

    void sendEmail();

    void cancelOrder() throws ExecutionException, InterruptedException;

    Future<String> doCancelTask1();

    Future<String> doCancelTask2();

    Future<String> doCancelTask3();

    void deleteOrder() throws ExecutionException, InterruptedException;

    CompletableFuture<String> doDeleteTask1();

    CompletableFuture<String> doDeleteTask2();

    CompletableFuture<String> doDeleteTask3();
}
