package LibrarySystem;

public class Bill{
    private int billNo;
    private String date;
    private int memberId;
    private int amount;


    public Bill() {
    }

    public Bill(int billNo, String date, int memberId, int amount) {
        this.billNo = billNo;
        this.date = date;
        this.memberId = memberId;
        this.amount = amount;
    }

    public int getBillNo() {
        return this.billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill billNo(int billNo) {
        this.billNo = billNo;
        return this;
    }

    public Bill date(String date) {
        this.date = date;
        return this;
    }

    public Bill memberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public Bill amount(int amount) {
        this.amount = amount;
        return this;
    }

    
    @Override
    public String toString() {
        return "{" +
            " billNo='" + getBillNo() + "'" +
            ", date='" + getDate() + "'" +
            ", memberId='" + getMemberId() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }
    public void createBill(){
        // Todo createBill
    }
    public void billUpdate(){
        // Todo billUpdate
    }
}