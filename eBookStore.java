import java.sql.*;
import java.util.Scanner;

class Users{
    public String viewTop10NewBook(){
        String strSelect = "Select * from books Order By BookID DESC LIMIT 10;";
        return strSelect;
    }
    public String viewTop100Sale(){
        String strSelect = "SELECT books.BookName, books.AuthorName, books.Categories, books.Price,books.status,books.amount " +
                "FROM orderdetails " +
                "INNER JOIN books ON books.BookID = orderdetails.BookID " +
                "INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID " +
                "WHERE orderstatus.status = 1 " +
                "LIMIT 100;";
        return strSelect;
    }
    public String findCategories(String categories){
        String strSelect = "SELECT * FROM books WHERE Categories = '" + categories + "';";
        return strSelect;
    }
    public String findAuthor(String authorname){
        String strSelect = "SELECT * FROM books WHERE AuthorName = '" + authorname + "';";
            return strSelect;
    }
    public String viewBook(int BookID){
        String strSelect = "SELECT * FROM books WHERE BookID = '" + BookID + "';";
        return strSelect;
    }
    public String view30OrderBySTT1(){
        String strSelect = "SELECT * FROM orderdetails " +
                "INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID " +
                "WHERE orderstatus.status = 1 LIMIT 30";
        return strSelect;
    }
    public  String viewOrderByCusID(){
        String strSelect = "SELECT * FROM orderdetails ORDER BY CusID ASC";
        return strSelect;
    }
    public String viewSTTByOrderID(){
        String strSelect = "SELECT * FROM orderstatus ORDER BY OrderID ASC";
        return strSelect;
    }
    public String viewOrderdetailbyOrderID(int orderID){
        String strSelect = "SELECT * FROM orderdetails WHERE OrderID = '" + orderID + "'";
        return strSelect;
    }
    public String viewOrderBySTT2(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID WHERE orderstatus.status = 2";
        return strSelect;
    }
    public String viewOrderBySTT3(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID WHERE orderstatus.status = 3";
        return strSelect;
    }
    public String viewOrderBySTT4(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID WHERE orderstatus.status = 4";
        return strSelect;
    }
    public String viewOrderBySTT5(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID WHERE orderstatus.status = 5";
        return strSelect;
    }
    public String viewOrderBySTT0(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatus ON orderdetails.OrderID = orderstatus.OrderID WHERE orderstatus.status = 0";
        return strSelect;
    }
}
public class eBookStore {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root","");
                Statement stmt = conn.createStatement();
        ){
            Users u1 = new Users();
            ResultSet rset = stmt.executeQuery(u1.viewTop10NewBook());
            while (rset.next()){
                int BookID = rset.getInt("BookID");
                String BookName = rset.getString("BookName");
                String AuthorName = rset.getString("AuthorName");
                String Categories = rset.getString("Categories");
                Float Price = rset.getFloat("Price");
                String status = rset.getString("status");
                int amount = rset.getInt("amount");
                System.out.println(BookID + ", " + BookName + ", " + AuthorName + ", " + Categories + ", " + Price + ", " + status + ", " + amount);
            }

            ResultSet rset2 = stmt.executeQuery(u1.viewTop100Sale());
            while (rset2.next()){
                String BookName = rset2.getString("BookName");
                String AuthorName = rset2.getString("AuthorName");
                String Categories = rset2.getString("Categories");
                Float Price = rset2.getFloat("Price");
                String status = rset2.getString("status");
                int amount = rset2.getInt("amount");
                System.out.println(BookName + ", " + AuthorName + ", " + Categories + ", " + Price + ", " + status + ", " + amount);
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Input book's author name !");
            String authorname = input.nextLine();
            ResultSet rset5 = stmt.executeQuery(u1.findAuthor(authorname));
            while (rset5.next()){
                String BookName = rset5.getString("BookName");
                String Categories = rset5.getString("Categories");
                Float Price = rset5.getFloat("Price");
                String status = rset5.getString("status");
                int amount = rset5.getInt("amount");
                System.out.println(BookName + ", " + Categories + ", " + Price + ", " + status + ", " + amount);
            }

            System.out.println("Input book's categories !");
            String categoies = input.nextLine();
            ResultSet rset3 = stmt.executeQuery(u1.findCategories(categoies));
            while (rset3.next()){
                String BookName = rset3.getString("BookName");
                String AuthorName = rset3.getString("AuthorName");
                Float Price = rset3.getFloat("Price");
                String status = rset3.getString("status");
                int amount = rset3.getInt("amount");
                System.out.println(BookName + ", " + AuthorName  + ", " + Price + ", " + status + ", " + amount);
            }

            System.out.println("Input BookID");
            int bookID = input.nextInt();
            ResultSet rset4 = stmt.executeQuery(u1.viewBook(bookID));
            while (rset4.next()){
                String BookName = rset4.getString("BookName");
                String AuthorName = rset4.getString("AuthorName");
                String Categories = rset4.getString("Categories");
                Float Price = rset4.getFloat("Price");
                String status = rset4.getString("status");
                int amount = rset4.getInt("amount");
                System.out.println(BookName + ", " + AuthorName + ", " + Categories + ", " + Price + ", " + status + ", " + amount);
            }

            ResultSet rset6 = stmt.executeQuery(u1.view30OrderBySTT1());
            while (rset6.next()) {
                int OrderID = rset6.getInt("OrderID");
                int CusID = rset6.getInt("CusID");
                int BookID = rset6.getInt("BookID");
                Float price = rset6.getFloat("price");
                int amount = rset6.getInt("amount");
                System.out.println(OrderID + ", " + CusID + ", " + BookID + ", " + price + ", " + amount);
            }
            ResultSet rset7 = stmt.executeQuery(u1.viewOrderByCusID());
            while (rset7.next()){
                int OrderID = rset7.getInt("OrderID");
                int CusID = rset7.getInt("CusID");
                int BookID = rset7.getInt("BookID");
                Float price = rset7.getFloat("price");
                int amount = rset7.getInt("amount");
                System.out.println(OrderID + ", " + CusID + ", " + BookID + ", " + price + ", " + amount);
            }
            ResultSet rset8 = stmt.executeQuery(u1.viewSTTByOrderID());
            while (rset8.next()){
                int OrderID = rset8.getInt("OrderID");
                int status = rset8.getInt("status");
                System.out.println(OrderID + ", " + status);
            }
            System.out.println("Input OrderID");
            int orderID = input.nextInt();
            ResultSet rset9 = stmt.executeQuery(u1.viewOrderdetailbyOrderID(orderID));
            while (rset9.next()){
                int CusID = rset9.getInt("CusID");
                int BookID = rset9.getInt("BookID");
                Float price = rset9.getFloat("price");
                int amount = rset9.getInt("amount");
                System.out.println(CusID + ", " + BookID + ", " + price + ", " + amount);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
