import Controllers.*;
import Models.Car;
import Models.Client;
import Models.Person;
import Models.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CarController carController = new CarController();
        PriceListController priceListController = new PriceListController();
        PersonController personController = new PersonController();
        RentController rentController = new RentController();
        ClientController clientController = new ClientController();

        ImageIcon imageIcon = new ImageIcon("redcar.jpg");
        ImageIcon logo = new ImageIcon("logo.png");

        JFrame frame = new JFrame();
        frame.setTitle("RedCar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(720, 650);
        frame.setVisible(true);
        frame.setIconImage(logo.getImage());
        //frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        JFrame searchCarByIdFrame = new JFrame();
        searchCarByIdFrame.setIconImage(logo.getImage());
        JFrame searchCarByModelFrame = new JFrame();
        searchCarByModelFrame.setIconImage(logo.getImage());
        JFrame searchCarByVINFrame = new JFrame();
        searchCarByVINFrame.setIconImage(logo.getImage());
        JFrame searchCarByBrandFrame = new JFrame();
        searchCarByBrandFrame.setIconImage(logo.getImage());
        JFrame printAllCarsFrame = new JFrame();
        printAllCarsFrame.setIconImage(logo.getImage());
        JFrame addingCarFrame = new JFrame();
        addingCarFrame.setIconImage(logo.getImage());
        JFrame removingCarFrame = new JFrame();
        removingCarFrame.setIconImage(logo.getImage());
        JFrame searchPersonByPeselFrame = new JFrame();
        searchPersonByPeselFrame.setIconImage(logo.getImage());
        JFrame addingPersonFrame = new JFrame();
        addingPersonFrame.setIconImage(logo.getImage());
        JFrame removingPersonFrame = new JFrame();
        removingPersonFrame.setIconImage(logo.getImage());
        JFrame searchRentByIdFrame = new JFrame();
        searchRentByIdFrame.setIconImage(logo.getImage());
        JFrame addingRentFrame = new JFrame();
        addingRentFrame.setIconImage(logo.getImage());
        JFrame removingRentFrame = new JFrame();
        removingRentFrame.setIconImage(logo.getImage());
        JFrame addingClientFrame = new JFrame();
        addingClientFrame.setIconImage(logo.getImage());
        JFrame removingClientFrame = new JFrame();
        removingClientFrame.setIconImage(logo.getImage());


        JPanel contentPanel = new JPanel();

        JLabel titleLabel = new JLabel("RED CAR INSIDE SYSTEM");
        titleLabel.setIcon(imageIcon);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 40));
        titleLabel.setIconTextGap(-65);


