package com.example.functional;

import java.io.FileWriter;
import java.io.IOException;

//example of 'execute around method' pattern
public class LambdaFileWriterExecuteAroundMethodExample {
	
	//could use the Consumer interface here, but the idea is to indicate that the operation
	//could throw an exception, so a custom one was defined for those purposes
	@FunctionalInterface
	public interface UseInstance<T, X extends Throwable> {
		void accept(final T instance) throws X;
	}
	
	private final FileWriter writer;
	
	private LambdaFileWriterExecuteAroundMethodExample(final String fileName) throws IOException {
		writer = new FileWriter(fileName);
	}
	
	private void close() throws IOException {
		writer.close();
	}
	public void writeStuff(final String message) throws IOException {
		writer.write(message);
	}
	
	//use: FileWriterEAM.use("text.txt", writerEAM -> writerEAM.writeStuff("sweet"));
	public static void use(final String fileName, 
			final UseInstance<LambdaFileWriterExecuteAroundMethodExample, IOException> block) throws IOException {
		final LambdaFileWriterExecuteAroundMethodExample writerEAM = new LambdaFileWriterExecuteAroundMethodExample(fileName);
		try {
			block.accept(writerEAM);
		} finally {
			writerEAM.close();
		}
	}
}


