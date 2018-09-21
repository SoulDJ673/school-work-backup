package com.tsguild.llamamvc;

/**
 *
 * @author souldj673
 */
public class Llama {

    //Properties
    private int id;

    private String name;
    private String color;
    private String woolType;
    private String favHangoutSpot;

    private int age;
    private int weight;
    private int spitRange;
    private int overBP;
    private int underBP;

    private long numHairs;
    private boolean likesToKickJames;

    private double tongueLength;
    private double gpa;
    private double omegaSpit;

    //No Args
    public Llama() {
    }

    //Just ID
    public Llama(int id) {
        this.id = id;
    }

    //All Args
    public Llama(int id, String name, String color, String woolType, String favHangoutSpot, int age, int weight, int spitRange,
            int overBP, int underBP, long numHairs, boolean likesToKickJames, double tongueLength, double gpa, double omegaSpit) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.woolType = woolType;
        this.favHangoutSpot = favHangoutSpot;
        this.age = age;
        this.weight = weight;
        this.spitRange = spitRange;
        this.overBP = overBP;
        this.underBP = underBP;
        this.numHairs = numHairs;
        this.likesToKickJames = likesToKickJames;
        this.tongueLength = tongueLength;
        this.gpa = gpa;
        this.omegaSpit = omegaSpit;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWoolType() {
        return woolType;
    }

    public void setWoolType(String woolType) {
        this.woolType = woolType;
    }

    public String getFavHangoutSpot() {
        return favHangoutSpot;
    }

    public void setFavHangoutSpot(String favHangoutSpot) {
        this.favHangoutSpot = favHangoutSpot;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpitRange() {
        return spitRange;
    }

    public void setSpitRange(int spitRange) {
        this.spitRange = spitRange;
    }

    public int getOverBP() {
        return overBP;
    }

    public void setOverBP(int overBP) {
        this.overBP = overBP;
    }

    public int getUnderBP() {
        return underBP;
    }

    public void setUnderBP(int underBP) {
        this.underBP = underBP;
    }

    public long getNumHairs() {
        return numHairs;
    }

    public void setNumHairs(long numHairs) {
        this.numHairs = numHairs;
    }

    public boolean isLikesToKickJames() {
        return likesToKickJames;
    }

    public void setLikesToKickJames(boolean likesToKickJames) {
        this.likesToKickJames = likesToKickJames;
    }

    public double getTongueLength() {
        return tongueLength;
    }

    public void setTongueLength(double tongueLength) {
        this.tongueLength = tongueLength;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getOmegaSpit() {
        return omegaSpit;
    }

    public void setOmegaSpit(double omegaSpit) {
        this.omegaSpit = omegaSpit;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
