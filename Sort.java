
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: ?                            ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Size of array **/
	private int size;

	/** Number of used elements in array **/
	private int usedSize;

	/** Array of integers **/
	private int[] A;

	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNS;

	/** Global comparison count for newsort **/

	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialiase global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/

			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);

			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}

	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	/** Insertion Sort method **/
	public void insertion() {
		for (int i = 1; i < A.length; i++) {
			int v = A[i];
			int j = i - 1;
			compIS++;

			while (j >= 0 && A[j] > v) {
				compIS++;
				A[j + 1] = A[j];
				j--;
				A[j + 1] = v;
			}

		}
	}

	

	/** Quick sort method **/
	public void quicksort(int L, int R) {
		int p;
		if (R > L) {
			p = partition(A, L, R);
			quicksort(L, p - 1);
			quicksort(p + 1, R);

		}

	}
	/** Partition method **/
	public int partition(int[] A, int L, int R) {
		int p = A[R];
		int i = L;
		int j = R;
		while (i < j) {
			compQS++;
			while (A[i] < p) {
				compQS++;
				i++;
			}
			compQS++;
			while (A[j] >= p && j > L) {
				compQS++;
				j--;
			}
			if (i < j) {
				swap(A, i, j);
			}
		}
		swap(A, i, R);

		return i;
	}
	/** swap method **/
	private void swap(int[] A, int i, int j) {
		int temp;
		temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}
	/** New Sort Algorithm **/
	public void newsort() {
		int position = 0; // position counter
		int min;
		while (position < A.length) {
			min = findMinFrom(A, position);
			for (int i = position; i < A.length; i++) {
				
				if (A[i] == min) {
					swap(A, i, position);
					position++;
				}
				compNS++;
			}
		}
	}

	private int findMinFrom(int[] A, int position) {//finds if there is a smaller number after the given index
		int min = A[position];
		for (int i = position + 1; i < A.length; i++) {
			
			if (A[i] < min) {
				min = A[i];
			}
			compNS++;
		}
		return min;

	}

} /** End of Sort Class **/
