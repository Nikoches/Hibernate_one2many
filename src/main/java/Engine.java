public class Engine {
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Engine(){

    }
    public Engine(int id){
        this.id=id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Engine))
            return false;
        Engine other = (Engine) obj;

        return other.getId() == this.getId();
    }
}
