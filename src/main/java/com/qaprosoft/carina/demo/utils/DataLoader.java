package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.demo.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class DataLoader {
    public static User getRandomUser() {
        User user = new User();
        user.setEmail("test" + RandomUtils.nextInt(100, 999) + "@mail.ru");
        user.setGender(RandomUtils.nextInt(1, 2));
        user.setFirstname(RandomStringUtils.randomAlphabetic(10));
        user.setLastname(RandomStringUtils.randomAlphabetic(10));
        user.setPassword("123456789asdf");
        user.setAddress("6 Stone Hills St.");
        user.setCity("Gotham");
        user.setState(RandomUtils.nextInt(1, 50));
        user.setPostcode(String.valueOf(RandomUtils.nextInt(10000, 99999)));
        user.setMobilePhone(String.valueOf(RandomUtils.nextLong(1000000000, 1999999999)));
        return user;
    }

    public static Set<String> getListOfProducts() {
        Set<String> productList = new HashSet<>();
        productList.add("Sauce Lab Back Packs");
        if (MobileUtils.isIOS()) {
            productList.add("Sauce Lab Bike Light");
        }
        productList.add("Sauce Lab Bolt T-Shirt");
        productList.add("Sauce Lab Fleece T-Shirt");
        productList.add("Sauce Lab Onesie");
        productList.add("Test.");
        return productList;
    }

    public static SortedMap<String, Double> getMapOfProducts() {
        SortedMap<String, Double> productMap = new TreeMap<>();
        productMap.put("Sauce Lab Back Packs", 29.99);
        productMap.put("Sauce Lab Bike Light", 9.99);
        productMap.put("Sauce Lab Bolt T-Shirt", 15.99);
        productMap.put("Sauce Lab Fleece T-Shirt", 49.99);
        productMap.put("Sauce Lab Onesie", 7.99);
        if (MobileUtils.isIOS()) {
            productMap.put("Test.allTheThings() T-Shirt", 15.99);
        } else {
            productMap.put("Test.sllTheThings() T-Shirt", 15.99);
        }
        return productMap;
    }

}
