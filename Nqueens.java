import java.util.Scanner;


public class Nqueens {
	static int count, flag=0;
    static int N = 4;   // number of queens
	static int[][] board = new int[N][N];
	static String[][] solved=new String [N][N]; 
	static int[][] pos=new int[N][2];	// stores the position of the queens


	static void display(int a, int b){
		board[a][b]=1;
		solved[a][b]="Q  ";
		for (int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(solved[i][j]+"  ");
			}
		System.out.println("\n");
		}

	}
  
  static boolean valid(int row, int column, int N){
		
		if(count==0) return true; 		// count=0 means the number of queens entered
		else {
//			System.out.println("\n reached\n");
			for (int i=0;i<count;i++){
				if (row==pos[i][0] || column==pos[i][1]){
					flag=1;
					break;
				}
				else
					flag=0;
				int r1,r2,r3,r4,c1,c2,c3,c4;
				r1=r2=r3=r4=pos[i][0];
				c1=c2=c3=c4=pos[i][1];
				
				if (flag==1) break;
				while(r1<N && c1>=0){				// diagonal left down
//					System.out.println("Inside diagonal left down ");
					r1+=1; c1-=1;
					if (row==r1 && column==c1){
						flag=1;
						break;
					}
					else
						flag=0;
				}
				
				if (flag==1) break;
				while(r2<N && c2<N){				// diagonal right down
//					System.out.println("Inside diagonal right down ");
					r2+=1; c2+=1;
					if (row==r2 && column==c2){
						flag=1;
						break;
					}
					else
						flag=0;
					
				
				}
				
				if (flag==1) break;
				while(r3>=0 && c3>=0){				// diagonal left up
//					System.out.println("Inside diagonal left up ");
					r3-=1; c3-=1;
					if (row==r3 && column==c3){
						flag=1;
						break;
					}
					else
						flag=0;
				}
				
				if (flag==1) break;
				while(r4>=0 && c4<N){				// diagonal right up
//					System.out.println("Inside diagonal right up ");
					r4-=1; c4+=1;
					if (row==r4 && column==c4){
						flag=1;
						break;
					}
					else
						flag=0;
				}
		
			}
			if(flag==0)
				return true;
			else
				return false;
		}
  }
  
  public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
// 	System.out.println("For how many queens you want to play\n");
//	N=sc.nextInt();
	for (int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			System.out.print("*  ");
			solved[i][j]="*  ";
		}
		System.out.println("\n");
	}

	for (int i=0; i<N;i++){
		count=i;
		int num=i+1;
		System.out.println("Enter the position of Queen "+ num + " in row column format\n ");
		int row=sc.nextInt();
		int column=sc.nextInt();
		pos[i][0]=row-1;
		pos[i][1]=column-1;
		while(!valid(pos[i][0], pos[i][1], N)){
			System.out.println("Invalid position\nEnter a valid position\n");
			row=sc.nextInt();
		    column=sc.nextInt();
			pos[i][0]=row-1;
			pos[i][1]=column-1;
			}
		display(pos[i][0], pos[i][1]);
	}
	System.out.println("Successful...");
	return;
	}
}