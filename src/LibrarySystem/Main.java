package LibrarySystem;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main{

    private static int memberID;
    private static Main instance = null;
    public static Main getInstance(){
        if(instance == null){
            instance = new Main();
        }
        return  instance;
    }


    private static String Date =  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    private static LinkedList<Book> book = new LinkedList<>();
    private static LinkedList<Student> students = new LinkedList<>();
    private static LinkedList<Faculty> faculties = new LinkedList<>();
    private static LinkedList<Transaction> transactions = new LinkedList<>();
    private static Stack<Bill> bills = new Stack<>();



    public static void addBook(int bookId, String author, String name, double price, boolean status){
        book.add(new Book(bookId,author,name,price,status));

    }



    public void deleteBook(int number){
        book.remove(number);
    }

    public  void addStudent(int MemberId,String type, String name, String adress, String phoneNo, String date){

        students.add(new Student(MemberId,type,name,adress,phoneNo,date));
    }

    public  void addFaculty(int MemberId,String type, String name, String adress, String phoneNo, String date){
        faculties.add(new Faculty(MemberId,type,name,adress,phoneNo,date));
    }

    public void addTransaction(int TransactionId, int memberId, int bookId, String dateOfIssue, String duedate){
        transactions.add(new Transaction(TransactionId,memberId,bookId,dateOfIssue,duedate));
    }

    public void addBill(int billNo, String date, int memberId, int amount){
        bills.add(new Bill(billNo,date,memberId,amount));
    }

    public void deleteBill(){
        bills.pop();
    }

    public static LinkedList<Book> listBook(){ return book; }

    public static LinkedList<Student> listStudent(){
        return students;
    }

    public static LinkedList<Faculty> listFaculty() { return faculties; }

    public static LinkedList<Transaction> listTransaction(){return  transactions;}

    public static Stack<Bill> listBill(){ return bills;}



    public String logBook(){
        String output ="";

        for(Book item : book){
            output+=item+"\n";
        }
        return output;
    }

    public String logStudent(){
        String output ="";

        for(Student item : students){
            output+=item+"\n";
        }
        return output;
    }

    public String logTransaction(){
        String output ="";
        Iterator value = transactions.iterator();
        while (value.hasNext()){
            output+=value.next()+"\n";

        }
        return output;
    }


    public boolean checkUser(int MemberId){
        boolean result=false;
        for(Student element : students){
            if(element.getMemberId() == MemberId)
                result=true;
                if(result){
                    break;
                }
            else
                result=false;
        }
        for(Faculty element : faculties){
            if(element.getMemberId() == MemberId)
                result=true;
            if(result){
                break;
            }
            else
                result=false;
        }

        return result;
    }


    public String loginGetInfo(){
        String result="";
        for(Student element: students){
            if(element.getMemberId() == memberID)
                result = element.toString();
        }
        for(Faculty element: faculties){
            if(element.getMemberId() == memberID)
                result = element.toString();
        }
        return result;
    }

    public String loginWelcome(){
        String result="";
        for(Student element: students){
            if(element.getMemberId() == memberID)
                result = "Welcome, "+element.getName();
        }
        for(Faculty element: faculties){
            if(element.getMemberId() == memberID)
                result = "Welcome, "+element.getName();
        }
        return result;

    }

    public int loginGetMemberId(){

        return this.memberID;
    }

    public int loginSetMemberId(int memberId){
        return this.memberID = memberId;
    }

    public boolean checkBookId(int bookID){
        boolean result = false;
        for(Book item : book) {
            if (item.getBookId() == bookID)
                result = true;
                if(result)
                    break;
            else
                result = false;

        }
        return result;
    }

    public boolean bookStatusCheck(int bookId){
        boolean result = false;
        for(Book book : book){
            if(book.getBookId() == bookId){
                if(book.getStatus() == false){
                    result = false;
                    break;
                }
                result = true;
                break;
            }
        }
        return result;

    }
    public boolean transactionCheck(int TransactionID, String Date){
        boolean result = false;
        int bookID = 0;
        for(Transaction item : transactions) {
            if (item.getTransactionId() == TransactionID) {
                item.setDateOfIssue(Date);
                bookID = item.getBookId();
                for(Book book: book){
                    if(book.getBookId() == bookID) {
                        book.setStatus(false);
                        result = true;
                    }
                }
                break;
                }

            else
                result = false;

        }
        return result;
    }

    public boolean returnBookSet(int TransactionID, String Date){
        boolean result = false;
        int bookID = 0;
        for(Transaction item : transactions) {
            if (item.getTransactionId() == TransactionID) {
                item.setDueDate(Date);
                bookID = item.getBookId();
                for(Book book: book){
                    if(book.getBookId() == bookID) {
                        book.setStatus(true);
                        result = true;
                    }
                }
                break;
            }

            else
                result = false;

        }
        return result;
    }




}