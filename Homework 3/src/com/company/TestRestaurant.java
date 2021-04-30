package com.company;

import java.util.Random;

public class TestRestaurant {
    public static void main(String[] args) {
        Random random = new Random();
        String[] randomNames = {"Arlina", "Eugine", "Cindie", "Diann", "Ardith", "Valida", "Deina", "Melisa", "Joane", "Olly", "Ethyl", "Bea", "Trudy", "Tansy", "Dru", "Madlen", "Janka", "Renate", "Catlin", "Lari", "Valida", "Fifine", "Malory", "Kacie", "Anita", "Etti", "Paige", "Amalea", "Glori", "Tracey", "Blithe", "Gerta", "Ruby", "Joana", "Nerti", "Inez", "Alfi", "Glenn", "Alis", "Edith", "Kirsti", "Cynde", "Rheta", "Donia", "Tarra", "Juana", "Reeta", "Ilyssa", "Roanne", "Candie", "Becky", "Vikky", "Daphne", "Rhea", "Hilde", "Vivie", "Mae", "Alice", "Oriana", "Brynn", "Elena", "Ronna", "Sharl", "Noell", "Riane", "Jeane", "Margi", "Nessy", "Aurlie", "Olympe", "Adella", "Jeanne", "Sarita", "Arleta", "Barbe", "Alexis", "Myrle", "Floris", "Joly", "Delora", "Lizzy", "Pris", "Rebe", "Elfie", "Dulcia", "Magda", "Zea", "Phylys", "Lula", "Alanah", "Kathye", "Leila", "Theo", "Sibyl", "Serena", "Damita", "Rhodia", "Danny", "Berget", "Mattie", "Zuzana"};
        Customer tempCustomer;
        String customerName;
        Customer[] customerList = new Customer[8];
        for (int i = 0; i < 8; i++) {
            customerName = randomNames[(int) (Math.random() * 59 - 0 + 1) + 1];
            tempCustomer = new Customer(customerName);
            customerList[i] = tempCustomer;
        }
        RestaurantWaitList myRestaurant = new RestaurantWaitList(customerList);
        myRestaurant.seatCustomers();
        while (true) {
            int timePassed = (int) (Math.random() * (20 - 10 + 1) + 10);
            if (myRestaurant.passTime(timePassed)) {
                customerName = randomNames[(int) (Math.random() * 59 - 0 + 1) + 1];
                tempCustomer = new Customer(customerName);
                myRestaurant.addToDeque(tempCustomer);
            } else {
                break;
            }
        }
        myRestaurant.printLogs();

    }
}
