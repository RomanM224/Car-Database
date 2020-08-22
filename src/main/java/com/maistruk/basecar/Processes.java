package com.maistruk.basecar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

public class Processes {

    public void saveCar(Car car, String userId) throws IOException {
        ArrayList<Car> carList = loadCar(userId);
        carList.add(car);
        int id = 123;
        File file = new File("C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Cars" + userId + ".txt");
        file.delete();
        try {
            FileOutputStream fileStream = new FileOutputStream(
                    "C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Cars" + userId + ".txt", true);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(carList);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Car> loadCar(String userId) throws IOException {
        File file = new File("C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Cars" + userId + ".txt");
        ArrayList<Car> carList = new ArrayList<Car>();
        FileInputStream fileStream = null;
        ObjectInputStream os = null;

        try {
            if (file.length() != 0) {
                fileStream = new FileInputStream(file);

                os = new ObjectInputStream(fileStream);
                carList = (ArrayList<Car>) os.readObject();
                os.close();
                fileStream.close();
            }

        } catch (OptionalDataException e) {
            if (!e.eof)
                throw e;
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        finally{
            
        }
        return carList;
    }
    
    public void saveUser(User user) throws IOException {
        ArrayList<User> userList = loadUser();
        userList.add(user);
        File file = new File("C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Users.txt");
        file.delete();
        try {
            FileOutputStream fileStream = new FileOutputStream(
                    "C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Users.txt", true);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(userList);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> loadUser() throws IOException {
        File file = new File("C:\\Users\\roman\\e-workspace\\BaseCar\\target\\BaseCar\\WEB-INF\\classes\\Users.txt");
        ArrayList<User> userList = new ArrayList<User>();
        FileInputStream fileStream = null;
        ObjectInputStream os = null;

        try {
            if (file.length() != 0) {
                fileStream = new FileInputStream(file);
                os = new ObjectInputStream(fileStream);
                userList = (ArrayList<User>) os.readObject();
                System.out.println(userList);
                os.close();
            }

        } catch (OptionalDataException e) {
            if (!e.eof)
                throw e;
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return userList;
    }
    
}
