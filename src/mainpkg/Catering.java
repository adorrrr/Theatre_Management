/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class Catering implements Serializable{
    
    private int NumberOfPeople;
    private LocalDate Date;
    private String MealItem;
    private String MealOfTheDay;
    private int Cost;

    public Catering(int NumberOfPeople, LocalDate Date, String MealItem, String MealOfTheDay, int Cost) {
        this.NumberOfPeople = NumberOfPeople;
        this.Date = Date;
        this.MealItem = MealItem;
        this.MealOfTheDay = MealOfTheDay;
        this.Cost = Cost;
    }

    public int getNumberOfPeople() {
        return NumberOfPeople;
    }

    public void setNumberOfPeople(int NumberOfPeople) {
        this.NumberOfPeople = NumberOfPeople;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public String getMealItem() {
        return MealItem;
    }

    public void setMealItem(String MealItem) {
        this.MealItem = MealItem;
    }

    public String getMealOfTheDay() {
        return MealOfTheDay;
    }

    public void setMealOfTheDay(String MealOfTheDay) {
        this.MealOfTheDay = MealOfTheDay;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    @Override
    public String toString() {
        return "Catering{" + "NumberOfPeople=" + NumberOfPeople + ", Date=" + Date + ", MealItem=" + MealItem + ", MealOfTheDay=" + MealOfTheDay + ", Cost=" + Cost + '}';
    }

 
}