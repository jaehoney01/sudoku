import java.util.Scanner;

import javax.swing.JButton;

public class Sudoku_1
{
    int[] mat[];
    int N; // 행 열
    int SRN; // 루트(N)
    int K;
    int [][] Enter_answer;
    boolean [][] Check_sudoku;
    int c,r,e;
    int count = 0;
    int sum=0;
    Scanner sc = new Scanner(System.in);
    // 생성자
    Sudoku_1(int N, int K)
    {
        this.N = N;
        this.K = K;
        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();
        
        Check_sudoku = new boolean[N][N];
        Enter_answer = new int[N][N];
        mat = new int[N][N];
    }
 
    // 스도쿠 생성기
    public void fillValues()
    {
        fillDiagonal();
        
        // 나머지 블록 채우기
        fillRemaining(0, SRN);
        
        // 답 옮기기
        fillCarry();
        
        // 게임 생성
        removeKDigits();
    }
    
    void fillDiagonal()
    {
 
        for (int i = 0; i<N; i=i+SRN)
            fillBox(i, i);
    }
    
    void fillCarry() {
    	for (int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		Enter_answer[i][j] = mat[i][j];
        	}
        }
    }
 
    // 3x3에 숫자 포함 시 false 반환
    boolean unUsedInBox(int rowStart, int colStart, int num)
    {
        for (int i = 0; i<SRN; i++)
            for (int j = 0; j<SRN; j++)
                if (mat[rowStart+i][colStart+j]==num)
                    return false;
 
        return true;
    }
 
    // 3x3 행렬 값 입력
    void fillBox(int row,int col)
    {
        int num;
        for (int i=0; i<SRN; i++)
        {
            for (int j=0; j<SRN; j++)
            {
                do
                {
                    num = randomGenerator(N);
                }
                while (!unUsedInBox(row, col, num));
 
                mat[row+i][col+j] = num;
            }
        }
        
        

    }
 
    // 랜덤 값 생성
    int randomGenerator(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }
 
    // 셀에 넣어도 되는지 확인
    boolean CheckIfSafe(int i,int j,int num)
    {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i-i%SRN, j-j%SRN, num));
    }
 
    // 열 값 존재 확인
    boolean unUsedInRow(int i,int num)
    {
        for (int j = 0; j<N; j++)
           if (mat[i][j] == num)
                return false;
        return true;
    }
 
    // 행 값 존재 확인
    boolean unUsedInCol(int j,int num)
    {
        for (int i = 0; i<N; i++)
            if (mat[i][j] == num)
                return false;
        return true;
    }
 
    // 나머지를 채울 재귀 함수
    boolean fillRemaining(int i, int j)
    {
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }
        if (i>=N && j>=N)
            return true;
 
        if (i < SRN)
        {
            if (j < SRN)
                j = SRN;
        }
        else if (i < N-SRN)
        {
            if (j==(int)(i/SRN)*SRN)
                j =  j + SRN;
        }
        else
        {
            if (j == N-SRN)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }
        
        
        for (int num = 1; num<=N; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                mat[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;
 
                mat[i][j] = 0;
            }
        }
        
                return false;
    }
 
    
    // 게임 메소드
    public void removeKDigits()
    {
        int count = K;
        while (count != 0)
        {
            int cellId = randomGenerator(N*N)-1;
 
            int i = (cellId/N);
            int j = cellId%9;
            if (j != 0)
                j = j - 1;
 
            if (mat[i][j] != 0)
            {
                count--;
                Enter_answer[i][j] = 0;
            }
        }
    }
 	public int[][] pirntSudoku(){
 		for (int i = 0; i<N; i++)
        {
            for (int j = 0; j<N; j++){
                System.out.print(mat[i][j] + " ");
                if(j == 2 || j == 5){
                    System.out.print("| ");
                }
            }
            if(i == 2 || i == 5){
                System.out.print("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-------");
            }
            System.out.println();
        }
        System.out.println();
        return mat;
 	}
    // 스도쿠 출력
    public int[][] quiz_printSudoku()
    {                
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j<N; j++){
                System.out.print(Enter_answer[i][j] + " ");
                //jb[i][j] = new JButton(""+Enter_answer[i][j]);
                if(j == 2 || j == 5){
                    System.out.print("| ");
                }
            }
            if(i == 2 || i == 5){
                System.out.print("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-------");
            }
            System.out.println();
        }
        System.out.println();
        return Enter_answer;
    }
    
    void Enter_sudoku() {
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(Enter_answer[i][j] != 0) {
    				Check_sudoku[i][j] = true;
    				sum+=1;
    			}
    		}
    	}
    	a:while(true) {
    		try {
    			r = sc.nextInt();
        		c = sc.nextInt();
        		e = sc.nextInt();
        		if(1>e || 9<e) {
        			System.out.println("정답은 1~9사이에 숫자만 입력할수 있습니다!!");
        			continue a;
        		}
        		
        		if(Check_sudoku[c][r] == false) {
        			Enter_answer[c][r] = e;
            		Check_sudoku[c][r] = true;
            		sum+=1;
        		}
        		
        		else {
        			System.out.println("숫자가 이미 들어가 있습니다!!");
        			continue a;
        		}
        		
        		if(Enter_answer[c][r] == mat[c][r]) {
        			System.out.println("정답입니다!!");
        		}
        		else {
        			System.out.println("틀렸습니다!!");
        			Enter_answer[c][r] = 0;
        			Check_sudoku[c][r] = false;
        			sum-=1;
        			count+=1;
        			
        		}
    		}
    		
    		catch(Exception e) {
    			System.out.println("좌표는 0~8사이에 숫자만 입력가능합니다");
    			continue a;
    		}
    		for (int i = 0; i<N; i++)
            {
                for (int j = 0; j<N; j++){
                    System.out.print(Enter_answer[i][j] + " ");
                    
                    if(j == 2 || j == 5){
                        System.out.print("| ");
                    }
                }
                if(i == 2 || i == 5){
                    System.out.print("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-------");
                }
                System.out.println();
            }
            System.out.println();
            
            if(sum==N*N) {
            	System.out.println("틀린 횟수는 : " + count + "입니다!");
            	break a;
            }
    	}
    	
    }
    // 메인
//    public static void main(String[] args)
//    {
//        int N = 9, K = 20;
//        Sudoku sudoku = new Sudoku(N, K);
//        sudoku.fillValues();
//        sudoku.printSudoku();
//        sudoku.Enter_sudoku();
//    }
}