
public class Driver {
    public int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Driver(){

    }
    public Driver(int Id){
        this.id = Id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Driver))
            return false;
        Driver other = (Driver) obj;

        return other.getId() == this.getId();
    }
}
