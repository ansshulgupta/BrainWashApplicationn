/*
 * package com.BrainWash.dbconfig;
 * 
 * import java.sql.*; import java.util.ArrayList; import java.util.List;
 * 
 * import com.BrainWash.model.SpellingBook;
 * 
 * 
 * public class BrainWashJdbcRepository {
 * 
 * private Connection con=null; private PreparedStatement pst=null;
 * 
 * public BrainWashJdbcRepository() {
 * 
 * // jdbc connectivity // String
 * url="jdbc:mysql://localhost:3306/messengerapp"; String url =
 * "jdbc:mysql://localhost/competencychecker"; String user="root"; String
 * password="discover";
 * 
 * try { Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.cj.jdbc.Driver
 * con = DriverManager.getConnection(url, user,password);
 * System.out.println("Database Connected");
 * 
 * } catch (Exception ex) { System.out.println(ex.getMessage());
 * ex.printStackTrace(); } }
 * 
 * public void insertSpelling(SpellingBook SBook) {
 * System.out.println(SBook.getSpellingName()); String insertSpelling=
 * "insert into spellingbook values (?,?,?,?,?,?)" ;
 * 
 * try {
 * 
 * pst=con.prepareStatement(insertSpelling);
 * 
 * 
 * pst.setInt(1,SBook.getMsgId()); pst.setString(2,SBook.getMessage());
 * pst.setString(3,SBook.getAuthor()); pst.setString(4,SBook.getCreated());
 * 
 * 
 * if(pst.executeUpdate()>0) {
 * 
 * System.out.println("Data inserted");
 * 
 * }
 * 
 * con.close();
 * 
 * } catch (Exception e) {
 * System.out.println("Insert query failed because of "+e.getMessage());
 * e.printStackTrace(); }
 * 
 * 
 * }
 * 
 * public List<Message> getAllMessages() { String
 * getAllMessagesQuery="select * from message"; List<Message> msglist = new
 * ArrayList<>();
 * 
 * try { pst=con.prepareStatement(getAllMessagesQuery);
 * 
 * ResultSet rs=pst.executeQuery(); while(rs.next()) { Message m = new
 * Message();
 * 
 * m.setMsgId(rs.getInt("msgId")); m.setMessage(rs.getString("message"));
 * m.setCreated(rs.getString("created")); m.setAuthor(rs.getString("author"));
 * 
 * msglist.add(m); }
 * 
 * 
 * } catch (Exception e) {
 * System.out.println("Get All Messages Query failed because of "+e.getMessage()
 * ); e.printStackTrace(); }
 * 
 * 
 * return msglist; }
 * 
 * public Message getMessageById(int msgId ) { Message m = null;
 * 
 * String getMsgById="select * from message where msgid="+msgId;
 * 
 * try { pst=con.prepareStatement(getMsgById); ResultSet rs=pst.executeQuery();
 * 
 * if(rs.next()) { m=new Message(); m.setMsgId(rs.getInt("msgId"));
 * m.setMessage(rs.getString("message")); m.setCreated(rs.getString("created"));
 * m.setAuthor(rs.getString("author")); }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } return m; }
 * 
 * public void updateMessage(Message m) { String
 * updateQuery="update message set message=?, author=? where msgid=?";
 * 
 * try { pst = con.prepareStatement(updateQuery); pst.setString(1,
 * m.getMessage()); pst.setString(2, m.getAuthor()); pst.setInt(3,m.getMsgId());
 * 
 * pst.executeUpdate();
 * 
 * 
 * } catch (SQLException e) { e.printStackTrace(); } }
 * 
 * public void deleteMessage(int msgid) { String
 * deleteQuery="delete from message where msgid="+msgid;
 * 
 * try { con.prepareStatement(deleteQuery).executeUpdate(); } catch
 * (SQLException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * 
 * 
 * }
 */