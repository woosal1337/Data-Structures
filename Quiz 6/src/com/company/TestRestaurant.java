package com.company;

public class TestRestaurant {
    public static void main(String[] args) {
        String[] randomNames = {"Arlina", "Eugine", "Cindie", "Diann", "Ardith", "Valida", "Deina", "Melisa", "Joane", "Olly", "Ethyl", "Bea", "Trudy", "Tansy", "Dru", "Madlen", "Janka", "Renate", "Catlin", "Lari", "Valida", "Fifine", "Malory", "Kacie", "Anita", "Etti", "Paige", "Amalea", "Glori", "Tracey", "Blithe", "Gerta", "Ruby", "Joana", "Nerti", "Inez", "Alfi", "Glenn", "Alis", "Edith", "Kirsti", "Cynde", "Rheta", "Donia", "Tarra", "Juana", "Reeta", "Ilyssa", "Roanne", "Candie", "Becky", "Vikky", "Daphne", "Rhea", "Hilde", "Vivie", "Mae", "Alice", "Oriana", "Brynn", "Elena", "Ronna", "Sharl", "Noell", "Riane", "Jeane", "Margi", "Nessy", "Aurlie", "Olympe", "Adella", "Jeanne", "Sarita", "Arleta", "Barbe", "Alexis", "Myrle", "Floris", "Joly", "Delora", "Lizzy", "Pris", "Rebe", "Elfie", "Dulcia", "Magda", "Zea", "Phylys", "Lula", "Alanah", "Kathye", "Leila", "Theo", "Sibyl", "Serena", "Damita", "Rhodia", "Danny", "Berget", "Mattie", "Zuzana"};
        String nameOfTheCustomer;
        Customer customer;
        Customer[] customers = new Customer[8];
        boolean isSmoking = true;
        for (int i = 0; i < 8; i++) {
            nameOfTheCustomer = randomNames[(int) (Math.random() * 59 - 0 + 1) + 1];
            if (i >= 5) {
                isSmoking = false;
            }
            customer = new Customer(nameOfTheCustomer, isSmoking);
            customers[i] = customer;
        }
        RestaurantWaitList myRestaurantWait = new RestaurantWaitList(customers);
        myRestaurantWait.seatCustomers();
        int counter = 0;
        while (true) {
            int timePassed = (int) (Math.random() * (11));
            if (myRestaurantWait.passTime(timePassed)) {
                isSmoking = true;
                if (counter == 3) {
                    counter = 0;
                    isSmoking = false;
                }
                nameOfTheCustomer = randomNames[(int) (Math.random() * 59 - 0 + 1) + 1];
                customer = new Customer(nameOfTheCustomer, isSmoking);
                myRestaurantWait.addToDeque(customer);
            } else {
                break;
            }
            counter++;
        }
        myRestaurantWait.printLogs();
    }
}