/***************************************SEARCHING BY ID**************************************************************/

        //searchCarByIdFrame.setLayout(new FlowLayout(FlowLayout.CENTER,0,30));
        JLabel searchCarByIdLabel = new JLabel("   Search Car by id   ");
        searchCarByIdLabel.setVerticalTextPosition(JLabel.BOTTOM);
        //searchCarByIdLabel.setHorizontalTextPosition(JLabel.LEFT);
        //searchCarByIdLabel.setVerticalTextPosition(JLabel.RIGHT);
        //searchCarByIdLabel.setLocation(10, 10);

        JButton searchCarByIdButton = new JButton("Search");
        searchCarByIdButton.setBounds(100, 600, 100, 50);
        //searchCarByIdButton.setForeground(Color.LIGHT_GRAY);
        searchCarByIdButton.setFocusable(false);
        //searchCarByIdButton.setLocation(100, 10);
        searchCarByIdButton.addActionListener(e -> {
            JPanel searchCarByIdPanel = new JPanel();
            JLabel idLabel = new JLabel("Enter car's id:");
            JTextField idInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchCarByIdFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchCarByIdFrame.setSize(420, 200);
            searchCarByIdFrame.setResizable(false);
            //newFrame.setLayout(null);
            searchCarByIdFrame.setVisible(true);
            //frame.setVisible(false);

            idInput.setPreferredSize(new Dimension(100,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                if(idInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }
                List<Car> carList = carController.searchCarById(Long.parseLong(idInput.getText()));
                if(carList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no car with that id!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, carList.toString(), "Car you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                idInput.setText("");
            });
            searchCarByIdPanel.removeAll();

            searchCarByIdFrame.add(searchCarByIdPanel);
            searchCarByIdPanel.add(idLabel);
            searchCarByIdPanel.add(idInput);
            searchCarByIdPanel.add(searchButton);
        });




/***************************************SEARCHING BY MODEL**************************************************************/

        JLabel searchCarByModelLabel = new JLabel("   Search Car by model   ");
        searchCarByModelLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton searchCarByModelButton = new JButton("Search");
        searchCarByModelButton.setBounds(100, 600, 100, 50);
        searchCarByModelButton.setFocusable(false);
        searchCarByModelButton.addActionListener(e -> {
            JPanel searchCarByModelPanel = new JPanel();
            JLabel modelLabel = new JLabel("Enter car's model: ");
            JTextField modelInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchCarByModelFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchCarByModelFrame.setSize(420, 200);
            searchCarByModelFrame.setResizable(false);
            searchCarByModelFrame.setVisible(true);

            modelInput.setPreferredSize(new Dimension(100,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                List<Car> carList = carController.searchCarByModel(modelInput.getText());
                if(carList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no car with that model!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else if(modelInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, carList.toString(), "Car you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                modelInput.setText("");
            });
            searchCarByModelPanel.removeAll();

            searchCarByModelFrame.add(searchCarByModelPanel);
            searchCarByModelPanel.add(modelLabel);
            searchCarByModelPanel.add(modelInput);
            searchCarByModelPanel.add(searchButton);
        });


/***************************************SEARCHING BY VIN**************************************************************/

        JLabel searchCarByVINLabel = new JLabel("   Search Car by VIN   ");
        searchCarByVINLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton searchCarByVINButton = new JButton("Search");
        searchCarByVINButton.setBounds(100, 600, 100, 50);
        searchCarByVINButton.setFocusable(false);
        searchCarByVINButton.addActionListener(e -> {
            JPanel searchCarByVINPanel = new JPanel();
            JLabel VINLabel = new JLabel("Enter car's VIN: ");
            JTextField VINInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchCarByVINFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchCarByVINFrame.setSize(420, 200);
            searchCarByVINFrame.setResizable(false);
            searchCarByVINFrame.setVisible(true);

            VINInput.setPreferredSize(new Dimension(160,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                List<Car> carList = carController.searchCarByVIN(VINInput.getText());
                if(carList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no car with that VIN!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else if(VINInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, carList.toString(), "Car you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                VINInput.setText("");
            });
            searchCarByVINPanel.removeAll();

            searchCarByVINFrame.add(searchCarByVINPanel);
            searchCarByVINPanel.add(VINLabel);
            searchCarByVINPanel.add(VINInput);
            searchCarByVINPanel.add(searchButton);

        });

/***************************************SEARCHING BY BRAND**************************************************************/

        JLabel searchCarByBrandLabel = new JLabel("Search Car by brand");
        searchCarByBrandLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton searchCarByBrandButton = new JButton("Search");
        searchCarByBrandButton.setBounds(100, 600, 100, 50);
        searchCarByBrandButton.setFocusable(false);
        searchCarByBrandButton.addActionListener(e -> {
            JPanel searchCarByBrandPanel = new JPanel();
            JLabel brandLabel = new JLabel("Enter car's brand: ");
            JTextField brandInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchCarByBrandFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchCarByBrandFrame.setSize(420, 200);
            searchCarByBrandFrame.setResizable(false);
            searchCarByBrandFrame.setVisible(true);

            brandInput.setPreferredSize(new Dimension(100,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                List<Car> carList = carController.searchCarByBrand(brandInput.getText());
                if(carList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no car with that brand!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else if(brandInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, carList.toString(), "Car you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                brandInput.setText("");
            });
            searchCarByBrandPanel.removeAll();

            searchCarByBrandFrame.add(searchCarByBrandPanel);
            searchCarByBrandPanel.add(brandLabel);
            searchCarByBrandPanel.add(brandInput);
            searchCarByBrandPanel.add(searchButton);

        });



/***************************************PRINT ALL CARS**************************************************************/

        JLabel printAllCarsLabel = new JLabel("          Print All Cars           ");
        searchCarByBrandLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton printAllCarsButton = new JButton("Print ");
        printAllCarsButton.setBounds(100, 600, 100, 50);
        printAllCarsButton.setFocusable(false);
        printAllCarsButton.addActionListener(e -> {
            JPanel printAllCarsPanel = new JPanel();
            JLabel printLabel = new JLabel("If you want to print all cars click on the button next to    ");
            JButton searchButton = new JButton("Print");

            printAllCarsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            printAllCarsFrame.setSize(400, 100);
            printAllCarsFrame.setResizable(false);
            printAllCarsFrame.setVisible(true);

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                List<Car> carList = carController.searchAllCars();
                if(carList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There are no cars in database", "Cars you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, carList.toString(), "Cars you searched", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            printAllCarsPanel.removeAll();

            printAllCarsFrame.add(printAllCarsPanel);
            printAllCarsPanel.add(printLabel);
            printAllCarsPanel.add(searchButton);

        });



/***************************************ADDING CAR**************************************************************/

        JLabel addingCarLabel = new JLabel("          Add new car      ");
        addingCarLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton addingCarButton = new JButton("   Add   ");
        addingCarButton.setBounds(100, 600, 100, 50);
        addingCarButton.setFocusable(false);
        addingCarButton.addActionListener(e -> {
            JPanel addCarPanel = new JPanel(new GridLayout(10, 2, 10, 7));
            JLabel addLabel = new JLabel("ADDING CAR");
            //addLabel.setHorizontalTextPosition(JLabel.CENTER);
            addLabel.setHorizontalAlignment(JLabel.CENTER);
            //addLabel.setVerticalTextPosition(JLabel.TOP);
            addLabel.setVerticalAlignment(JLabel.TOP);
            addLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
            //addLabel.setIconTextGap(-65);

            JLabel brandLabel = new JLabel("Enter car's brand: ");
            JTextField brandInput = new JTextField();
            JLabel modelLabel = new JLabel("Enter car's model: ");
            JTextField modelInput = new JTextField();
            JLabel licensePlateLabel = new JLabel("Enter Car's license plate:");
            JTextField licensePlateInput = new JTextField();
            JLabel productionYearLabel = new JLabel("Enter Car's productionYear:");
            JTextField productionYearInput = new JTextField();
            JLabel mileageLabel = new JLabel("Enter Car's mileage:");
            JTextField mileageInput = new JTextField();
            JLabel fuelLabel = new JLabel("Enter Car's type of fuel:");
            JTextField fuelInput = new JTextField();
            JLabel VINLabel = new JLabel("Enter Car's VIN number:");
            JTextField VINInput = new JTextField();
            JLabel priceLabel = new JLabel("Enter Car's price:");
            JTextField priceInput = new JTextField();
            JLabel helpLabel2 = new JLabel("");
            JButton addButton = new JButton("Add");

            addingCarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            addingCarFrame.setSize(420, 500);
            addingCarFrame.setResizable(false);
            addingCarFrame.setVisible(true);

            brandInput.setPreferredSize(new Dimension(100,30));
            modelInput.setPreferredSize(new Dimension(100,30));
            licensePlateInput.setPreferredSize(new Dimension(100,30));
            productionYearInput.setPreferredSize(new Dimension(100,30));
            mileageInput.setPreferredSize(new Dimension(100,30));
            fuelInput.setPreferredSize(new Dimension(100,30));
            VINInput.setPreferredSize(new Dimension(160,30));
            priceInput.setPreferredSize(new Dimension(100,30));

            addButton.setBounds(100, 400, 100, 50);
            addButton.setFocusable(false);

            addButton.addActionListener(e1 -> {
                if(brandInput.getText().equals("") || modelInput.getText().equals("") || licensePlateInput.getText().equals("") || productionYearInput.getText().equals("") || mileageInput.getText().equals("") || fuelInput.getText().equals("") || VINInput.getText().equals("") || priceInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All inputs need to be completed!", "Adding car",JOptionPane.ERROR_MESSAGE);
                }else {
                    carController.addCar(brandInput.getText(), modelInput.getText(), licensePlateInput.getText(), Long.parseLong(productionYearInput.getText()), Long.parseLong(mileageInput.getText()), fuelInput.getText(), VINInput.getText(), priceListController.searchByPrice(Double.parseDouble(priceInput.getText())));
                    JOptionPane.showMessageDialog(null, "Car was successfully added", "Adding car", JOptionPane.INFORMATION_MESSAGE);
                }
                brandInput.setText("");
                modelInput.setText("");
                licensePlateInput.setText("");
                productionYearInput.setText("");
                mileageInput.setText("");
                fuelInput.setText("");
                VINInput.setText("");
                priceInput.setText("");
            });
            addCarPanel.removeAll();

            addingCarFrame.add(addCarPanel);
            addCarPanel.add(addLabel);
            addCarPanel.add(helpLabel2);
            addCarPanel.add(brandLabel);
            addCarPanel.add(brandInput);
            addCarPanel.add(modelLabel);
            addCarPanel.add(modelInput);
            addCarPanel.add(licensePlateLabel);
            addCarPanel.add(licensePlateInput);
            addCarPanel.add(productionYearLabel);
            addCarPanel.add(productionYearInput);
            addCarPanel.add(mileageLabel);
            addCarPanel.add(mileageInput);
            addCarPanel.add(fuelLabel);
            addCarPanel.add(fuelInput);
            addCarPanel.add(VINLabel);
            addCarPanel.add(VINInput);
            addCarPanel.add(priceLabel);
            addCarPanel.add(priceInput);
            addCarPanel.add(addButton);

        });


/***************************************REMOVING CAR**************************************************************/

        JLabel removingCarLabel = new JLabel("      Removing Car   ");
        removingCarLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton removingCarButton = new JButton("Remove");
        removingCarButton.setBounds(100, 600, 100, 50);
        removingCarButton.setFocusable(false);
        removingCarButton.addActionListener(e -> {
            JPanel removeCarPanel = new JPanel();
            JLabel VINLabel = new JLabel("Enter car's VIN: ");
            JTextField VINInput = new JTextField();
            JButton removeButton = new JButton("Remove");

            removingCarFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            removingCarFrame.setSize(420, 200);
            removingCarFrame.setResizable(false);
            removingCarFrame.setVisible(true);

            VINInput.setPreferredSize(new Dimension(160,30));

            removeButton.setBounds(100, 400, 100, 50);
            removeButton.setFocusable(false);

            removeButton.addActionListener(e1 -> {
                if(VINInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Remove car",JOptionPane.ERROR_MESSAGE);
                }else {
                    List<Car> carList = carController.searchCarByFullVIN(VINInput.getText());
                    if(carList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "There is no car with that VIN!", "Remove car",JOptionPane.ERROR_MESSAGE);
                    }else {
                        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to delete car: " + carList.toString() + " permanently?", "Remove car", JOptionPane.YES_NO_OPTION);
                        if(answer == 1){
                            removingCarFrame.toBack();
                        }else if(answer == 0){
                            carController.deleteCar(carList.get(0));
                            JOptionPane.showMessageDialog(null, "Car was successfully removed", "Remove car", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                VINInput.setText("");
            });
            removeCarPanel.removeAll();

            removingCarFrame.add(removeCarPanel);
            removeCarPanel.add(VINLabel);
            removeCarPanel.add(VINInput);
            removeCarPanel.add(removeButton);

        });



/***************************************SEARCHING PERSON BY PESEL**************************************************************/

        JLabel searchPersonByPeselLabel = new JLabel("Search person by pesel ");
        searchPersonByPeselLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton searchPersonByPeselButton = new JButton("Search");
        searchPersonByPeselButton.setBounds(100, 600, 100, 50);
        searchPersonByPeselButton.setFocusable(false);
        searchPersonByPeselButton.addActionListener(e -> {
            JPanel searchPersonByPeselPanel = new JPanel();
            JLabel peselLabel = new JLabel("Enter person's pesel: ");
            JTextField peselInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchPersonByPeselFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchPersonByPeselFrame.setSize(420, 200);
            searchPersonByPeselFrame.setResizable(false);
            searchPersonByPeselFrame.setVisible(true);

            peselInput.setPreferredSize(new Dimension(160,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                List<Person> personList = personController.searchPersonByPesel(peselInput.getText());
                if(peselInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Person you searched",JOptionPane.ERROR_MESSAGE);
                }else if(personList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no person with that pesel!", "Person you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, personList.toString(), "Person you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                peselInput.setText("");
            });
            searchPersonByPeselPanel.removeAll();

            searchPersonByPeselFrame.add(searchPersonByPeselPanel);
            searchPersonByPeselPanel.add(peselLabel);
            searchPersonByPeselPanel.add(peselInput);
            searchPersonByPeselPanel.add(searchButton);

        });



/***************************************ADDING PERSON**************************************************************/

        JLabel addingPersonLabel = new JLabel("        Add Person        ");
        addingPersonLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton addingPersonButton = new JButton("   Add   ");
        addingPersonButton.setBounds(100, 600, 100, 50);
        addingPersonButton.setFocusable(false);
        addingPersonButton.addActionListener(e -> {
            JPanel addPersonPanel = new JPanel(new GridLayout(7, 2, 10, 7));
            JLabel addLabel = new JLabel("ADDING PERSON");
            //addLabel.setHorizontalTextPosition(JLabel.CENTER);
            addLabel.setHorizontalAlignment(JLabel.CENTER);
            //addLabel.setVerticalTextPosition(JLabel.TOP);
            addLabel.setVerticalAlignment(JLabel.TOP);
            addLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
            //addLabel.setIconTextGap(-65);

            JLabel peselLabel = new JLabel("Enter Person's pesel: ");
            JTextField peselInput = new JTextField();
            JLabel nameLabel = new JLabel("Enter Person's name:");
            JTextField nameInput = new JTextField();
            JLabel surnameLabel = new JLabel("Enter Person's surname:");
            JTextField surnameInput = new JTextField();
            JLabel emailLabel = new JLabel("Enter Person's email:");
            JTextField emailInput = new JTextField();
            JLabel phoneNumberLabel = new JLabel("Enter Person's phone number:");
            JTextField phoneNumberInput = new JTextField();
            JLabel helpLabel2 = new JLabel("");
            JButton addButton = new JButton("Add");

            addingPersonFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            addingPersonFrame.setSize(420, 480);
            addingPersonFrame.setResizable(false);
            addingPersonFrame.setVisible(true);

            peselInput.setPreferredSize(new Dimension(100,30));
            nameInput.setPreferredSize(new Dimension(100,30));
            surnameInput.setPreferredSize(new Dimension(100,30));
            emailInput.setPreferredSize(new Dimension(100,30));
            phoneNumberInput.setPreferredSize(new Dimension(100,30));

            addButton.setBounds(100, 400, 100, 50);
            addButton.setFocusable(false);

            addButton.addActionListener(e1 -> {
                if(peselInput.getText().equals("") || nameInput.getText().equals("") || surnameInput.getText().equals("") || emailInput.getText().equals("") || phoneNumberInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All inputs need to be completed!", "Adding person",JOptionPane.ERROR_MESSAGE);
                }else {
                    personController.addPerson(peselInput.getText(), nameInput.getText(), surnameInput.getText(), emailInput.getText(), Long.parseLong(phoneNumberInput.getText()));
                    JOptionPane.showMessageDialog(null, "Person was successfully added", "Adding person", JOptionPane.INFORMATION_MESSAGE);
                }
                peselInput.setText("");
                nameInput.setText("");
                surnameInput.setText("");
                emailInput.setText("");
                phoneNumberInput.setText("");
            });
            addPersonPanel.removeAll();

            addingPersonFrame.add(addPersonPanel);
            addPersonPanel.add(addLabel);
            addPersonPanel.add(helpLabel2);
            addPersonPanel.add(peselLabel);
            addPersonPanel.add(peselInput);
            addPersonPanel.add(nameLabel);
            addPersonPanel.add(nameInput);
            addPersonPanel.add(surnameLabel);
            addPersonPanel.add(surnameInput);
            addPersonPanel.add(emailLabel);
            addPersonPanel.add(emailInput);
            addPersonPanel.add(phoneNumberLabel);
            addPersonPanel.add(phoneNumberInput);
            addPersonPanel.add(addButton);

        });


/***************************************REMOVING PERSON**************************************************************/

        JLabel removingPersonLabel = new JLabel(" Removing Person  ");
        removingPersonLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton removingPersonButton = new JButton("Remove");
        removingPersonButton.setBounds(100, 600, 100, 50);
        removingPersonButton.setFocusable(false);
        removingPersonButton.addActionListener(e -> {
            JPanel removePersonPanel = new JPanel();
            JLabel peselLabel = new JLabel("Enter person's pesel: ");
            JTextField peselInput = new JTextField();
            JButton removeButton = new JButton("Remove");

            removingPersonFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            removingPersonFrame.setSize(420, 200);
            removingPersonFrame.setResizable(false);
            removingPersonFrame.setVisible(true);

            peselInput.setPreferredSize(new Dimension(160,30));

            removeButton.setBounds(100, 400, 100, 50);
            removeButton.setFocusable(false);

            removeButton.addActionListener(e1 -> {
                if(peselInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Remove person",JOptionPane.ERROR_MESSAGE);
                }else {
                    List<Person> personList = personController.searchPersonByPesel(peselInput.getText());
                    if(personList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "There is no person with that pesel!", "Remove person",JOptionPane.ERROR_MESSAGE);
                    }else {
                        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to delete person: " + personList.toString() + " permanently?", "Remove person", JOptionPane.YES_NO_OPTION);
                        if(answer == 1){
                            removingPersonFrame.toBack();
                        }else if(answer == 0){
                            personController.deletePerson(personList.get(0));
                            JOptionPane.showMessageDialog(null, "Person was successfully removed", "Remove person", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                peselInput.setText("");
            });
            removePersonPanel.removeAll();

            removingPersonFrame.add(removePersonPanel);
            removePersonPanel.add(peselLabel);
            removePersonPanel.add(peselInput);
            removePersonPanel.add(removeButton);

        });



/***************************************SEARCHING RENT BY ID**************************************************************/

        JLabel searchRentByIdLabel = new JLabel("      Search Rent by id     ");
        searchRentByIdLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton searchRentByIdButton = new JButton("Search");
        searchRentByIdButton.setBounds(100, 600, 100, 50);
        searchRentByIdButton.setFocusable(false);
        searchRentByIdButton.addActionListener(e -> {
            JPanel searchRentByIdPanel = new JPanel();
            JLabel idLabel = new JLabel("Enter rent's id: ");
            JTextField idInput = new JTextField();
            JButton searchButton = new JButton("Search");

            searchRentByIdFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            searchRentByIdFrame.setSize(420, 200);
            searchRentByIdFrame.setResizable(false);
            searchRentByIdFrame.setVisible(true);

            idInput.setPreferredSize(new Dimension(100,30));

            searchButton.setBounds(100, 400, 100, 50);
            searchButton.setFocusable(false);

            searchButton.addActionListener(e1 -> {
                if(idInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Rent you searched",JOptionPane.ERROR_MESSAGE);
                }
                List<Rent> rentList = rentController.searchRentById(Long.parseLong(idInput.getText()));
                if(rentList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "There is no car with that id!", "Car you searched",JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, rentList.toString(), "Car you searched", JOptionPane.INFORMATION_MESSAGE);
                }
                idInput.setText("");
            });
            searchRentByIdPanel.removeAll();

            searchRentByIdFrame.add(searchRentByIdPanel);
            searchRentByIdPanel.add(idLabel);
            searchRentByIdPanel.add(idInput);
            searchRentByIdPanel.add(searchButton);
        });




/***************************************ADDING RENT**************************************************************/

        JLabel addingRentLabel = new JLabel("          Add Rent          ");
        addingRentLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton addingRentButton = new JButton("   Add   ");
        addingRentButton.setBounds(100, 600, 100, 50);
        addingRentButton.setFocusable(false);
        addingRentButton.addActionListener(e -> {
            JPanel addRentPanel = new JPanel(new GridLayout(6, 2, 10, 7));
            JLabel addLabel = new JLabel("ADDING RENT");
            addLabel.setHorizontalAlignment(JLabel.CENTER);
            addLabel.setVerticalAlignment(JLabel.TOP);
            addLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));

            JLabel employeeLabel = new JLabel("Enter Employee's id: ");
            JTextField employeeInput = new JTextField();
            JLabel issueDateLabel = new JLabel("Enter issue date (YYYY-MM-DD): ");
            JTextField issueDateInput = new JTextField();
            JLabel returnDateLabel = new JLabel("Enter return date (YYYY-MM-DD): ");
            JTextField returnDateInput = new JTextField();
            JLabel VINLabel = new JLabel("Enter car's VIN: ");
            JTextField VINInput = new JTextField();
            JLabel helpLabel2 = new JLabel("");
            JButton addButton = new JButton("Add");

            addingRentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            addingRentFrame.setSize(420, 440);
            addingRentFrame.setResizable(false);
            addingRentFrame.setVisible(true);

            employeeInput.setPreferredSize(new Dimension(100,30));
            issueDateInput.setPreferredSize(new Dimension(100,30));
            returnDateInput.setPreferredSize(new Dimension(100,30));
            VINInput.setPreferredSize(new Dimension(160,30));

            addButton.setBounds(100, 400, 100, 50);
            addButton.setFocusable(false);

            addButton.addActionListener(e1 -> {
                if(employeeInput.getText().equals("") || issueDateInput.getText().equals("") || returnDateInput.getText().equals("") || VINInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All inputs need to be completed!", "Adding rent",JOptionPane.ERROR_MESSAGE);
                }else {
                    rentController.addRent(Long.parseLong(employeeInput.getText()), LocalDate.parse(issueDateInput.getText()), LocalDate.parse(returnDateInput.getText()), carController.searchCarByVIN(VINInput.getText()).get(0));
                    JOptionPane.showMessageDialog(null, "Rent was successfully added", "Adding Rent", JOptionPane.INFORMATION_MESSAGE);
                }
                employeeInput.setText("");
                issueDateInput.setText("");
                returnDateInput.setText("");
                VINInput.setText("");
            });
            addRentPanel.removeAll();

            addingRentFrame.add(addRentPanel);
            addRentPanel.add(addLabel);
            addRentPanel.add(helpLabel2);
            addRentPanel.add(employeeLabel);
            addRentPanel.add(employeeInput);
            addRentPanel.add(issueDateLabel);
            addRentPanel.add(issueDateInput);
            addRentPanel.add(returnDateLabel);
            addRentPanel.add(returnDateInput);
            addRentPanel.add(VINLabel);
            addRentPanel.add(VINInput);
            addRentPanel.add(addButton);

        });




/***************************************REMOVING RENT**************************************************************/

        JLabel removingRentLabel = new JLabel("   Removing Rent      ");
        removingRentLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton removingRentButton = new JButton("Remove");
        removingRentButton.setBounds(100, 600, 100, 50);
        removingRentButton.setFocusable(false);
        removingRentButton.addActionListener(e -> {
            JPanel removeRentPanel = new JPanel();
            JLabel idLabel = new JLabel("Enter rent's id: ");
            JTextField idInput = new JTextField();
            JButton removeButton = new JButton("Remove");

            removingRentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            removingRentFrame.setSize(420, 200);
            removingRentFrame.setResizable(false);
            removingRentFrame.setVisible(true);

            idInput.setPreferredSize(new Dimension(100,30));

            removeButton.setBounds(100, 400, 100, 50);
            removeButton.setFocusable(false);

            removeButton.addActionListener(e1 -> {
                if(idInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Remove rent",JOptionPane.ERROR_MESSAGE);
                }else {
                    List<Rent> rentList = rentController.searchRentById(Long.parseLong(idInput.getText()));
                    if(rentList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "There is no rent with that id!", "Remove rent",JOptionPane.ERROR_MESSAGE);
                    }else {
                        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to delete rent: " + rentList.get(0).toString() + " permanently?", "Remove rent", JOptionPane.YES_NO_OPTION);
                        if(answer == 1){
                            removingRentFrame.toBack();
                        }else if(answer == 0){
                            rentController.deleteRent(rentList.get(0));
                            JOptionPane.showMessageDialog(null, "Rent was successfully removed", "Remove rent", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                idInput.setText("");
            });
            removeRentPanel.removeAll();

            removingRentFrame.add(removeRentPanel);
            removeRentPanel.add(idLabel);
            removeRentPanel.add(idInput);
            removeRentPanel.add(removeButton);

        });



/***************************************ADDING CLIENT**************************************************************/

        JLabel addingClientLabel = new JLabel("          Add Client             ");
        addingClientLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton addingClientButton = new JButton("   Add   ");
        addingClientButton.setBounds(100, 600, 100, 50);
        addingClientButton.setFocusable(false);
        addingClientButton.addActionListener(e -> {
            JPanel addClientPanel = new JPanel(new GridLayout(5, 2, 10, 7));
            JLabel addLabel = new JLabel("ADDING Client");
            //addLabel.setHorizontalTextPosition(JLabel.CENTER);
            addLabel.setHorizontalAlignment(JLabel.CENTER);
            //addLabel.setVerticalTextPosition(JLabel.TOP);
            addLabel.setVerticalAlignment(JLabel.TOP);
            addLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
            //addLabel.setIconTextGap(-65);

            JLabel licenseNumberLabel = new JLabel("Enter Client driver license number: ");
            JTextField licenseNumberInput = new JTextField();
            JLabel peselLabel = new JLabel("Enter Person's pesel:");
            JTextField peselInput = new JTextField();
            JLabel rentLabel = new JLabel("Enter Rent's id: ");
            JTextField rentInput = new JTextField();
            JLabel helpLabel2 = new JLabel("");
            JButton addButton = new JButton("Add");

            addingClientFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            addingClientFrame.setSize(420, 480);
            addingClientFrame.setResizable(false);
            addingClientFrame.setVisible(true);

            licenseNumberInput.setPreferredSize(new Dimension(100,30));
            peselInput.setPreferredSize(new Dimension(100,30));
            rentInput.setPreferredSize(new Dimension(100,30));

            addButton.setBounds(100, 400, 100, 50);
            addButton.setFocusable(false);

            addButton.addActionListener(e1 -> {
                if(peselInput.getText().equals("") || licenseNumberInput.getText().equals("") || rentInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "All inputs need to be completed!", "Adding client",JOptionPane.ERROR_MESSAGE);
                }else {
                    clientController.addClient(licenseNumberInput.getText(), personController.searchPersonByPesel(peselInput.getText()).get(0), rentController.searchRentById(Long.parseLong(rentInput.getText())).get(0));
                    JOptionPane.showMessageDialog(null, "Client was successfully added", "Adding client", JOptionPane.INFORMATION_MESSAGE);
                }
                licenseNumberInput.setText("");
                peselInput.setText("");
                rentInput.setText("");
            });
            addClientPanel.removeAll();

            addingClientFrame.add(addClientPanel);
            addClientPanel.add(addLabel);
            addClientPanel.add(helpLabel2);
            addClientPanel.add(licenseNumberLabel);
            addClientPanel.add(licenseNumberInput);
            addClientPanel.add(peselLabel);
            addClientPanel.add(peselInput);
            addClientPanel.add(rentLabel);
            addClientPanel.add(rentInput);
            addClientPanel.add(addButton);
        });




/***************************************REMOVING CLIENT**************************************************************/

        JLabel removingClientLabel = new JLabel("      Removing Client ");
        removingClientLabel.setVerticalTextPosition(JLabel.BOTTOM);

        JButton removingClientButton = new JButton("Remove");
        removingClientButton.setBounds(100, 600, 100, 50);
        removingClientButton.setFocusable(false);
        removingClientButton.addActionListener(e -> {
            JPanel removeClientPanel = new JPanel();
            JLabel peselLabel = new JLabel("Enter client's pesel: ");
            JTextField peselInput = new JTextField();
            JButton removeButton = new JButton("Remove");

            removingClientFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            removingClientFrame.setSize(420, 200);
            removingClientFrame.setResizable(false);
            removingClientFrame.setVisible(true);

            peselInput.setPreferredSize(new Dimension(100,30));

            removeButton.setBounds(100, 400, 100, 50);
            removeButton.setFocusable(false);

            removeButton.addActionListener(e1 -> {
                if(peselInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Remove client",JOptionPane.ERROR_MESSAGE);
                }else {
                    List<Client> clientList = clientController.searchClientByPesel(peselInput.getText());
                    if(clientList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "There is no client with that pesel!", "Remove client",JOptionPane.ERROR_MESSAGE);
                    }else {
                        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to delete client: " + clientList.get(0).toString() + " permanently?", "Remove client", JOptionPane.YES_NO_OPTION);
                        if(answer == 1){
                            removingClientFrame.toBack();
                        }else if(answer == 0){
                            clientController.deleteClient(clientList.get(0));
                            JOptionPane.showMessageDialog(null, "Client was successfully removed", "Remove client", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                peselInput.setText("");
            });
            removeClientPanel.removeAll();

            removingClientFrame.add(removeClientPanel);
            removeClientPanel.add(peselLabel);
            removeClientPanel.add(peselInput);
            removeClientPanel.add(removeButton);

        });


        contentPanel.add(titleLabel);
        contentPanel.add(searchCarByIdLabel);
        contentPanel.add(searchCarByIdButton);
        contentPanel.add(searchCarByModelLabel);
        contentPanel.add(searchCarByModelButton);
        contentPanel.add(searchCarByVINLabel);
        contentPanel.add(searchCarByVINButton);
        contentPanel.add(searchCarByBrandLabel);
        contentPanel.add(searchCarByBrandButton);
        contentPanel.add(printAllCarsLabel);
        contentPanel.add(printAllCarsButton);
        contentPanel.add(addingCarLabel);
        contentPanel.add(addingCarButton);
        contentPanel.add(removingCarLabel);
        contentPanel.add(removingCarButton);
        contentPanel.add(searchPersonByPeselLabel);
        contentPanel.add(searchPersonByPeselButton);
        contentPanel.add(addingPersonLabel);
        contentPanel.add(addingPersonButton);
        contentPanel.add(removingPersonLabel);
        contentPanel.add(removingPersonButton);
        contentPanel.add(searchRentByIdLabel);
        contentPanel.add(searchRentByIdButton);
        contentPanel.add(addingRentLabel);
        contentPanel.add(addingRentButton);
        contentPanel.add(removingRentLabel);
        contentPanel.add(removingRentButton);
        contentPanel.add(addingClientLabel);
        contentPanel.add(addingClientButton);
        contentPanel.add(removingClientLabel);
        contentPanel.add(removingClientButton);
        frame.add(contentPanel);

    }
}
