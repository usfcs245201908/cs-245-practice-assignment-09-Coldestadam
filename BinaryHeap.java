public class BinaryHeap{
	private int[] data;
	private int size;

	public BinaryHeap(){
		data = new int[10];
		size=0;
	}

	public void grow_array(){
		int[] new_arr = new int[data.length*2];
		for(int i=0; i<data.length; i++)
			new_arr[i] = data[i];
		data = new_arr;
	}

	public void add(int item){
		if(size==data.length)
			grow_array();
		data[size++]=item;
		int child = size-1;
		int parent = (child-1)/2;
		while(parent>=0 && data[parent] > data[child]){
			swap(data, parent, child);
			child = parent;
			parent = (child-1)/2;
		}
	}

	public void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	public int remove(){
		if(size==0)
			return -1;
		int removed = data[0];
		data[0] = data[--size];
		siftdown(0);
		return removed;
	}

	public void siftdown(int pos){
		int child = 2*pos+1;
		if(child >= size)
			return;

		if(child+1<size && data[child]>data[child+1])
			++child;

		if(data[pos] > data[child]){
			swap(data, pos, child);
			siftdown(child);
		}
	}
}