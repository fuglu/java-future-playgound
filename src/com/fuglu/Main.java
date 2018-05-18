package com.fuglu;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws ExecutionException, InterruptedException {


		CompletableFuture<String> completableFuture = future("foo").thenCompose(foo -> future(foo + "bar"));
		System.out.println(completableFuture.get());
	}

	private static CompletableFuture<String> future(String result) {
		return CompletableFuture.supplyAsync(() -> {
			sleep(1);

			return result;
		});
	}

	private static void sleep(int timeout) {
		System.out.println("Sleep " + timeout);
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
		}
	}
}
