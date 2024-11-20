/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author thing
 */
public class Discount {
    private String nameDiscount;
    private String condition; 
    private String discountPercentage;
    private String idDiscount;
    private String dateStart;
    private String dateEnd;
    private String description;
    private String note;
    
     public Discount() {
    }
     
    public Discount(String idDiscount, String dateStart, String dateEnd, String nameDiscount, String condition, String discountPercentage,  String description, String note) {
        this.nameDiscount = nameDiscount;
        this.condition = condition;
        this.discountPercentage = discountPercentage;
        this.idDiscount = idDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
        this.note = note;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    
    public String getdiscountPercentage() {
        return discountPercentage;
    }
    public void setdiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
