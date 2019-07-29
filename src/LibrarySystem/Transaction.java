package LibrarySystem;

public class Transaction implements ITransaction {
    private int transactionId;
    private int memberId;
    private int bookId;
    private String dateOfIssue;
    private String dueDate;        

    public Transaction() {
    }

    public Transaction(int transactionId, int memberId, int bookId, String dateOfIssue, String dueDate) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.dateOfIssue = dateOfIssue;
        this.dueDate = dueDate;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBookId() {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDateOfIssue() {
        return this.dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Transaction transactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Transaction memberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public Transaction bookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public Transaction dateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
        return this;
    }

    public Transaction dueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }


    @Override
    public String toString() {
        return
                getTransactionId() + "," +
                getMemberId() + "," +
                getBookId() + "," +
                getDateOfIssue() + "," +
                getDueDate() + ",";
    }
    
    public void transactionId(){
        // Todo transactionId
    }
    public void deleteTransaction(){
        // Todo deleteTransaction
        System.out.println("Todo deleteTransaction");
    }
    public void retriveTransaction(){
        // Todo retriveTransaction
    }

}