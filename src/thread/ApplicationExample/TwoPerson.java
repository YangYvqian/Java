package thread.ApplicationExample;

public  class TwoPerson {
    private final String name;
    private final String address;
    
    public TwoPerson(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "TwoPerson [address=" + address + ", name=" + name + "]";
    }

    
    
    
    
}
