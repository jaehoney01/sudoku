import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sudoku_DB {
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/Sudoku?";
    Connection conn;
    String id = "root";
    String pw = "1234";
    PreparedStatement pstmt;
    ResultSet rs;
    String sql;

    public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,id,pw);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    public void closeDB() {
		try {
			pstmt.close();
			conn.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public boolean insertUserData(Sudoku sudoku){   // 회원가입
        connectDB();
        sql = "insert into member(ID, PW, name) values(?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sudoku.getID());
            pstmt.setString(2, sudoku.getPW());
            pstmt.setString(3, sudoku.getName());
            pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        } finally {
            closeDB();
        }
        return true;
    }

    public boolean insertUserRate(Sudoku sudoku){   // 플레이 하고난 뒤
        connectDB();
        sql = "insert into gameset(level, timer, rate, userID) values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sudoku.getLevel());
            pstmt.setString(2, sudoku.getTimer());
            pstmt.setFloat(3, sudoku.getRate());
            pstmt.setString(4, sudoku.getID());
            pstmt.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        } finally {
            closeDB();
        }
        return true;
    }

    public Sudoku roadUserRate(String Level){     // 랭킹보기
        connectDB();
        sql = "select * from gameset where level=?"; // 원하는 정보 볼 때 * 대신 값 넣기
        Sudoku s = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Level);
            rs = pstmt.executeQuery();
            rs.next();
            s = new Sudoku();
            s.setLevel(rs.getString("level"));
            s.setTimer(rs.getString("timer"));
            s.setRate(rs.getFloat("rate"));
            s.setName(rs.getString("name"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } finally {
            closeDB();
        }
        return s;
    }

    public static void main(String[] args) {
        
    }
}
