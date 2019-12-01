import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
		System.out.println("Done");
    }
	
	//quick sort
	public void sort(){
		quickSort(0, lst.size()-1);
	}
	
	
	private void quickSort(int leftbound, int rightbound){
		//implement quickSort algorithm
		if(lst.isEmpty()) {
			System.out.println("Invalid operation");
		}
		else 
		{
			for(int i = 0; i < lst.size(); i++) 
			{
				if(leftbound >= rightbound) 
				{
					return;
				}
				int pivotIndex = rightbound;
				int j = leftbound;
				int k = rightbound - 1;
				Keyword pivot = lst.get(rightbound);
				Keyword jKeyword = lst.get(j);
				Keyword kKeyword = lst.get(k);
				
				while(j < k || jKeyword.count <= pivot.count) 
				{
					j++;
					if( j>=k || jKeyword.count > pivot.count) {
						break;
						
					}
				}
				while(j < k || kKeyword.count > pivot.count) 
				{
					k--;
					if(j >= k || kKeyword.count < pivot.count) {
						break;
					}
				}	
				if(jKeyword.count > kKeyword.count)
				{
					swap(j, k);
					swap(pivotIndex, j);
				}
				if(jKeyword.count > pivot.count) {
					swap(j, pivotIndex);
				}
							
				
				quickSort(leftbound, j - 1);
				quickSort(j + 1, rightbound);
			}
		}
	}
	
	
	private void swap(int aIndex, int bIndex){
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		if(lst.isEmpty()) 
		{
			System.out.println("Invalid operation");
		}
		else 
		{
			for(int i=0; i<lst.size();i++)
			{
				Keyword k = lst.get(i);
				if(i>0)sb.append(" ");
				sb.append(k.toString());
			}
			
			System.out.println(sb.toString());		
		}
		
	}
}