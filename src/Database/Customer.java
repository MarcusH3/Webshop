package Database;

public class Customer {

        private final int id;
        private String customerFirstName ;
        private String customerLastName;
        private String customerAddress;
        private String customerEMail;

        private int customerPhoneNumber;
        private String password;
        private City city;

        public Customer(int id, String firstName, String lastName, int phoneNumber, String email, String password, String address, City city) {
            this.id = id;
            this.customerFirstName = firstName;
            this.customerLastName = lastName;
            this.customerPhoneNumber = phoneNumber;
            this.customerEMail = email;
            this.password = password;
            this.customerAddress = address;
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {return customerEMail;}

        public String getFullName() {
            return customerFirstName + " " + customerLastName;
        }

        @Override
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
        }
}
