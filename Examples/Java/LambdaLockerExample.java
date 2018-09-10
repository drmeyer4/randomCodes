package com.example.functional;

import java.util.concurrent.locks.Lock;

public class LambdaLockerExample {
	
	//use: runLocked(lock, () -> { /* code */ } );
	public static void runLocked(Lock lock, Runnable block) {
		lock.lock();
		try {
			block.run();
		} finally {
			lock.unlock();
		}
	}
}
