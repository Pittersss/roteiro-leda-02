package sorting.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorOrdemDescrescente;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
			vetorOrdemDescrescente = new Integer[]{10,9,8,7,6,5,4,3,2,1};
		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = null;
		
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void MergeSortArrayTamPar() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(vetorTamImpar, arrayOrdenado);
	}

	@Test
	public void MergeSortArrayTamImpar() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorTamPar.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorTamPar, 0, vetorTamPar.length - 1);
		assertArrayEquals(vetorTamPar, arrayOrdenado);
	}

	@Test
	public void MergeSortArrayRepetido() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorValoresRepetidos.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1);
		assertArrayEquals(vetorValoresRepetidos, arrayOrdenado);
	}

	@Test
	public void MergeSortArrayIgual() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorValoresIguais.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
		assertArrayEquals(vetorValoresIguais, arrayOrdenado);
	}

	@Test
	public void MergeSortArrayVazio() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorVazio.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorVazio, 0, vetorVazio.length - 1);
		assertArrayEquals(vetorVazio, arrayOrdenado);
	}

	@Test
	public void MergeSortArrayOrdDecrescente() {
		MergeSort<Integer> mergeSort = new MergeSort<Integer>();
		Integer[] arrayOrdenado = vetorOrdemDescrescente.clone();
		Arrays.sort(arrayOrdenado);
		mergeSort.sort(vetorOrdemDescrescente, 0, vetorOrdemDescrescente.length - 1);
		assertArrayEquals(vetorOrdemDescrescente, arrayOrdenado);
	}

	


	@Test
	public void QuickSortArrayTamPar() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(vetorTamImpar, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayRepetido() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorValoresRepetidos.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1);
		assertArrayEquals(vetorValoresRepetidos, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayIgual() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorValoresIguais.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
		assertArrayEquals(vetorValoresIguais, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayTamImpar() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(vetorTamImpar, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayVazio() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorVazio.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorVazio, 0, vetorVazio.length - 1);
		assertArrayEquals(vetorVazio, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayOrdDecrescente() 
	{
		QuickSort<Integer> quickSort = new QuickSort<Integer>();
		Integer[] arrayOrdenado = vetorOrdemDescrescente.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorOrdemDescrescente, 0, vetorOrdemDescrescente.length - 1);
		assertArrayEquals(vetorOrdemDescrescente, arrayOrdenado);

	}


	// Quick mediana
	@Test
	public void QuickSortMedianaArrayTamPar() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorTamPar.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorTamPar, 0, vetorTamPar.length - 1);
		assertArrayEquals(vetorTamPar, arrayOrdenado);

	}

	@Test
	public void QuickSortMedianaArrayRepetido() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorValoresRepetidos.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length - 1);
		assertArrayEquals(vetorValoresRepetidos, arrayOrdenado);

	}

	@Test
	public void QuickSortMedianaArrayIgual() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorValoresIguais.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorValoresIguais, 0, vetorValoresIguais.length - 1);
		assertArrayEquals(vetorValoresIguais, arrayOrdenado);

	}

	@Test
	public void QuickSortMedianaArrayTamImpar() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorTamImpar.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorTamImpar, 0, vetorTamImpar.length - 1);
		assertArrayEquals(vetorTamImpar, arrayOrdenado);

	}

	@Test
	public void QuickSortMedianaArrayVazio() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorVazio.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorVazio, 0, vetorVazio.length - 1);
		assertArrayEquals(vetorVazio, arrayOrdenado);

	}

	@Test
	public void QuickSortArrayMedianaOrdDecrescente() 
	{
		QuickSortMedianOfThree<Integer> quickSort = new QuickSortMedianOfThree<Integer>();
		Integer[] arrayOrdenado = vetorOrdemDescrescente.clone();
		Arrays.sort(arrayOrdenado);
		quickSort.sort(vetorOrdemDescrescente, 0, vetorOrdemDescrescente.length - 1);
		assertArrayEquals(vetorOrdemDescrescente, arrayOrdenado);

	}

	@Test
	public void HibridMergeSort() 
	{
		HybridMergeSort<Integer> hybridMergeSort = new HybridMergeSort<Integer>();
		Integer[] array1 = {1,2,3,4};
		Integer[] array2 = {3,4,5,6};

		hybridMergeSort.sort(array1, 0, 3);
		hybridMergeSort.sort(array2, 0, 3);

		assert hybridMergeSort.getQntInsertionSort() == 2;
	}



	//

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}