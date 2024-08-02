package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	private int insertionSortCounter = 0;
	private int mergeSortCounter = 0;
	private boolean haveMergeSort = true;

	public int getQntMergeSort()
	{
		return MERGESORT_APPLICATIONS;
	}
	public int getQntInsertionSort()
	{
		return INSERTIONSORT_APPLICATIONS;
	}

	public void sort(T[] array, int leftIndex, int rightIndex) 
	{
		insertionSortCounter = 0;
		mergeSortCounter = 0;

		if (array.length <= 4)
		{
			InsertionSort(array, leftIndex, rightIndex);
		}
		else{
			if (haveMergeSort)
			{
				MERGESORT_APPLICATIONS += (array.length) - array.length -1;
			}
			if (leftIndex >= rightIndex)
			{
			}
			else
			{
				mergeSort(array, leftIndex, rightIndex);
			}
		}
		INSERTIONSORT_APPLICATIONS += insertionSortCounter;
	}
	public void InsertionSort(T[] array, int leftIndex, int rightIndex)
	{
		insertionSortCounter++;
		for (int i = leftIndex + 1; i <= rightIndex; i++)
		{
			for (int j = i; j > leftIndex; j--)
			{
				if (array[j].compareTo(array[j-1]) < 0)
				{
					Util.swap(array, j - 1, j);
				}
			}
		}
	}
	public void merge(T[] array, int leftIndex, int middle ,int rightIndex)
	{
		MERGESORT_APPLICATIONS++;
		T[] helperArray = (T[]) new Comparable[array.length];

		for(int i = leftIndex; i <= rightIndex; i++)
		{
			helperArray[i] = array[i];
		}

		int fistHalfIndex = leftIndex;
		int secoundHalfIndex = middle + 1;
		int indexOrdArray = leftIndex;
		

		while(fistHalfIndex <= middle && secoundHalfIndex <= rightIndex)
		{
			if (helperArray[fistHalfIndex].compareTo(helperArray[secoundHalfIndex]) > 0)
			{
				array[indexOrdArray] = helperArray[fistHalfIndex];
				fistHalfIndex++;
			}
			else
			{
				array[indexOrdArray] = helperArray[secoundHalfIndex];
				secoundHalfIndex++;
			}
			indexOrdArray++;
		}

		while (fistHalfIndex <= middle)
		{
			array[indexOrdArray] = helperArray[fistHalfIndex];
			fistHalfIndex++;
			indexOrdArray++;
		}

		
	}
	public void mergeSort(T[] array, int leftIndex, int rightIndex)
	{
		int middle = (rightIndex + leftIndex)/2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);
		merge(array, leftIndex, middle, rightIndex);

	}
}
