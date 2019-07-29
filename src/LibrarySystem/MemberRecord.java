package LibrarySystem;

public class MemberRecord{
    private int memberId;
    private String type;
    private String name;
    private String adress;
    private String phoneNo;
    private String dateOfMembership; // Change maybe
    public MemberRecord() {
    }

    public MemberRecord(int memberId, String type, String name, String adress, String phoneNo,String dateOfMembership) {
        this.memberId = memberId;
        this.type = type;
        this.name = name;
        this.adress = adress;
        this.phoneNo = phoneNo;
        this.dateOfMembership = dateOfMembership;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOfMembership() {
        return this.dateOfMembership;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public MemberRecord memberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public MemberRecord type(String type) {
        this.type = type;
        return this;
    }

    public MemberRecord dateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
        return this;
    }

    public MemberRecord name(String name) {
        this.name = name;
        return this;
    }

    public MemberRecord adress(String adress) {
        this.adress = adress;
        return this;
    }

    public MemberRecord phoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }


    @Override
    public String toString() {
        return
             getMemberId() + ","+
             getType() + "," +
             getDateOfMembership() + "," +
             getName() + "," +
             getAdress() + "," +
             getPhoneNo() + ","
            ;
    }



    public void registerMember(){
        // Todo Register
    }
    public void payBill(){
        // Todo payBill
    }    

}