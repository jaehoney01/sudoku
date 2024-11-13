public class Sudoku
{
    int[] mat[];
    int N; // 행 열
    int SRN; // N^2
    int K;
 
    // 생성자
    Sudoku(int N, int K)
    {
        this.N = N;
        this.K = K;

        Double SRNd = Math.sqrt(N);
        SRN = SRNd.intValue();
 
        mat = new int[N][N];
    }
 
    // 스도쿠 생성기
    public void fillValues()
    {
        fillDiagonal();
 
        // 나머지 블록 채우기
        fillRemaining(0, SRN);
 
        // 게임 생성
        // removeKDigits();
    }
 
    void fillDiagonal()
    {
 
        for (int i = 0; i<N; i=i+SRN)
            fillBox(i, i);
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
 
    // 행 값 존재 확인
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
 
    /* 
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
                mat[i][j] = 0;
            }
        }
    }
 */
    // 스도쿠 출력
    public void printSudoku()
    {
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j<N; j++){
                System.out.print(mat[i][j] + " ");
                if(j == 2 || j == 5){
                    System.out.print("| ");
                }
            }
            if(i == 2 || i == 5){
                System.out.print("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            }
            System.out.println();
        }
        System.out.println();
    }
 
    // 메인
    public static void main(String[] args)
    {
        int N = 9, K = 20;
        Sudoku sudoku = new Sudoku(N, K);
        sudoku.fillValues();
        sudoku.printSudoku();
    }
}