// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.4/5 page 722
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatching {

	private static Scanner inOldMaster;
	private static Scanner inTransaction;
	private static Formatter outNewMaster;
	private static Formatter outLogFile;

	public static void main(String[] args) {

		openFiles();
		compareFiles();
		closeFiles();
	}

	private static void compareFiles() {
		
		// Populate newmast.txt with data comparing old data with new transactions
		while(inOldMaster.hasNext()){
			Account account = new Account(inOldMaster.nextInt(), inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
			
			// Open transaction file for this loop iteration
			try {
				inTransaction = new Scanner(Paths.get("trans.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			while(inTransaction.hasNext()){
				TransactionRecord record = new TransactionRecord();
				record.setAccountNumber(inTransaction.nextInt());
				record.setAmount(inTransaction.nextDouble());
				if (account.getAccount() == record.getAccountNumber()){
					account.combine(record);
				}
			}
			outNewMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(), account.getBalance());
			
			// Close transaction file before next loop iteration
			inTransaction.close();
		}
		
		// Populate log.txt with data looking for transactions with unknown account number
		try {
			inTransaction = new Scanner(Paths.get("trans.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (inTransaction.hasNext()){
			TransactionRecord record = new TransactionRecord();
			record.setAccountNumber(inTransaction.nextInt());
			record.setAmount(inTransaction.nextDouble());
			
			// Open account file for this loop iteration
			try {
				inOldMaster = new Scanner(Paths.get("oldmast.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			boolean knownAccount = false;
			while (inOldMaster.hasNext()){
				Account account = new Account(inOldMaster.nextInt(), inOldMaster.next(), inOldMaster.next(), inOldMaster.nextDouble());
				if (account.getAccount() == record.getAccountNumber()){
					knownAccount = true;
				}
			}
			if (!knownAccount){
				outLogFile.format("%s%d%n", "Unmatched transaction record for account number: ", record.getAccountNumber());
			}
		}
	}

	private static void closeFiles() {

		inTransaction.close();
		outNewMaster.close();
		outLogFile.close();
	}

	private static void openFiles() {

		try {
			inOldMaster = new Scanner(Paths.get("oldmast.txt"));
			outNewMaster = new Formatter("newmast.txt");
			outLogFile = new Formatter("log.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
