package Database;

public class Customer {

        private final int id;
        private String customerFirstName ;
        private String customerLastName;
        private String customerAddress;
        private String customerEMail;

        private String customerPhoneNumber;
        private String password;
        private int cityID;

        public Customer(int id, String firstName, String lastName, String phoneNumber, String email, String password, String address, int cityID) {
            this.id = id;
            this.customerFirstName = firstName;
            this.customerLastName = lastName;
            this.customerPhoneNumber = phoneNumber;
            this.customerEMail = email;
            this.password = password;
            this.customerAddress = address;
            this.cityID = cityID;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {return customerEMail;}

        public String getFullName() {
            return customerFirstName + " " + customerLastName;
        }

/*        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", firstName='" + customerFirstName + '\'' +
                    ", lastName='" + customerLastName + '\'' +
                    ", phoneNumber=" + customerPhoneNumber +
                    ", email='" + customerEMail + '\'' +
                    ", password='" + password + '\'' +
                    ", Address='" + customerAddress + '\'' +
                    ", city=" + city +
                    '}';
        }*/

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEMail() {
        return customerEMail;
    }

    public void setCustomerEMail(String customerEMail) {
        this.customerEMail = customerEMail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }*/
}
