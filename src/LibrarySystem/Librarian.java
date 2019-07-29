package LibrarySystem;

public class Librarian {
    private String name = "admin";
    private String password = "admin";
    private boolean control = false;

    Transaction tr = new Transaction(546, 2, 364, "18.2.08", "19.6.09");

    public boolean checkUser(String name, String password){
        if(this.name == name && this.password == password){
            control = true;
            System.out.println(tr.toString());
        }
        else{
            control = false;
        }
        msg();
        return control;
        
    }

    

    public void msg(){
        if(control){
            System.out.println("Giriş Başarılı!");
        }else{
            System.out.println("Giriş Başarısız!");
        }
        
    }

    public void searchBook(){
        // Todo search book
    }
    public void verifyBook(){
        // Todo verify book
    }
    public void issueBook(){
        // Todo issue book
    }
    public void calculateFine(){
        // Todo calculate fine
    }
    public void createBill(){
        // Todo create Bill
    }
    public void returnBook(){
        // Todo retrun book
    }

}