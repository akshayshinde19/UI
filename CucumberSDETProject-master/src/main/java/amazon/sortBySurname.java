package amazon;

public class sortBySurname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr= {"Shweta A", "Sachin E", "Akshay C"};		
		
		
		String[] lastName=new String[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			String[] temp= new String[2];			
			temp=arr[i].split(" ");
			lastName[i]=temp[1];
		}
		
		for(int i=0;i<lastName.length-1;i++) {
			//System.out.println(lastName[i]);	
			for(int j=i+1;j<lastName.length;j++) {
				if(lastName[i].compareToIgnoreCase(lastName[j])>0) {
					String temp = arr[i];  
					arr[i] = arr[j];  
					arr[j] = temp;  
				}				
			}
		}
		
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);			
			
		}

	}

}
