package days04.board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import days04.board.domain.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDAOImpl implements BoardDAO{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public BoardDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public ArrayList<BoardDTO> select() throws SQLException {
		long seq;
		String title, writer, email;
		Date writedate;
		int readed;

		ArrayList<BoardDTO> list = null;

		String sql =
				"SELECT seq, title, writer, email, writedate, readed "
						+ "FROM tbl_cstvsBoard "
						+ "ORDER BY seq DESC";

		BoardDTO dto = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<BoardDTO>();
				do {
					seq = rs.getLong("seq");
					title = rs.getString("title");
					writer = rs.getString("writer");
					email = rs.getString("email");
					writedate = rs.getDate("writedate");
					readed = rs.getInt("readed");
					dto = new BoardDTO().builder()
							.seq(seq)
							.title(title)
							.writer(writer)
							.email(email)
							.writedate(writedate)
							.readed(readed)
							.build();
					list.add(dto);
				} while (rs.next());

			} // if

		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	   public int insert(BoardDTO dto) throws SQLException {
	      // writedate  default  sysdate
	      // readed     default  0
	      int rowCount = 0;
	      String sql = "INSERT INTO tbl_cstvsboard "
	               + " (seq, writer, pwd, email, title, tag, content ) "
	               + "VALUES "
	               + " (seq_tblcstvsboard.NEXTVAL, ?, ?, ?, ?, ?, ? ) ";
	      
	      this.pstmt = conn.prepareStatement(sql);      
	         pstmt.setString(1,  dto.getWriter() );
	         pstmt.setString(2,  dto.getPwd() );
	         pstmt.setString(3,  dto.getEmail() );
	         pstmt.setString(4,  dto.getTitle() );
	         pstmt.setInt(5, dto.getTag());
	         pstmt.setString(6,  dto.getContent() );
	      rowCount = this.pstmt.executeUpdate();
	      this.pstmt.close();
	      
	      return rowCount;
	   }

	@Override
	   public int increaseReaded(long seq) throws SQLException {
	      String sql = "UPDATE tbl_cstvsboard "
	            + " SET readed = readed + 1 "
	            + " WHERE seq = ? ";
	      int rowCount = 0;
	      this.pstmt = this.conn.prepareStatement(sql);
	      this.pstmt.setLong(1, seq);
	      rowCount = this.pstmt.executeUpdate();
	      return rowCount;
	   }

	   @Override
	   public BoardDTO view(long seq) throws SQLException {
	      String title, writer, email;
	      Date writedate;
	      int readed;
	      String content;

	      String sql = "SELECT seq, title, writer, email, writedate, readed, content "
	            + "FROM tbl_cstvsboard "
	            + "WHERE seq = ? ";

	      BoardDTO dto = null;

	      try {
	         pstmt = conn.prepareStatement(sql);
	         this.pstmt.setLong(1, seq);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	            seq = rs.getLong("seq");
	            title = rs.getString("title");
	            writer = rs.getString("writer");
	            email = rs.getString("email");
	            writedate = rs.getDate("writedate");
	            readed = rs.getInt("readed");
	            content = rs.getString("content");
	            dto = new BoardDTO().builder()
	                  .seq(seq)
	                  .title(title)
	                  .writer(writer)
	                  .email(email)
	                  .writedate(writedate)
	                  .readed(readed)
	                  .content(content)
	                  .build();
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return dto;
	   }

	   @Override
		public int update(BoardDTO dto) throws SQLException {
			
			String sql ="UPDATE tbl_cstvsboard"
						+ " SET title = ? , content = ?, email = ? , tag = ?"
						+ " WHERE seq = ? AND pwd = ?";
			int rowCount = 0 ;
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, dto.getTitle());
			this.pstmt.setString(2, dto.getContent());
			this.pstmt.setString(3, dto.getEmail());
			this.pstmt.setInt(4, dto.getTag());
			this.pstmt.setLong(5, dto.getSeq());
			this.pstmt.setString(6, dto.getPwd());
			
			rowCount = this.pstmt.executeUpdate();
			return rowCount;
		}

	@Override
	public String getOriginalPwd(long seq) throws SQLException {
		String originalPwd = null;

	      String sql = "SELECT pwd"
	            + " FROM tbl_cstvsboard"
	            + " WHERE seq = ? ";

	      try {
	         pstmt = conn.prepareStatement(sql);
	         this.pstmt.setLong(1, seq);
	         rs = pstmt.executeQuery();

	         if (rs.next()) {
	        	 originalPwd = rs.getString("pwd");
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return originalPwd;
	}
	
	@Override
	public int delete(long seq) throws SQLException {
		
		String sql = " DELETE "
	               + " FROM tbl_cstvsboard "
	               + " WHERE seq = ? ";
		
		int rowCount = 0;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, seq);
		rowCount = this.pstmt.executeUpdate();
		
		return rowCount;

	} // delete

	@Override
	public int getTotalRecords() throws SQLException {
		int totalRecords = 0;      
        String sql = "SELECT COUNT(*) FROM tbl_cstvsboard";
        this.pstmt = this.conn.prepareStatement(sql);
        this.rs =  this.pstmt.executeQuery();      
        if( this.rs.next() ) totalRecords = rs.getInt(1);      
        this.rs.close();
        this.pstmt.close();     
        return totalRecords;
	}

	@Override
	public int getTotalPages(int numberPerPage) throws SQLException {
		int totaPages = 0;      
		String sql = "SELECT CEIL(COUNT(*)/?) FROM tbl_cstvsboard";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, numberPerPage);
		this.rs =  this.pstmt.executeQuery();      
		if( this.rs.next() ) totaPages = rs.getInt(1);      
		this.rs.close();
		this.pstmt.close();     
		return totaPages;
	}

	@Override
	   public int getTotalPages(int numberPerPage, String searchCondition, String searchWord) throws SQLException {
	      int totalPages = 0;      
	      String sql = "SELECT CEIL(COUNT(*)/?) "
	            + "FROM tbl_cstvsboard ";
	      // 검색조건에 맞는 WHERE절 추가.S
	          switch (searchCondition) {
	         case "t":
	            sql += " WHERE REGEXP_LIKE(title, ?, 'i')  "; 
	            break;
	         case "w":
	            sql += " WHERE REGEXP_LIKE(writer, ?, 'i')  "; 
	            break;
	         case "c":
	            sql += " WHERE REGEXP_LIKE(content, ?, 'i')  "; 
	            break;
	         case "tc":
	            sql += " WHERE REGEXP_LIKE(title, ?, 'i')  OR REGEXP_LIKE(content, ?, 'i') "; 
	            break; 
	        }      
	         // 검색조건에 맞는 WHERE절 추가.E   
	          
	      this.pstmt = this.conn.prepareStatement(sql);
	      this.pstmt.setInt(1, numberPerPage);
	      this.pstmt.setString(2, searchWord);
	      if( searchWord.equals("tc") )  {
	         this.pstmt.setString(3, searchWord); 
	      }
	      
	      
	      this.rs =  this.pstmt.executeQuery();      
	      if( this.rs.next() ) totalPages = rs.getInt(1);      
	      this.rs.close();
	      this.pstmt.close();            
	      return totalPages;
	   }
	
	@Override
	public ArrayList<BoardDTO> select(int currentPage, int numberPerPage) throws SQLException {
		long seq;
		String title, writer, email;
		Date writedate;
		int readed;

		ArrayList<BoardDTO> list = null;
		
		String sql =
				"SELECT *  "
				+ "FROM( "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM( "
				+ "        SELECT seq, title, writer, email, writedate, readed "
				+ "        FROM tbl_cstVSBoard "
				+ "        ORDER BY seq DESC "
				+ "    ) t "
				+ ")b "
				+ "WHERE no BETWEEN ? AND ?";
		
		// 게시판 조회 S
	      BoardDTO vo = null;
	      
	      int start = (currentPage - 1) * numberPerPage + 1;
	      int end =  start + numberPerPage-1;
	      int totalRecords = getTotalRecords();
	      if( end > totalRecords) end = totalRecords;
	      
	      try {
	         // stmt = conn.createStatement();
	         // rs = stmt.executeQuery(sql);
	    	  pstmt = conn.prepareStatement(sql);
	    	  pstmt.setInt(1, start);
	    	  pstmt.setInt(2, end);
	    	
	    	  rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            list = new ArrayList<BoardDTO>();
	            do {
	            	// seq, title, writer, email, writedate, readed
	               seq = rs.getLong("seq");
	               title = rs.getString("title");
	               writer = rs.getString("writer");
	               email = rs.getString("email");
	               writedate = rs.getDate("writedate");
	               readed = rs.getInt("readed");
	               vo = new BoardDTO().builder()
	            		   .seq(seq)
	            		   .title(title)
	            		   .writer(writer)
	            		   .email(email)
	            		   .writedate(writedate)
	            		   .readed(readed)
	            		   .build();
	               list.add(vo);
	            } while (rs.next());
	            
	         } // if
	         
	      } catch (SQLException e) { 
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
		// 게시판 조회 E
		
		return list;
	}

	@Override
	public int getTotalRecords(String searchCondition, String searchWord) throws SQLException {
		return 0;
	}

	@Override
	public ArrayList<BoardDTO> search(String searchCondition, String searchWord,
			int currentPage, int numberPerPage) throws SQLException {
		long seq;
		String title, writer, email;
		Date writedate;
		int readed;

		ArrayList<BoardDTO> list = null;
		
		String sql =
				"SELECT *  "
				+ "FROM( "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM( "
				+ "        SELECT seq, title, writer, email, writedate, readed "
				+ "        FROM tbl_cstVSBoard ";
				// 검색조건에 맞는 where 절 추가 Start
				switch (searchCondition) {
				case "t":
					sql += " WHERE REGEXP_LIKE(title, ?, 'i')  ";
					break;
				case "w":
					sql += " WHERE REGEXP_LIKE(writer, ?, 'i')  ";
					break;
				case "c":
					sql += " WHERE REGEXP_LIKE(content, ?, 'i')  ";
					break;
				case "tc":
					sql += " WHERE REGEXP_LIKE(title, ?, 'i') or REGEXP_LIKE(content, ?, 'i') ";
					break;
				}
				// 검색조건에 맞는 where 절 추가 End
				sql+= "        ORDER BY seq DESC "
				+ "    ) t "
				+ ")b "
				+ "WHERE no BETWEEN ? AND ?";
		
		// 게시판 조회 S
	      BoardDTO vo = null;
	      
	      int start = (currentPage - 1) * numberPerPage + 1;
	      int end =  start + numberPerPage-1;
	      int totalRecords = getTotalRecords();
	      if( end > totalRecords) end = totalRecords;
	      
	      try {
	    	  pstmt = conn.prepareStatement(sql);
	    	  
	    	  pstmt.setString(1, searchWord);
	         // tc
	    	  if( searchWord.equals("tc")) {
	    		  pstmt.setString(2, searchWord);
	    		  pstmt.setInt(3, start);
	    		  pstmt.setInt(4, end);
	    	  }else {
	    		  pstmt.setInt(2, start);
	    		  pstmt.setInt(3, end);
	    	  }
	    	
	    	  rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            list = new ArrayList<BoardDTO>();
	            do {
	            	// seq, title, writer, email, writedate, readed
	               seq = rs.getLong("seq");
	               title = rs.getString("title");
	               writer = rs.getString("writer");
	               email = rs.getString("email");
	               writedate = rs.getDate("writedate");
	               readed = rs.getInt("readed");
	               vo = new BoardDTO().builder()
	            		   .seq(seq)
	            		   .title(title)
	            		   .writer(writer)
	            		   .email(email)
	            		   .writedate(writedate)
	            		   .readed(readed)
	            		   .build();
	               list.add(vo);
	            } while (rs.next());
	            
	         } // if
	         
	      } catch (SQLException e) { 
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
		// 게시판 조회 E
		
		return list;
	}
}
